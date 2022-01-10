package org.al_cc.TradeMe.use_cases.user;

import org.al_cc.shared_kernel.exceptions.NoSuchEntityException;
import org.al_cc.shared_kernel.exceptions.NotValidAttributeException;
import org.al_cc.shared_kernel.exceptions.PaymentException;

import javax.json.Json;
import javax.validation.ValidationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorsMapper implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {
        int code = 500;

        if (exception instanceof WebApplicationException)
            code = ((WebApplicationException) exception).getResponse().getStatus();

        else if (exception instanceof NotValidAttributeException)
            code = Response.Status.NOT_ACCEPTABLE.getStatusCode();

        else if (exception instanceof NoSuchEntityException)
            code = Response.Status.NOT_FOUND.getStatusCode();

        else if (exception instanceof ValidationException)
            code = Response.Status.NOT_ACCEPTABLE.getStatusCode();

        else if (exception instanceof PaymentException)
            code = 424;

        else throw exception;

        return Response.status(code)
                       .entity(Json.createObjectBuilder()
                                   .add("error", exception.getMessage())
                                   .add("code", String.valueOf(code))
                                   .build()
                       )
                       .build();
    }

}

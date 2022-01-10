package org.al_cc.TradeMe.use_cases.user.exposition;

import org.al_cc.TradeMe.use_cases.user.application.AddressDTO;
import org.al_cc.TradeMe.use_cases.user.application.PaymentDTO;
import org.al_cc.TradeMe.use_cases.user.application.command.CreateUser;
import org.al_cc.TradeMe.use_cases.user.application.query.RetrieveUserById;
import org.al_cc.TradeMe.use_cases.user.application.query.RetrieveUsers;
import org.al_cc.TradeMe.use_cases.user.application.query.RetrieveUsersByCity;
import org.al_cc.TradeMe.use_cases.user.domain.User;
import org.al_cc.TradeMe.use_cases.user.domain.UserId;
import org.al_cc.shared_kernel.CommandBus;
import org.al_cc.shared_kernel.QueryBus;
import org.al_cc.shared_kernel.annotations.Controller;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@ApplicationScoped
@Path("/users")
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private final CommandBus commandBus;
    private final QueryBus   queryBus;
    private final UserResponseAdapter userResponseAdapter;

    public UserController(CommandBus commandBus, QueryBus queryBus, UserResponseAdapter userResponseAdapter) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.userResponseAdapter = userResponseAdapter;

    }

    @GET()
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAll() {
        final List<User> users = queryBus.send(new RetrieveUsers());
        UsersResponse usersResponseResult = new UsersResponse(
                users.stream().map(userResponseAdapter::adapt).collect(Collectors.toList())
        );
        return Response.ok(usersResponseResult).build();
    }

    @GET()
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        final User user = queryBus.send(new RetrieveUserById(id));
        UserResponse userResponseResult = userResponseAdapter.adapt(user);
        return Response.ok(userResponseResult).build();
    }

    @GET()
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/city")
    public Response getByCity(@QueryParam("city") String city) {
        final List<User> users = queryBus.send(new RetrieveUsersByCity(city));
        UsersResponse usersResponseResult = new UsersResponse(
                users.stream().map(userResponseAdapter::adapt).collect(Collectors.toList())
        );
        return Response.ok(usersResponseResult).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid UserRequest request) {
        LOGGER.info("Registering User" + "\n");

        CreateUser createUser = new CreateUser(
                request.lastname,
                request.firstname,
                request.login,
                request.password,
                request.memberType,
                new AddressDTO(
                        request.address.city,
                        request.address.country,
                        request.address.street,
                        request.address.zipcode),
                request.mail,
                new PaymentDTO(request.payment.methodOfPayment, request.payment.subscriptionPlan, request.payment.transactionId)
        );

        UserId userId = commandBus.send(createUser);

        return Response.created(URI.create("/users/" + userId.getValue())).build();
    }

}

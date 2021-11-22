package org.al;

import org.al.EBusinessApp.controller.MemberController;
import org.al.common.domain.address.AddressFactory;
import org.al.common.domain.member.Member;
import org.al.common.domain.member.MemberBuilder;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        System.out.println("-----------Program Starting ------------\n");

        System.out.println("Simulate request for Persona 1 the tradesman");
        Member person1 = MemberBuilder.builder()
                                      .withFirstName("MICKAEL")
                                      .withLastName("AKNINE")
                                      .withPassword("azerty")
                                      .withMemberType("tradesman")
                                      .withAddress(AddressFactory.create(
                                              "PARIS",
                                              "FRANCE",
                                              "19 avenue de paris",
                                              "75000"))
                                      .withPayment()
                                      .creditCardNumber("4978124567881234")
                                      .expirationDate(LocalDate.of(2022, 11, 1))
                                      .ccv("123")
                                      .end()
                                      .build();

        MemberController.addMember(person1);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulate request for Persona 2 the contractor");
        Member person2 = MemberBuilder.builder()
                                      .withFirstName("KAEL")
                                      .withLastName("NINE")
                                      .withPassword("azerty")
                                      .withMemberType("contractor")
                                      .withAddress(AddressFactory.create(
                                              "NICE",
                                              "FRANCE",
                                              "19 avenue de nice",
                                              "42000"))
                                      .withPayment()
                                      .creditCardNumber("5478143217881234")
                                      .expirationDate(LocalDate.of(2024, 10, 1))
                                      .ccv("456")
                                      .end()
                                      .build();

        MemberController.addMember(person2);
    }

}
package com.example.application.endpoints;

import com.github.javafaker.Faker;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Endpoint
@AnonymousAllowed
public class CustomerEndpoint {

    private final List<Customer> customers;

    public CustomerEndpoint() {
        customers = new ArrayList<>(generateCustomers(5));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer add(String name, String email) {
        var customer = new Customer(UUID.randomUUID(), name, email);
        customers.add(customer);
        return customer;
    }

    private List<Customer> generateCustomers(int num) {
        Faker faker = new Faker();

        return IntStream.range(0, num).mapToObj(i ->
                new Customer(
                        UUID.randomUUID(),
                        faker.name().fullName(),
                        faker.internet().emailAddress()
                )
        ).toList();
    }
}

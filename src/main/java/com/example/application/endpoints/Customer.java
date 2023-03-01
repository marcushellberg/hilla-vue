package com.example.application.endpoints;

import java.util.UUID;

public record Customer(UUID id, String name, String email) {
}

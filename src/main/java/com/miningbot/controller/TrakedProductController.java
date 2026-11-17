package com.miningbot.controller;

import com.miningbot.dto.CreateTrackedProductRequest;
import com.miningbot.model.TrackedProduct;
import com.miningbot.repository.TrackedProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tracked-products")
public class TrakedProductController {
    private final TrackedProductRepository repository;

    public TrakedProductController(TrackedProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrackedProduct create(@RequestBody CreateTrackedProductRequest request) {
        if(request.name() == null || request.name().isBlank()) {
            throw new IllegalArgumentException("Product Name is required");
        }
        if (request.url() == null || !request.url().startsWith("https://")) {
            throw new IllegalArgumentException("A valid HTTP URL is required");
        }

        return repository.save(
                request.name(),
                request.url(),
                request.store(),
                request.targetPrice()
        );
    }

    public List<TrackedProduct> findAll() {
        return repository.findAllActive();
    }
}

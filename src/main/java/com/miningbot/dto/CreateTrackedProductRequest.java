package com.miningbot.dto;

public record CreateTrackedProductRequest(
        String name,
        String url,
        String store,
        Double targetPrice
) {
}

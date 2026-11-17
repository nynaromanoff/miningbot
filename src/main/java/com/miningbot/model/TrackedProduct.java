package com.miningbot.model;

import java.time.LocalDateTime;

public record TrackedProduct (
    Long id,
    String name,
    String url,
    String store,
    Double targetPrice,
    boolean active,
    LocalDateTime createdAt

){}

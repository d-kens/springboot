package com.example.springboot;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {}

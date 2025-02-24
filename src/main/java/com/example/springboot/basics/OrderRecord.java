package com.example.springboot.basics;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {
}

package com.project.spring_otel_observability_lab.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.spring_otel_observability_lab.services.OrderService;
import com.project.spring_otel_observability_lab.services.PaymentService;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final OrderService orderService;
    private final PaymentService paymentService;

    public DemoController(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @GetMapping("/orders")
    public String orders() throws InterruptedException {
        return orderService.processOrder();
    }

    @GetMapping("/payments")
    public String payments() {
        return paymentService.processPayment();
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}


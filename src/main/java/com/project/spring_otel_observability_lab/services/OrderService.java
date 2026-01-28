package com.project.spring_otel_observability_lab.services;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final Tracer tracer;

    public OrderService(Tracer tracer) {
        this.tracer = tracer;
    }

    public String processOrder() throws InterruptedException {
        // Create custom span
        Span checkInventorySpan = tracer.spanBuilder("check-inventory").startSpan();
        try (Scope scope = checkInventorySpan.makeCurrent()) {
            checkInventorySpan.setAttribute("inventory.items", 10);
            checkInventorySpan.setAttribute("inventory.location", "warehouse-1");
            simulateWork(50);
        } finally {
            checkInventorySpan.end();
        }

        // Another custom span
        Span validateOrderSpan = tracer.spanBuilder("validate-order").startSpan();
        try (Scope scope = validateOrderSpan.makeCurrent()) {
            validateOrderSpan.setAttribute("order.validation", "passed");
            validateOrderSpan.addEvent("order-validated");
            simulateWork(100);
        } finally {
            validateOrderSpan.end();
        }

        return "Order processed successfully";
    }

    private void simulateWork(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}

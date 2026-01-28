package com.project.spring_otel_observability_lab.services;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

import java.time.Duration;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Timer paymentTimer;

    public PaymentService(MeterRegistry registry) {
        this.paymentTimer = Timer.builder("payment.processing.duration")
            .serviceLevelObjectives(
                Duration.ofMillis(100),  // 0.1s
                Duration.ofMillis(500),  // 0.5s  
                Duration.ofSeconds(1),
                Duration.ofSeconds(2),
                Duration.ofSeconds(5)
    )   
    .register(registry);
    }

    public String processPayment() {
        return paymentTimer.record(() -> {
            simulateWork(200);
            return "Payment successful";
        });
    }

    private void simulateWork(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

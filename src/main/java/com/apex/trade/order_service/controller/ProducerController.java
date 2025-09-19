package com.apex.trade.order_service.controller;

import com.apex.trade.order_service.service.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish/{message}")
    public String publish(@PathVariable String message) {
        kafkaProducer.sendMessage("my-topic", message);
        return "Message sent: " + message;
    }
}

package com.example.rabbitMQpublisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    private final RabbitTemplate rabbitTemplate;

    public PublisherController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @GetMapping("/send")
    public String get(@RequestParam String msg){
        rabbitTemplate.convertAndSend("mack", msg);

        return "message sent";
    }

    @GetMapping("/fast")
    public String fast(@RequestParam String msg){
        rabbitTemplate.convertAndSend("fast", msg);
        return "sent";
    }
}

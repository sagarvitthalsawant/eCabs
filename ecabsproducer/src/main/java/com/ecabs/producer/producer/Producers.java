package com.ecabs.producer.producer;

import com.ecabs.producer.model.Bookings;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producers {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    public void produce(Bookings bookings){
        amqpTemplate.convertAndSend(exchange, bookings.toString(), bookings);
        System.out.println("Send msg = " + bookings);
    }
}

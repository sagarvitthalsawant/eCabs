package com.ecabs.consumer.consumers;

import com.ecabs.consumer.model.Bookings;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    @RabbitListener(queues="${spring.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(Bookings bookings) {
        System.out.println("Recieved Message: " + bookings);
    }
}

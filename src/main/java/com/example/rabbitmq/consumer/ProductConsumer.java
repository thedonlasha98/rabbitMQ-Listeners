package com.example.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

    @RabbitListener(queues = "register")
    private void registerProduct(String productName) {
        System.out.println("product is registered: " + productName);
    }

//    @RabbitListener(queues = "delete")
//    private void deleteProduct(String productName) {
//        System.out.println("product is deleted: " + productName);
//    }

    @RabbitListener(id = "delete product",
            bindings = @QueueBinding(value = @Queue(value = "delete"),
                    exchange = @Exchange(value = "topic"),
                    key = "product.delete"))
    private void keyProduct(String productName) {
        System.out.println("product is deleted: " + productName);
    }
}

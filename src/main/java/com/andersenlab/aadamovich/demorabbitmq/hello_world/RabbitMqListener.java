package com.andersenlab.aadamovich.demorabbitmq.hello_world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.andersenlab.aadamovich.demorabbitmq.hello_world.ConstantDataClass.QUEUE_NAME;

@EnableRabbit
@Component
public class RabbitMqListener {

    Logger logger = LogManager.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = QUEUE_NAME)
    public void processQueue(String message) {
        logger.info("Message from " + QUEUE_NAME + message);
    }
}

package com.andersenlab.aadamovich.demorabbitmq.topic_exchange;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.andersenlab.aadamovich.demorabbitmq.topic_exchange.ConstantDataClass.*;

@Component
public class RabbitMqListener {

    Logger logger = LogManager.getLogger(RabbitMqListener.class);
    Random random = new Random();

    @RabbitListener(queues = QUEUE_NAME_1)
    public void worker1(String message) {
        String worker = "WORKER1";
        logWork(message, worker, QUEUE_NAME_1);
    }

    @RabbitListener(queues = QUEUE_NAME_2)
    public void worker2(String message) {
        String worker = "WORKER2";
        logWork(message, worker, QUEUE_NAME_2);
    }

    private void logWork(String message, String worker, String queueName) {
        try {
            long sleep = 100 * random.nextInt(20);
            Thread.sleep(sleep);
            logger.info(String.format("Message from %s | %s | Processing by %s | Sleep: %s", queueName, message, worker, sleep));
        } catch (InterruptedException e) {
            logger.error("Something went wrong!", e);
        }
    }
}

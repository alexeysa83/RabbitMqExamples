package com.andersenlab.aadamovich.demorabbitmq.work_queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.andersenlab.aadamovich.demorabbitmq.work_queue.ConstantDataClass.QUEUE_NAME;

@Component
public class RabbitMqListener {

    Logger logger = LogManager.getLogger(RabbitMqListener.class);
    Random random = new Random();

    @RabbitListener(queues = QUEUE_NAME)
    public void worker1(String message) {
        String worker = "Worker1";
        logWork(message, worker);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void worker2(String message) {
        String worker = "Worker2";
        logWork(message, worker);
    }

    private void logWork(String message, String worker) {
        logger.info(String.format("Message from %s: %s! Processing by %s", QUEUE_NAME, message, worker));
        try {
            Thread.sleep(100 * random.nextInt(20));
        } catch (InterruptedException e) {
            logger.error("Something went wrong!", e);
        }
    }
}

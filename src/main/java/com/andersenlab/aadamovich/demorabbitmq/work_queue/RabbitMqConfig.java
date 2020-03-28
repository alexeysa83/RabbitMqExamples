package com.andersenlab.aadamovich.demorabbitmq.work_queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.andersenlab.aadamovich.demorabbitmq.work_queue.ConstantDataClass.QUEUE_NAME;

@Configuration
public class RabbitMqConfig {

    Logger logger = LogManager.getLogger(RabbitMqConfig.class);

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }


    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }
}

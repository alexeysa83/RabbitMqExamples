package com.andersenlab.aadamovich.demorabbitmq.topic_exchange;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.andersenlab.aadamovich.demorabbitmq.topic_exchange.ConstantDataClass.*;

@Configuration
public class RabbitMqConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_NAME_1, false);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_NAME_2, false);
    }

    @Bean
    public TopicExchange directExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding errorBinding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("error.*");
    }

    @Bean
    public Binding errorBiding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("error.#");
    }
}

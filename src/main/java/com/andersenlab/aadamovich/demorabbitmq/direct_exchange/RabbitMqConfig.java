package com.andersenlab.aadamovich.demorabbitmq.direct_exchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.andersenlab.aadamovich.demorabbitmq.direct_exchange.ConstantDataClass.*;

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
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding errorBinding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("error");
    }

    @Bean
    public Binding errorBiding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("error");
    }

    @Bean
    public Binding infoBinding() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("info");
    }

    @Bean
    public Binding commandBinding() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("command");
    }
}

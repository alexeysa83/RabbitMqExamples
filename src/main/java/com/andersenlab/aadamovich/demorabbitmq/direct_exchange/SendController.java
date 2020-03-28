package com.andersenlab.aadamovich.demorabbitmq.direct_exchange;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

import static com.andersenlab.aadamovich.demorabbitmq.direct_exchange.ConstantDataClass.EXCHANGE_NAME;

@Controller
public class SendController {

    private final Logger logger = LogManager.getLogger(SendController.class);
    private final Random random = new Random();

    @Autowired
    private RabbitTemplate template;

    @RequestMapping("/send")
    @ResponseBody
    String helloQueue() {
        logger.info("Sending to ... " + EXCHANGE_NAME);
        template.setExchange(EXCHANGE_NAME);
        for (int i = 1; i < 11; i++) {
            String routingKey = selectRoutingKey();
            template.convertAndSend(routingKey,String.format("Direct message №%d Key: %s", i,routingKey));
        }
        return "Return from Controller!";
    }

    private String selectRoutingKey() {
        switch (random.nextInt(3)) {
            case 0:
                return "error";
            case 1:
                return "info";
            case 2:
                return "command";
            default:
                return null;
        }
    }
}

package com.andersenlab.aadamovich.demorabbitmq.publish_subscribe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.andersenlab.aadamovich.demorabbitmq.publish_subscribe.ConstantDataClass.EXCHANGE_NAME;

@Controller
public class SendController {

    Logger logger = LogManager.getLogger(SendController.class);

    @Autowired
    RabbitTemplate template;

    @RequestMapping("/send")
    @ResponseBody
    String helloQueue() {
        logger.info("Sending to ... " + EXCHANGE_NAME);
        template.setExchange(EXCHANGE_NAME);
        for (int i = 1; i < 11; i++) {
            template.convertAndSend("Exchange message №" + i);
        }
        return "Return from Controller!";
    }
}

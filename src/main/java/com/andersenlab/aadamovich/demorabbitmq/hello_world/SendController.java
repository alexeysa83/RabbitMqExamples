package com.andersenlab.aadamovich.demorabbitmq.hello_world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.andersenlab.aadamovich.demorabbitmq.hello_world.ConstantDataClass.QUEUE_NAME;

@Controller
public class SendController {

    Logger logger = LogManager.getLogger(SendController.class);

    @Autowired
    AmqpTemplate template;

    @RequestMapping("/send")
    @ResponseBody
    String helloQueue() {
        logger.info("Sending to ... " + QUEUE_NAME);
        template.convertAndSend(QUEUE_NAME, "Hello, world!");
        return "Return from Controller!";
    }


}

package com.example.rabbitmq.producer;

import com.example.rabbitmq.configuration.RabbitConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/test")
public class LogController {

    final String LV_DEBUG = "debug";
    final String LV_INFO = "info";
    final String LV_ERROR = "error";

    private final RabbitTemplate rabbitTemplate;

    public LogController(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value="/log", method = RequestMethod.POST )
    public String debug(HttpServletRequest request, @RequestBody LogParam params) {
        if( LV_DEBUG.equals(params.getType()) ) {
            rabbitTemplate.convertAndSend(
                    RabbitConfiguration.EXCHANGE_NAME,
                    RabbitConfiguration.ROUTE_KEY_DEBUG, params.getMessage() );
        } else if ( LV_INFO.equals(params.getType()) ) {
            rabbitTemplate.convertAndSend(
                    RabbitConfiguration.EXCHANGE_NAME,
                    RabbitConfiguration.ROUTE_KEY_INFO, params.getMessage() );
        } else if ( LV_ERROR.equals(params.getType()) ) {
            rabbitTemplate.convertAndSend(
                    RabbitConfiguration.EXCHANGE_NAME,
                    RabbitConfiguration.ROUTE_KEY_ERROR, params.getMessage() );
        } else {
            return "NOK " + params.getType();
        }
        return "OK";
    }
}

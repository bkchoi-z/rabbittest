package com.example.rabbitmq.consumer;

import com.example.rabbitmq.configuration.RabbitConfiguration;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LogAllConsumer {

    @RabbitListener(queues = RabbitConfiguration.QUEUE_ALL)
    public void all(final Message message) {
        System.out.println( "ALL : " + new String(message.getBody()) );
    }

    @RabbitListener(queues = RabbitConfiguration.QUEUE_DEBUG)
    public void debug(final Message message) {
        System.out.println( "DEBUG : " + new String(message.getBody()) );
    }

    @RabbitListener(queues = RabbitConfiguration.QUEUE_INFO)
    public void info(final Message message) {
        System.out.println( "INFO : " + new String(message.getBody()) );
    }

    @RabbitListener(queues = RabbitConfiguration.QUEUE_ERROR)
    public void error(final Message message) {
        System.out.println( "ERROR : " + new String(message.getBody()) );
    }
}

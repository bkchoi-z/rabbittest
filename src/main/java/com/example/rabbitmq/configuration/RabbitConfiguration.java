package com.example.rabbitmq.configuration;

import com.example.rabbitmq.util.BeanUtil;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    public static final String EXCHANGE_NAME = "logger.topic";

    public static final String QUEUE_ALL = "queue.all";
    public static final String QUEUE_DEBUG = "queue.debug";
    public static final String QUEUE_INFO = "queue.info";
    public static final String QUEUE_ERROR = "queue.error";

    public static final String ROUTE_KEY_ALL = "log.#";
    public static final String ROUTE_KEY_DEBUG = "log.debug";
    public static final String ROUTE_KEY_INFO = "log.info";
    public static final String ROUTE_KEY_ERROR = "log.error";


    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Queue queueAll() {
        return new Queue(QUEUE_ALL, false);
    }
    @Bean
    Queue queueDebug() {
        return new Queue(QUEUE_DEBUG, false);
    }
    @Bean
    Queue queueInfo() {
        return new Queue(QUEUE_INFO, false);
    }
    @Bean
    Queue queueError() {
        return new Queue(QUEUE_ERROR, false);
    }

    @Bean
    Binding bindingAll(TopicExchange topicExchange){
        return BindingBuilder
                .bind((Queue)BeanUtil.getBean("queueAll"))
                .to(topicExchange)
                .with(ROUTE_KEY_ALL);
    }
    @Bean
    Binding bindingDebug(TopicExchange topicExchange){
        return BindingBuilder
                .bind((Queue)BeanUtil.getBean("queueDebug"))
                .to(topicExchange)
                .with(ROUTE_KEY_DEBUG);
    }
    @Bean
    Binding bindingInfo(TopicExchange topicExchange){
        return BindingBuilder
                .bind((Queue)BeanUtil.getBean("queueInfo"))
                .to(topicExchange)
                .with(ROUTE_KEY_INFO);
    }
    @Bean
    Binding bindingError(TopicExchange topicExchange){
        return BindingBuilder
                .bind((Queue)BeanUtil.getBean("queueError"))
                .to(topicExchange)
                .with(ROUTE_KEY_ERROR);
    }
}

package com.cable.rest.config;

import lombok.extern.log4j.Log4j;

import org.jasypt.digest.PooledStringDigester;
import org.jasypt.digest.StringDigester;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@Configuration  
@EnableAutoConfiguration
@EnableJpaRepositories(value = {"com.cable.rest.repository"})
@EntityScan(value = {"com.cable.rest.model"})
@ComponentScan("com.cable.rest")
@Log4j

// This class is the entry point of the application.
public class RestApplication {
   
	@Value("${queue.name}")
    String queueName ;

    @Bean
    MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate template(ConnectionFactory connectionFactory, MessageConverter converter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(converter);
        return template;
    }
    
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }
    
    @Bean
    MessageListenerAdapter listenerAdapter(Listener listener, MessageConverter converter) {
        return new MessageListenerAdapter(listener, converter);
    }
    
    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);

    }

}
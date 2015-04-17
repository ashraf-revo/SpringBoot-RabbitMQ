package com.cable.rest.config;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j;

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
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.cable.rest.security.CableFilter;


@Configuration  
@EnableAutoConfiguration
@ComponentScan("com.cable.rest")
@Log4j
@ImportResource("classpath:security.xml" )
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
    Queue queue() {
        return new Queue(queueName, true);
    }
    
    @Bean
    public FilterRegistrationBean authorizationFilter(){
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new CableFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        return filterRegBean;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);

    }

}
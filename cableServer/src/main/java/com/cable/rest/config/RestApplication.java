package com.cable.rest.config;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.log4j.Log4j;

import org.jasypt.digest.PooledStringDigester;
import org.jasypt.digest.StringDigester;
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
   
    @Bean
   	StringDigester PasswordHash() {
   		final PooledStringDigester stringDigester = new PooledStringDigester();
   		stringDigester.setAlgorithm("SHA-256");
   		stringDigester.setIterations(100000);
   		//stringDigester.
   		stringDigester.setSaltSizeBytes(10);
   		stringDigester.setPoolSize(4);
   		stringDigester.initialize();
   		return stringDigester;
   		
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
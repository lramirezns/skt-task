package com.skytouch.configuration;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(RabbitConfigurationProperties.class)
class RabbitMqConfig {

    RabbitConfigurationProperties configurationProperties;

    RabbitMqConfig(RabbitConfigurationProperties configurationProperties){
        this.configurationProperties = configurationProperties;
    }

    @Bean
    @Qualifier("insertQueue")
    Queue insertQueue() {
        return new Queue(configurationProperties.getInsertQueue(), false);
    }

    @Bean
    @Qualifier("getProductsQueue")
    Queue getProductsQueue() {
        return new Queue(configurationProperties.getGetProductsQueue(), false);
    }

    @Bean
    @Qualifier("insertExchange")
    DirectExchange insertExchange() {
        return new DirectExchange(configurationProperties.getInsertExchange());
    }

    @Bean
    @Qualifier("getProductsExchange")
    DirectExchange getProductsExchange() {
        return new DirectExchange(configurationProperties.getGetProductsExchange());
    }

    @Bean
    Binding insertBinding(@Qualifier("insertQueue") Queue queue, @Qualifier("insertExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(configurationProperties.getInsertRoutingkey());
    }

    @Bean
    Binding getProductsBinding(@Qualifier("getProductsQueue") Queue queue, @Qualifier("getProductsExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(configurationProperties.getGetProductsRoutingkey());
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory productFactory(ConnectionFactory connectionFactory,
                                                               SimpleRabbitListenerContainerFactoryConfigurer configurer) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

}

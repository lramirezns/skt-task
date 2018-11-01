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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {


    @Value("${product.rabbitmq.insertQueue}")
    String insertQueueName;

    @Value("${product.rabbitmq.insertExchange}")
    String insertExchange;

    @Value("${product.rabbitmq.insertRoutingkey}")
    private String insertRoutingkey;

    @Value("${product.rabbitmq.getProductsExchange}")
    String getProductsExchange;

    @Value("${product.rabbitmq.getProductsQueue}")
    String getProductsQueueName;

    @Value("${product.rabbitmq.getProductsRoutingkey}")
    private String getProductsRoutingkey;

    @Bean
    @Qualifier("insertQueue")
    Queue insertQueue() {
        return new Queue(insertQueueName, false);
    }

    @Bean
    @Qualifier("getProductsQueue")
    Queue getProductsQueue() {
        return new Queue(getProductsQueueName, false);
    }

    @Bean
    @Qualifier("insertExchange")
    DirectExchange insertExchange() {
        return new DirectExchange(insertExchange);
    }

    @Bean
    @Qualifier("getProductsExchange")
    DirectExchange getProductsExchange() {
        return new DirectExchange(getProductsExchange);
    }

    @Bean
    Binding insertBinding(@Qualifier("insertQueue") Queue queue, @Qualifier("insertExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(insertRoutingkey);
    }

    @Bean
    Binding getProductsBinding(@Qualifier("getProductsQueue") Queue queue, @Qualifier("getProductsExchange") DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(getProductsRoutingkey);
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

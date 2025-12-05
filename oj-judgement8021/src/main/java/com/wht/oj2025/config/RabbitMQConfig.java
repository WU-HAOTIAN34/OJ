package com.wht.oj2025.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {


    @Bean
    public RabbitTemplate rabbitTemplateConfig(ConnectionFactory connectionFactory) {

        RabbitTemplate template = new RabbitTemplate(connectionFactory);

        // 设置消息确认回调（Broker收到消息后的ACK/NACK）
        template.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                System.out.println("消息投递到交换机成功：" + correlationData);
            } else {
                System.err.println("消息投递到交换机失败，原因：" + cause);
                // 在这里触发重试逻辑
            }

        });

        // 设置消息未路由时的回退回调（exchange->queue失败）
        template.setReturnsCallback(returned -> {
            System.err.println("⚠️ 消息未路由到队列：" + returned.getMessage());
        });

        return template;
    }
}

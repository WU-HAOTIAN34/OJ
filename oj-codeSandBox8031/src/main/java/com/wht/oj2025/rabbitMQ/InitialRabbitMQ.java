package com.wht.oj2025.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import java.util.*;

@Slf4j
public class InitialRabbitMQ {


    public static void doInit() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String EXCHANGE_NAME = "code_exchange";

            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
            channel.exchangeDeclare("order_dlx_exchange", "direct", true);

            Map<String, Object> args = new HashMap<>();
            args.put("x-dead-letter-exchange", "order_dlx_exchange");
            args.put("x-dead-letter-routing-key", "order.dead");


            channel.queueDeclare("order_dead_queue", true, false, false, null);
            channel.queueBind("order_dead_queue", "order_dlx_exchange", "order.dead");

            // 创建队列，随机分配一个队列名称
            String queueName = "code_queue";
            channel.queueDeclare(queueName, true, false, false, args);
            channel.queueBind(queueName, EXCHANGE_NAME, "my_routingKey");
            log.info("消息队列启动成功");
        } catch (Exception e) {
            log.error("消息队列启动失败");
        }
    }

    public static void main(String[] args) {
        doInit();
    }
}

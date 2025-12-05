package com.wht.oj2025.rabbitMQ;


import jakarta.annotation.Resource;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class QuestionProducer {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public boolean sendMessage(String exchange, String routingKey, String message) {
//        rabbitTemplateConfig.convertAndSend(exchange, routingKey, message, msg -> {
//            msg.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
//            return msg;
//        });
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());

        int maxRetry = 3;
        for (int i = 1; i <= maxRetry; i++) {
            try {
                rabbitTemplate.convertAndSend(exchange, routingKey, message, msg -> {
                    msg.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return msg;
                }, correlationData);

                // 等待回调异步返回，可以用 CountDownLatch 等机制（简化起见这里略）
                CorrelationData.Confirm confirm = correlationData.getFuture().get(5, TimeUnit.SECONDS);
                boolean ack = confirm.isAck();

                if (ack) {
                    System.out.println("第 " + i + " 次发送成功, ID=" + correlationData.getId());
                    return true;
                } else {
                    System.err.println("第 " + i + " 次发送失败 (Broker NACK)，重试中...");
                }
            } catch (Exception e) {
                System.err.println("第 " + i + " 次发送异常：" + e.getMessage());
                if (i == maxRetry) {
                    System.err.println("发送失败超过最大次数，记录到本地日志或数据库。");
                }
                try {
                    Thread.sleep(1000 * i); // 简单退避等待
                } catch (InterruptedException ignored) {}
            }
        }
        return false;

    }
}

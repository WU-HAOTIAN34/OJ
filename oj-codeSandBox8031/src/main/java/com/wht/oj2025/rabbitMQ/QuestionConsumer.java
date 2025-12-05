package com.wht.oj2025.rabbitMQ;


import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.Channel;
import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.sandBox.CodeSandBox;
import com.wht.oj2025.sandBox.CodeSandBoxFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@Component
@Slf4j
public class QuestionConsumer {

    @Value("${sand-box-method:native}")
    private String sandBoxMethod;

//    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
//    public void consume(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
//
//        Integer retryCount = (Integer) message.getMessageProperties().getHeaders().get("retry-count");
//        retryCount = retryCount == null ? 0 : retryCount;
//
//        log.info("receiveMessage message = {}", message);
//        long questionSubmitId = Long.parseLong(message);
//        try {
//            CodeSandBoxDTO codeSandBoxDTO = JSONUtil.toBean(message, CodeSandBoxDTO.class);
//            CodeSandBox codeSandBox = CodeSandBoxFactory.forInstance(codeSandBoxDTO.getLanguage(), sandBoxMethod);
//            channel.basicAck(deliveryTag, false);
//        } catch (Exception e) {
//            channel.basicNack(deliveryTag, false, true);
//        }
//    }

    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL", concurrency = "5-10")
    public void consume(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {

        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        Map<String, Object> headers = message.getMessageProperties().getHeaders();

        Integer retryCount = (Integer) headers.get("retry-count");
        retryCount = retryCount == null ? 0 : retryCount;

        log.info("receiveMessage body = {}, retryCount = {}", body, retryCount);

        try {
            CodeSandBoxDTO codeSandBoxDTO = JSONUtil.toBean(body, CodeSandBoxDTO.class);
            CodeSandBox codeSandBox = CodeSandBoxFactory.forInstance(codeSandBoxDTO.getLanguage(), sandBoxMethod);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            log.error("消息消费异常，第 {} 次重试，错误信息: {}", retryCount, e.getMessage(), e);

            if (retryCount >= 3) {
                channel.basicNack(deliveryTag, false, false);
            } else {
                headers.put("retry-count", retryCount + 1);
                channel.basicNack(deliveryTag, false, true);
            }
        }
    }

}

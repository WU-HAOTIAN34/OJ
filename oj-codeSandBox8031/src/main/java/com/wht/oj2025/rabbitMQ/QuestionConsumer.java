package com.wht.oj2025.rabbitMQ;


import cn.hutool.json.JSONUtil;
import com.rabbitmq.client.Channel;
import com.wht.oj2025.dto.CodeSandBoxDTO;
import com.wht.oj2025.sandBox.CodeSandBox;
import com.wht.oj2025.sandBox.CodeSandBoxFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class QuestionConsumer {

    @Value("${sand-box-method:native}")
    private String sandBoxMethod;

    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
    public void consume(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("receiveMessage message = {}", message);
        long questionSubmitId = Long.parseLong(message);
        try {
            CodeSandBoxDTO codeSandBoxDTO = JSONUtil.toBean(message, CodeSandBoxDTO.class);
            CodeSandBox codeSandBox = CodeSandBoxFactory.forInstance(codeSandBoxDTO.getLanguage(), sandBoxMethod);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            channel.basicNack(deliveryTag, false, false);
        }
    }
}

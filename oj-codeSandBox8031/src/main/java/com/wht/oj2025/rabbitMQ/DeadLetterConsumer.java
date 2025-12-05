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
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
@Slf4j
public class DeadLetterConsumer {

    @RabbitListener(queues = {"order_dead_queue"}, ackMode = "MANUAL", concurrency = "5-10")
    public void consume(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {

        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        channel.basicAck(deliveryTag, false);
    }

}

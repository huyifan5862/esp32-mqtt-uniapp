package com.example.esp32mqtt.consumer;

import com.example.esp32mqtt.mapper.TestMapper;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(value = "spring.mqtt.enable", havingValue = "true")
public class MqttConsumer implements MessageHandler {
    static int weight = 0;
    static int preweight = 0;
    static int count = 0;
    static int kzCount=0;
    @Autowired
    TestMapper testMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        String topic = String.valueOf(message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC));
        String payload = String.valueOf(message.getPayload());
        weight = Integer.parseInt(payload);
        if(weight>0){
            kzCount = 0;
            if((weight-preweight<5)&&(weight-preweight>-5)){
//                如果当前重量和上一次重量相差5g以内，表示没有动
                count++;

                if(count>=600){
                    //超过10分钟，发送通知提醒

                }
            }
        }else {
//            如果当前为空载，计数加一，超过10分钟，发送通知提醒
            kzCount++;
            if(kzCount>=600){

            }
        }

        System.out.println(testMapper.selOne());
        logger.info("接收到 mqtt消息，主题:{} 消息:{}", topic, payload);
    }
}
package com.example.esp32mqtt.controller;


import com.example.esp32mqtt.mapper.TestMapper;
import com.example.esp32mqtt.producer.MqttProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MQTTController {
    @Autowired
    MqttProducer mqttProducer;
    @Autowired
    TestMapper testMapper;

    @PostMapping("/send")
    public Map send(String topic, String data) {
        System.out.println(topic);
        System.out.println(data);
        Map map = new HashMap<>();
        System.out.printf("开始发送mqtt消息,主题：{},消息：{}", topic, data);
        if (topic != null && !"".equals(topic)) {
            mqttProducer.sendToMqtt(data, topic);
//            mqttProducer.subscribe("wrwerwrewer");
            System.out.printf("发送mqtt消息完成,主题：{},消息：{}", topic, data);
            map.put("message", "execute successful");
            return map;
        } else {
            map.put("message", "topic is blank");
            return map;
        }
    }
    @RequestMapping("/addCid")
    public int insertClientId(String cid, String mobel) {
        try {
        testMapper.insertClientId(cid, mobel);
        return 1;
        }catch (Exception e){

            System.out.println(e);
            return 0;
        }


    }


}

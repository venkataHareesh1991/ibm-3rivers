package com.example.threerivers.kafka.producer;

import com.example.threerivers.kafka.BalanceData;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BalanceProducer {

    private static final String TOPIC = "three_river_balance";
    @Autowired
    private KafkaTemplate<String, BalanceData> kafkaTemplate;

    public void sendMessage(BalanceData message){

        this.kafkaTemplate.send(TOPIC,message);
    }

    @Bean
    public NewTopic createTopic(){

        return new NewTopic(TOPIC,3,(short) 1);
    }

}
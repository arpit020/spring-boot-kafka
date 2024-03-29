package com.kafka.apachekafka.kafka;


import com.kafka.apachekafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {



    @Value("${spring.kafka.topic.jsonName}")
    private String jsonTopicName;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.jsonName}" , groupId = "${spring.kafka.consumer.group-id}")
    public void listener(User user) {
        LOGGER.info(String.format("Json Object received => %s",user.toString()));

    }
}

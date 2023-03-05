package com.tricada.hiringtest.event;

import com.tricada.hiringtest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Configuration
public class UserProducerEvent {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Bean
    public NewTopic createNewTopic() {
        return TopicBuilder.name("userTopic").build();
    }

    public void sendMessage(User user) {
        log.info("user producer  : {} ", user);
        kafkaTemplate.send("userTopic", user);
    }
}

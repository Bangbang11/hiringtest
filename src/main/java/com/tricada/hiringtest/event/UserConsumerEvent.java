package com.tricada.hiringtest.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tricada.hiringtest.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Configuration
public class UserConsumerEvent {

    @KafkaListener(topics = "userTopic", groupId = "KafkaGroupDemo")
    public void userFromKafka(String userModel) throws JsonProcessingException {
        if (userModel != null) {
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(userModel, User.class);
            if (user.getAge() % 2 != 0) {
                log.info("Consumer user : {} ", "name : "+user.getName() + ", address : "+user.getAddress()
                        + ", phone : "+user.getPhone() + ", age : "+user.getAge());
            }
        }
    }
}

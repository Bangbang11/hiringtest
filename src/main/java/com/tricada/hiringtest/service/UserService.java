package com.tricada.hiringtest.service;

import com.tricada.hiringtest.dto.UserRequest;
import com.tricada.hiringtest.event.UserProducerEvent;
import com.tricada.hiringtest.model.User;
import com.tricada.hiringtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProducerEvent userProducerEvent;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void createUser(UserRequest userRequest) {
        User savedUser = transactionTemplate.execute(status -> {
            User newUser = new User();
            try {
                newUser.setName(userRequest.getName());
                newUser.setAddress(userRequest.getAddress());
                newUser.setPhone(userRequest.getPhone());
                newUser.setAge(userRequest.getAge());
                newUser = userRepository.save(newUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return newUser;
        });

        userProducerEvent.sendMessage(savedUser);
    }
}

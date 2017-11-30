package com.moogu.microservice.service;

import com.moogu.microservice.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private List<User> listAllUser = new ArrayList<>();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @HystrixCommand(fallbackMethod = "returnListFromCache")
    public List<User> findAll() {
        listAllUser.clear();
        listAllUser.addAll(userRepository.findAll());
        return listAllUser;
    }

    public List<User> returnListFromCache() {
        return listAllUser;
    }
}

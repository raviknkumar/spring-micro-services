package com.example.order_service.clients.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.order_service.dto.User;

@Service
//@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserClientImpl implements UserClient {

    @Qualifier ("loadBalancedRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getUser(String userId) {
        User user = restTemplate.getForObject("http://USER-SERVICE/user-service/users/{userId}", User.class, userId);
        return user;
    }
}

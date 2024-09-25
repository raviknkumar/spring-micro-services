package com.example.order_service.clients.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.order_service.dto.User;

//@FeignClient (name = "USER-SERVICE")
@FeignClient (name = "${user-service.name}")
public interface UserRestClient {

    //@GetMapping ("/user-service/users/{userId}")
    @GetMapping ("${user-service.endpoints.get-user.url}")
    User getUser(@PathVariable("userId") String userId);

    //@PostMapping("/users-service/users")
    //UserDto createUser(@RequestBody UserDto user);

    /*
    @PostMapping("/users-service/users/{userId}/attributes")
    UserAttributeDto createUserAttribute(@RequestBody UserAttributeDto user,
            @PathVariable("userId") String userId); */

    // get user attribute
    //@GetMapping("/user-service/attributes/{userId}")
    //List<UserAttributes> getUserAttributes(@PathVariable("userId") String userId);
}

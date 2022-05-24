package com.example.instana.controller;

import com.example.instana.controller.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${env.status}")
    private String envStatus;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/user")
    public UserDto getUser() throws Exception {

        if (envStatus.equals("dev")) {
            throw new Exception("error");
        }else{
            logger.info("success");
        }

        return new UserDto("poscoict", "gyeonggi");
    }

//    @GetMapping("/error")
//    public void getError() throws Exception {
//        throw new Exception("error");
//    }
}

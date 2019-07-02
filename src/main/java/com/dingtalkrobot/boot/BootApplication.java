package com.dingtalkrobot.boot;

import com.dingtalkrobot.boot.service.dingtalk.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class BootApplication {


    public static void main(String[] args) {
//        RobotService.test();
        SpringApplication.run(BootApplication.class, args);
    }


}

package com.dingtalkrobot.boot;

import com.dingtalkrobot.boot.service.dingtalk.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component

public class ApplicationStartup  implements ApplicationRunner {
    @Autowired
    RobotService robotService;
    @Override
/**
 *@Author: huhy
 *@Package_name:com.huhy.web.common.runner
 *@Date:13:29 2018/1/3
 *@Description: ApplicationRunner方式实现
 */
    public void run(ApplicationArguments applicationArguments) throws Exception {
//        robotService.test();

    }
}
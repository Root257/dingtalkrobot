package com.dingtalkrobot.boot.controller;

import com.dingtalkrobot.boot.gitlab.PushHook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebHook {
    private static final String PUSH_EVENT = "Push Hook";
    @PostMapping("/send")
    public void  send(@RequestHeader("X-Gitlab-Event") String event, @RequestBody String body) {
        System.out.println(event);
        System.out.println(body);
        if (PUSH_EVENT.equals(event)) {
            PushHook pushHook =  PushHook.parseObject(body);
            System.out.println(pushHook);
        }

    }
}

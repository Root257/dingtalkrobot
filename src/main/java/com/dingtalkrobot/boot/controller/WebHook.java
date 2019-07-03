package com.dingtalkrobot.boot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalkrobot.boot.gitlab.PushHook;
import com.dingtalkrobot.boot.service.dingtalk.RobotService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebHook {
    private static final String MERGE_REQUEST = "merge_request";
    @Autowired
    RobotService robotService;


    @PostMapping("/send")
    public void  send(@RequestHeader("X-Gitlab-Event") String event, @RequestBody String body) {

        if(body.contains(MERGE_REQUEST) == true){
            //System.out.println(body);

            JSONObject  MergeRequestHook = JSON.parseObject(body);
            JSONObject  ObjectAttributes =  JSON.parseObject(MergeRequestHook.getString("object_attributes"))  ;
             String  source  =ObjectAttributes.getString("source_branch");
            String  target = ObjectAttributes.getString("target_branch");
            String  url  =  ObjectAttributes.getString("url");
            robotService.mergeRequest(source,target,url);
        }
    }
}

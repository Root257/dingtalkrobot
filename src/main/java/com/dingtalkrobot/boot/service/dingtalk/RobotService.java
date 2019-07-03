package com.dingtalkrobot.boot.service.dingtalk;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service

public class RobotService {
    @Value("${WEB_HOOK}")
    public String webhook;
    @Value("${ASSIGNEE}")
    public String assignee;

    public  void  mergeRequest(String source,String target,String url){

        DingTalkClient client = new DefaultDingTalkClient(webhook);

        OapiRobotSendRequest request = new OapiRobotSendRequest();


        request.setMsgtype("markdown");
        OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
        markdown.setTitle("Gitlab合并请求");
        markdown.setText("#### Gitlab合并请求 @"+assignee+"\n" +
                "> 目标分支："+ target+"\n\n" +
                "> 源分支："+ source+"\n\n"  +
                "> [合并请求地址](" +url+ ")\n");
        request.setMarkdown(markdown);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        at.setAtMobiles(Arrays.asList(assignee));
        request.setAt(at);


        try{
            OapiRobotSendResponse response = client.execute(request);
        }
        catch (ApiException exception){

        }

    }
}

package com.dingtalkrobot.boot.gitlab;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class PushHook {
    private String before;
    private String after;
    private String ref;
    @JSONField(name = "user_id")
    private Integer userId;
    @JSONField(name = "user_name")
    private String userName;
    @JSONField(name = "user_username")
    private String userUsername;
    @JSONField(name = "user_email")
    private String userEmail;
    @JSONField(name = "user_avatar")
    private String userAvatar;
    @JSONField(name = "project_id")
    private Integer projectId;
    private List<Commit> commits;
    @JSONField(name = "total_commits_count")
    private Integer totalCommitsCount;
    public static PushHook parseObject(String json) {
        return JSON.parseObject(json, PushHook.class);
    }
}

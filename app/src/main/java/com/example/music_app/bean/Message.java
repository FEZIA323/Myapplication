package com.example.music_app.bean;

import androidx.room.Entity;

@Entity
public class Message {

    private Long id;

    public Long createTime;  // 创建时间
    public String content;  // 内容
    public String role;  // 角色
    public String icon;  // 图像
    public Long belong;  // 归属（属于哪一个聊天）
    public Long answer;  // 答案（对应的答案是哪个）
    public int status = Constant.MESSAGE_SEND;  // 消息状态
    public int type = Constant.MESSAGE_QUESTION;  // 消息的类型

    public Message(Long id, Long createTime, String content, String role,
                   Long belong, Long answer, int status, int type) {
        this.id = id;
        this.createTime = createTime;
        this.content = content;
        this.role = role;
        this.belong = belong;
        this.answer = answer;
        this.status = status;
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public Message() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getRole() {
        return this.role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Long getBelong() {
        return this.belong;
    }
    public void setBelong(Long belong) {
        this.belong = belong;
    }
    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Long getAnswer() {
        return this.answer;
    }
    public void setAnswer(Long answer) {
        this.answer = answer;
    }
    public int getType() {
        return this.type;
    }
    public void setType(int type) {
        this.type = type;
    }



}


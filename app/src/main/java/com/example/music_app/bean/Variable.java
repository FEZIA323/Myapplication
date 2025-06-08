package com.example.music_app.bean;

public class Variable {

    public static boolean DebugMode = true;  // 调试模式
    public static Chat nowChat;  // 当前的聊天
    public static Message lastestSend;
    public static Message lastestReceive;
    public static boolean isAsking = false;  // 是否正在提问
    public static int frequency = 60;  // 当前上报频度
}

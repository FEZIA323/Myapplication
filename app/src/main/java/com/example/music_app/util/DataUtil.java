package com.example.music_app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    // long 时间戳（毫秒）转 str 日期
    public static String stamp2Date(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 要转的格式

        Date date = new Date(s);//(s + 28800000);
        res = simpleDateFormat.format(date);
        return res;
    }

}

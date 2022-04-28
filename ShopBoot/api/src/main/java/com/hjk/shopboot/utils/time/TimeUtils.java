package com.hjk.shopboot.utils.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getCurrentTime() {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        return format1.format(time);
    }
}

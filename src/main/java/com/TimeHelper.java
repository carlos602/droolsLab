package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by masy on 2016/3/18.
 */
public class TimeHelper {
    public static void printTime(){
        DateFormat dateFormat= new SimpleDateFormat("HH:mm:ss");
        Date date=new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(date));
    }
}

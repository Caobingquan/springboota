package com.springboota;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author {曹炳全}
 * @Title ScheduleTaskDemo
 * @Description
 * @date 2020/1/20 15:18
 */
@Component
public class ScheduleTaskDemo {

    private int num1 = 0;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * ?")
    public void test1(){
        System.out.println("这是test1方法第"+ (++num1) + "次执行，执行时间："+df.format(new Date()));
    }

}

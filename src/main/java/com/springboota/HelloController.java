package com.springboota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author {曹炳全}
 * @Title HelloController
 * @Description
 * @date 2020/1/19 16:39
 */
@RestController
public class HelloController {
    @Autowired
    MyApplication myApplication;

    @Value("${cc}")
    private int cc;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(myApplication.toString());
        System.out.println(cc);
        return "hello world";
    }

}

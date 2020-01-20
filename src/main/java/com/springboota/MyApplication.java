package com.springboota;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author {曹炳全}
 * @Title MyApplication
 * @Description
 * @date 2020/1/19 15:57
 */
@PropertySource("classpath:user.yml")
@ConfigurationProperties(prefix = "user")
@Component
@Data
public class MyApplication {
    private int aa;
    private String bb;
    @Override
    public String toString() {
        return bb+"工号"+aa+"为您服务";
    }
}

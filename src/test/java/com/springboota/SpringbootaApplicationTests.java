package com.springboota;

import com.springboota.mapper.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
@Slf4j
@SpringBootTest
class SpringbootaApplicationTests {
    @Resource
    private UserRepository userRepository;
    @Autowired
    EmailSenderServiceImpl emailSenderService;

    @Test
    void contextLoads() {
        long a= 1;
        User b = userRepository.findById(a).get();
        log.warn(b.toString());
        System.out.println(b);
    }

    @Test
    public void pageSelect() {
        int currentPage = 0;
        int pageSize = 3;
        //分页查询
        Pageable page = PageRequest.of(currentPage, pageSize);
        Page<User> pageObject = userRepository.findAll(page);
        System.out.println(pageObject.get());
        System.out.println(pageObject.getContent());

    }
    @Test
    public void mail(){
//        emailSenderService.sendTextMail("测试","我是qq邮箱","cbq_5758609@163.com");
        emailSenderService.sendAttachmentMail("测试附件","我是qq邮箱","E:\\log\\myApp.log","这是秘密文件","cbq_5758609@163.com");
    }

}

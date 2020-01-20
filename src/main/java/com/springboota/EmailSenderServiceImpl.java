package com.springboota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author {曹炳全}
 * @Title EmailSenderServiceImpl
 * @Description
 * @date 2020/1/20 14:08
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发件人邮箱
     */
    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendTextMail(String subject, String content, String... to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setSentDate(new Date());
        javaMailSender.send(mailMessage);
    }

    @Override
    public void sendTextMail(String subject, String content, List<String> ccList, String... to) {
        //收件人地址
        InternetAddress[] addressesTo = new InternetAddress[to.length];
        if(to != null && to.length>0){
            for(int i=0;i<to.length;i++){
                InternetAddress addressTo = null;
                try {
                    addressTo = new InternetAddress(to[i]);
                    addressesTo[i] = addressTo;
                } catch (AddressException e) {
                    e.printStackTrace();
                }
            }
        }
        //抄送人地址
        InternetAddress[] addressesCc = new InternetAddress[ccList.size()];
        if(ccList != null && ccList.size() > 0){
            for(int i=0;i<ccList.size();i++){
                String ccAdd = ccList.get(i);
                InternetAddress address = null;
                try {
                    address = new InternetAddress(ccAdd);
                    addressesCc[i] = address;
                } catch (AddressException e) {
                    e.printStackTrace();
                }
            }
        }

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(from);
                mimeMessage.setSubject(subject);
                mimeMessage.setText(content);
                mimeMessage.setRecipients(Message.RecipientType.TO, addressesTo);
                mimeMessage.setRecipients(Message.RecipientType.CC, addressesCc);
            }
        };
        javaMailSender.send(preparator);
    }

    @Override
    public void sendAttachmentMail(String subject, String content, String filePath, String fileName, String... to) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            //附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(fileName,file);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

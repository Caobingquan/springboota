package com.springboota;

import java.util.List;

/**
 * @author {曹炳全}
 * @Title EmailSenderService
 * @Description
 * @date 2020/1/20 14:07
 */
public interface EmailSenderService {

    /**
     * 发送文本消息
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param to 收件人(可变参数，多个时用逗号隔开)
     */
    void sendTextMail(String subject, String content, String... to);

    /**
     * 发送一个邮件并抄送
     * @param subject 主题
     * @param content 内容
     * @param ccList 抄送人(可以有多个)
     * @param to 收件人(可以有多个)
     */
    void sendTextMail(String subject, String content, List<String> ccList, String... to);

    /**
     * 发送带附件邮件
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件的本地路径
     * @param fileName 附件名
     * @param to 收件人
     */
    void sendAttachmentMail(String subject, String content, String filePath, String fileName, String... to);
}

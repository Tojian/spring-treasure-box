package com.taojian.mail.service;

import org.springframework.stereotype.Service;

/**
 * @description: MailSender 接口
 * @author: taojian
 * @create: 2019-01-04 11:55
 **/
public interface MailSender {
    /**
     * 发送简单文本邮件
     *
     * @param title
     * @param content
     */
    public void sendTxtMail(String title, String content);

    /**
     * 发送html格式邮件
     *
     * @param title
     * @param content
     */
    public void sendHtmlMail(String title, String content);

    /**
     * 发送附件
     *
     * @param title
     * @param content
     */
    public void sendAttachmentsMail(String title, String content,String path);

    /**
     * 发送静态资源
     *
     * @param title
     * @param content
     */
    public void sendInlineMail(String title, String content, String path);

    /**
     * 发送邮件模版
     *
     * @param title
     * @param content
     */
    public void sendTemplateMail(String title, String content);

}

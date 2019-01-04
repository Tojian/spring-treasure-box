package com.taojian.mail.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @description: 邮件发送实现类
 * @author: taojian
 * @create: 2019-01-04 11:55
 **/
@Slf4j
@Service
public class MailSenderImpl implements MailSender {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${mail.sender.to}")
    private String to;

    @Override
    public void sendTxtMail(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            log.info("send simple mail done");
        } catch (Exception e) {
            log.error("send simple mail happen exception", e);
        }

    }

    @Override
    public void sendHtmlMail(String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            log.info("send html mail done");
        } catch (MessagingException e) {
            log.error("send html mail happen exception", e);
        }
    }

    @Override
    public void sendAttachmentsMail(String subject, String content,String path) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content);

            FileSystemResource file = new FileSystemResource(new File(path));
            helper.addAttachment("附件-1.jpg", file);
            helper.addAttachment("附件-2.jpg", file);
            mailSender.send(mimeMessage);
            log.info("send AttachmentsMail done ");
        } catch (Exception e) {
            log.error("send AttachmentsMail happen exception");
        }
    }

    @Override
    public void sendInlineMail(String subject, String content,String path) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(path));
            helper.addInline("tao", file);
            mailSender.send(mimeMessage);
            log.info("send InlineMail done ");
        } catch (Exception e) {
            log.error("send InlineMail happen exception");
        }

    }

    @Override
    public void sendTemplateMail(String title, String content) {
        try {
            //创建邮件正文
            Context context = new Context();
            context.setVariable("username", "taojian");
            String emailContent = templateEngine.process("email", context);
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(title);
            helper.setText(emailContent,true);

            mailSender.send(mimeMessage);
            log.info("send TemplateMail done ");
        } catch (Exception e) {
            log.error("send TemplateMail happen exception");
        }
    }

}

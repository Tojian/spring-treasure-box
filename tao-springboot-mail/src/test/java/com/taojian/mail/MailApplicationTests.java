package com.taojian.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    private TemplateEngine templateEngine;


    @Test
    public void sendTxtMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人
        simpleMailMessage.setTo("1099593012@qq.com");
        simpleMailMessage.setFrom("tj_since@163.com");
        simpleMailMessage.setSubject("Spring Boot Mail 邮件测试");
        simpleMailMessage.setText("这里是一段简单文本helloworld。");
        // 发送邮件
        mailSender.send(simpleMailMessage);
        System.out.println("邮件已发送");
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo("1099593012@qq.com");
        helper.setFrom("tj_since@163.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("/Users/taojian/Files/projectSofeware/github/spring-treasure-box/tao-springboot-mail/src/test/java/com/taojian/mail/tao.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);

    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("tj_since@163.com");
        helper.setTo("1099593012@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:tao\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("/Users/taojian/Files/projectSofeware/github/spring-treasure-box/tao-springboot-mail/src/test/java/com/taojian/mail/tao.jpg"));
        helper.addInline("tao", file);

        mailSender.send(mimeMessage);

    }
    @Test
    public void sendTemplateMail() throws MessagingException {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("username", "taojian");
        String emailContent = templateEngine.process("email", context);
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("tj_since@163.com");
        helper.setTo("1099593012@qq.com");
        helper.setSubject("邮件模版");
        helper.setText(emailContent);

        mailSender.send(mimeMessage);
    }

}
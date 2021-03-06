package com.noteapp.user.email;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "mail")
public class MailService {

    private JavaMailSender javaMailSender;

    private String subjectMessage;
    private String messageTitle;
    private String messageUsername;
    private String messageLink;
    private boolean isHtmlContent;
    private String tokenEndPoint;

    private String pathTemplate;



    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String to,
                         String username,
                         String token) throws MessagingException, IOException {

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true,"UTF-8");

        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subjectMessage);

        String htmlString = FileUtils.readFileToString(new File(pathTemplate));

        htmlString = htmlString.replace(messageUsername, username);
        htmlString = htmlString.replace(messageLink, tokenEndPoint + token);
        htmlString = htmlString.replace(messageTitle, "Welcome in FASTNOTE app  !");

        mimeMessageHelper.setText(htmlString, true);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }

}

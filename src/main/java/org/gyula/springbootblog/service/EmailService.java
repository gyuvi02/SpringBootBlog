package org.gyula.springbootblog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;
    private JavaMailSender javaMailSender;

//    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendMessage(String email) {
        SimpleMailMessage message = null;
        try {
            message = new SimpleMailMessage();
            message.setFrom(MESSAGE_FROM);
            message.setTo(email);
            message.setSubject("Sikeres regisztrálás");
            message.setText("Kedves " + email + "! \n \n Köszönjük, hogy regisztráltál az oldalunkra!");
            javaMailSender.send(message);

        } catch (Exception e) {
            log.error("Hiba e-mail küldéskor az alábbi címre: " + email + "  " + e);
        }


    }
}
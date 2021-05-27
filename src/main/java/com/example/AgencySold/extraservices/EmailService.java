package com.example.AgencySold.extraservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


@Service
@Transactional
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Async
    public void sendEmail() {

        SimpleMailMessage message = new SimpleMailMessage();
        // Необходимо указать адрес электронной почты отправителя
          message.setFrom("silverscjserge@gmail.com");

        // Необходимо указать адрес электронной почты получателя
        message.setTo("silverscjserge@gmail.com");

        // Установить тему: поле заголовка
        message.setSubject("AgencySold");

        //  сообщение
        message.setText("Thank you");
        javaMailSender.send(message);


    }
}
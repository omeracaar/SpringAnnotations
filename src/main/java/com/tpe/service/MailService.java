package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component//bu classtan bean olusturulsun
public class MailService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajiniz: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }
}

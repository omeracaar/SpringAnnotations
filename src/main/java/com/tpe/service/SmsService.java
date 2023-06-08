package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

@Component("smsservice")
public class SmsService implements MessageService{

    @PostConstruct// contructor metodu cagirildiktan sonra
    public void init(){
        System.out.println("SmsService objesi olusturuluyor");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("SmsService objesi imha edildi");
    }




    //Random rnd=new Random();
    // @Autowired
    //private Random random;

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir SMS servisiyim. Mesajiniz: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }

    //degiskenlerin degerlerini disardan vermek isteriz
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;

    public void printContact(){
        System.out.println("email: "+email);
        System.out.println("phone number: "+phone);
    }

    //degiskenlerin degerlerini disaridan vermek icin Properties classi
    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("contact: e-mail: "+properties.getProperty("mymail"));
    }


}

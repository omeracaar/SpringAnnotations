package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Spring ile calismak HARIKA olacak");

        //config class oku

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);

        //MessageService service=context.getBean(MailService.class);
        //MessageService service=context.getBean(MessageService.class);//Spring akilli
        //service.sendMessage(message);

        MessageService service1=context.getBean("smsService",MessageService.class);
        service1.sendMessage(message);

    }
}

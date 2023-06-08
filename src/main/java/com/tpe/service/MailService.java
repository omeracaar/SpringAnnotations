package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classtan bean olusturulsun, default::mailService
@Scope("prototype")//defaultta:Singleton
public class MailService implements MessageService{

    @PostConstruct// contructor metodu cagirildiktan sonra
    public void init(){
        System.out.println("MailService objesi olusturuluyor");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("MailService objesi imha edildi");
    }



//    @Autowired
//    @Qualifier("fileRepository")//enjekte edilecek birden fazla bean çeşidi var ise qualifier ile secim belirtilmek zorundaydayiz
//    private Repository repo;

    //setter ile injection
//    private Repository repo;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepo(Repository repo) {
//        this.repo = repo;
//    }

    //constructor injection: daha guvenli, daha anlasilir, test etmesi daha kolay
    private Repository repo;
    @Autowired//classin sadece bir tane  constructori var ise, zorunlu degil
    public MailService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir mail servisiyim. Mesajiniz: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //reponun objesine ihtiyac var
        repo.save(message);
    }
}

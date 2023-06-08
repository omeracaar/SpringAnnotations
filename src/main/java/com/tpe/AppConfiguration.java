package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classta config yapilacak
@ComponentScan("com.tpe")//bu package daki tum componentleri tara, deafult:com.tpe
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    private Environment environment;//Springin interface (Environment) application.properties
                                    // icindeki keylerin degerini okuyabilmemizi saglar


    @Bean//Random classindan Spring bean olusmasini saglar.
    public Random random(){
        return new Random();
    }

    //value annotation ile yaptıgımızı properties classi ile de yapabiliriz.

    @Bean
    public Properties properties(){
        Properties properties=new Properties();//hashtable extend eder
        properties.put("mymail",environment.getProperty("app.email"));
        //properties.put("mymail","app@gmail.com");



        return properties;
    }

}

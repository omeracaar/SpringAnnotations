package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration//bu classta config yapilacak
@ComponentScan("com.tpe")//bu package daki tum componentleri tara, deafult:com.tpe
public class AppConfiguration {

}

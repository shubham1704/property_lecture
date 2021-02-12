package com.example.property.lecture.propertybyspring;

import com.example.property.lecture.propertybyspring.exampleBeans.FakeDataSource;
import com.example.property.lecture.propertybyspring.exampleBeans.FakeJmsBroker;
import com.example.property.lecture.propertybyspring.exampleBeans.PropertyToBeInjectedByEnvVar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PropertyBySpringApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(PropertyBySpringApplication.class, args);

    //Property From properties File
    FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
    System.out.println(fakeDataSource.getUserName());

    //Property From properties File
    FakeJmsBroker jmsBroker = ctx.getBean(FakeJmsBroker.class);
    System.out.println(jmsBroker.getUsername());

    //Property injected from Environment Variable in IntelliJ
    PropertyToBeInjectedByEnvVar property = (PropertyToBeInjectedByEnvVar) ctx.getBean(PropertyToBeInjectedByEnvVar.class, args);
    System.out.println(property.getAwsUrl());


  }
}

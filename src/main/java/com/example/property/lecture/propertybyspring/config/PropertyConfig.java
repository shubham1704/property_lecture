package com.example.property.lecture.propertybyspring.config;

import com.example.property.lecture.propertybyspring.exampleBeans.FakeDataSource;
import com.example.property.lecture.propertybyspring.exampleBeans.FakeJmsBroker;
import com.example.property.lecture.propertybyspring.exampleBeans.PropertyToBeInjectedByEnvVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources ({
    @PropertySource ("classpath:datasource.properties"),
    @PropertySource ("classpath:jms.properties")
})
public class PropertyConfig {

  @Autowired
  Environment env;

  @Value ("${example.username}")
  private String userName;

  @Value ("${example.password}")
  private String password;

  @Value ("${example.url}")
  private String url;

  @Value ("${com.jms.username}")
  private String jmsUserName;

  @Value ("${com.jms.password}")
  private String jmsPassword;

  @Value ("${com.jms.url}")
  private String jmsUrl;

  @Bean
  public FakeJmsBroker jmsBroker() {
    FakeJmsBroker jmsBroker = new FakeJmsBroker();
    jmsBroker.setUsername(jmsUserName);
    jmsBroker.setPassword(jmsPassword);
    jmsBroker.setUrl(jmsUrl);
    return jmsBroker;
  }

  @Bean
  public FakeDataSource dataSource() {
    FakeDataSource dataSource = new FakeDataSource();
    dataSource.setUserName(userName);
    dataSource.setPassword(password);
    dataSource.setUrl(url);
    return dataSource;
  }

  @Bean
  public PropertyToBeInjectedByEnvVar envPropertyInjectionExample() {
    PropertyToBeInjectedByEnvVar property = new PropertyToBeInjectedByEnvVar();
    property.setAwsUrl(env.getProperty("awsUrl"));
    return property;
  }
}

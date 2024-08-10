package com.zjl.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication(scanBasePackages = {"com.zjl.cloud"})
public class OrderServiceApplication {

  public static void main(String[] args) {
      SpringApplication.run(OrderServiceApplication.class,args);
  }
}

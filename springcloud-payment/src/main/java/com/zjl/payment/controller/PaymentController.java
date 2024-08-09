package com.zjl.payment.controller;

import com.zjl.cloud.domain.Pay;
import com.zjl.payment.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/hello/{id}")
    public Pay hello(@PathVariable("id")Integer id){
        return paymentService.getOne(id);
    }
    //这里遇到的一个配置刷新的坑，就是每次要去调用这个@value.可以观察到变化
    @GetMapping("/config")
    public String getConsulConfig(@Value("${com}") String consul_config){
        return consul_config+System.currentTimeMillis();
    }

}

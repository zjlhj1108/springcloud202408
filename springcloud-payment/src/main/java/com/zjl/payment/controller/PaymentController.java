package com.zjl.payment.controller;

import com.zjl.cloud.domain.Pay;
import com.zjl.payment.service.PaymentService;
import jakarta.annotation.Resource;
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

}

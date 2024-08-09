package com.zjl.payment.service.impl;

import com.zjl.cloud.domain.Pay;
import com.zjl.cloud.mapper.PayMapper;
import com.zjl.payment.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PayMapper payMapper;
    @Override
    public Pay getOne(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }
}

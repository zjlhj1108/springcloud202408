package com.zjl.payment.service.impl;

import com.zjl.cloud.domain.Pay;
import com.zjl.cloud.mapper.PayMapper;
import com.zjl.payment.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PayMapper payMapper;
    @Override
    public Pay getOne(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addPay(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Pay> selectAll() {
        return payMapper.selectAll();
    }
}

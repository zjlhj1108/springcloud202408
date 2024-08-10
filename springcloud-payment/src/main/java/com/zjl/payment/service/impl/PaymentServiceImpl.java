package com.zjl.payment.service.impl;


import com.zjl.cloud.dto.PayDTO;
import com.zjl.cloud.result.ResultData;

import com.zjl.payment.domain.Pay;
import com.zjl.payment.mapper.PayMapper;
import com.zjl.payment.service.PaymentService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PayMapper payMapper;

    /**
     * 根据id查询支付流水
     * @param id
     * @return
     */
    @Override
    public ResultData<Pay> getOne(Integer id) {
        return ResultData.success(payMapper.selectByPrimaryKey(id));
    }

    /**
     * 插入支付流水
     * @param payDTO
     * @return
     */
    @Override
    public ResultData<Integer> addPay(PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        return ResultData.success(payMapper.insertSelective(pay));
    }

    /**
     * 更新支付流水
     * @param payDTO
     * @return
     */
    @Override
    public ResultData<Integer> update(PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        return ResultData.success(payMapper.updateByPrimaryKeySelective(pay));
    }

    /**
     * 删除订单根据id
     * @param id
     * @return
     */
    @Override
    public ResultData<Integer> delete(Integer id) {
        return ResultData.success(payMapper.deleteByPrimaryKey(id));
    }

    /**
     * 查询所有的支付流水
     * @return
     */
    @Override
    public ResultData<List<Pay>> selectAll() {
        return ResultData.success(payMapper.selectAll());
    }
}

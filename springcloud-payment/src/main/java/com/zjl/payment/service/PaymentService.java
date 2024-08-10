package com.zjl.payment.service;


import com.zjl.cloud.dto.PayDTO;
import com.zjl.cloud.result.ResultData;
import com.zjl.payment.domain.Pay;


import java.util.List;

public interface PaymentService {


    ResultData<Pay> getOne(Integer id);

    ResultData<Integer> addPay( PayDTO payDTO);

    ResultData<Integer> update(PayDTO payDTO);

    ResultData<Integer> delete(Integer id);

    ResultData<List<Pay>> selectAll();
}

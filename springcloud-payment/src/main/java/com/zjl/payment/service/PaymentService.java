package com.zjl.payment.service;

import com.zjl.cloud.domain.Pay;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public Pay getOne( Integer id);

}

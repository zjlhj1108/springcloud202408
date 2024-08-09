package com.zjl.payment.service;

import com.zjl.cloud.domain.Pay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {

    public Pay getOne( Integer id);
    public int addPay( Pay pay);

    int update(Pay pay);

    int delete(Integer id);

    List<Pay> selectAll();
}

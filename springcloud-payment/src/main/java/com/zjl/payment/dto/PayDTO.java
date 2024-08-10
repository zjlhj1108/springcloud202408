package com.zjl.payment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "支付订单的实体传值实体")
public class PayDTO implements Serializable
{
    @Schema(title = "订单实体的id")
    private Integer id;
    @Schema(title = "支付流水号")
    //支付流水号
    private String payNo;
    @Schema(title = "订单流水号")
    //订单流水号
    private String orderNo;
    @Schema(title = "用户账号ID")
    //用户账号ID
    private Integer userId;
    @Schema(title = "交易金额")
    //交易金额
    private BigDecimal amount;
}


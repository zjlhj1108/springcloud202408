package com.zjl.cloud.controller;

import com.zjl.cloud.dto.PayDTO;
import com.zjl.cloud.feignclient.OpenFeignCustomerClient;
import com.zjl.cloud.result.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name="openfeign消费者模块",description = "openfegin 消费者模块CURD")
@RestController
public class FeignConsumerController {
    @Resource
    OpenFeignCustomerClient openFeignCustomerClient;
    @Operation(summary = "查询所有",description = "消费者查询所有的订单")
    @GetMapping("/openfeign/customer/pay/selectAll")
    public ResultData getAllPay(){
        return openFeignCustomerClient.getAllPay();
    }

    @Operation(summary = "openfeign测试添加支付订单",description = "openfeign测试添加支付订单")
    @PostMapping("/openfeign/customer/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO){
        return openFeignCustomerClient.addPay(payDTO);
    }

    @Operation(summary = "查询所有",description = "消费者查询所有的订单")
    @PutMapping("/openfeign/customer/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        return openFeignCustomerClient.update(payDTO);
    }
    @Operation(summary = "openfeign根据id查询订单",description = "openfeign根据id查询订单")
    @GetMapping("/openfeign/customer/pay/get/{id}")
    public ResultData getOne(@PathVariable("id") Integer id){
        return openFeignCustomerClient.getOne(id);
    }

    @Operation(summary = "openfeign根据id查询订单",description = "openfeign根据id查询订单")
    @GetMapping("/openfeign/customer/pay/delete/{id}")
    public ResultData delete(@PathVariable("id") Integer id){
        return openFeignCustomerClient.delete(id);
    }

}

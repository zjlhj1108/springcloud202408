package com.zjl.cloud.feignclient;

import com.zjl.cloud.dto.PayDTO;
import com.zjl.cloud.result.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("payment-service")
public interface OpenFeignCustomerClient {
    @GetMapping("/pay/selectAll")
    ResultData getAllPay();
    @PostMapping("/pay/add")
    ResultData addPay(@RequestBody PayDTO payDTO);
    @PutMapping("/pay/update")
    ResultData update(@RequestBody PayDTO payDTO);
    @GetMapping("/pay/get/{id}")
    ResultData getOne(@PathVariable("id")Integer id);
    @GetMapping("/pay/get/{id}")
    ResultData delete(@PathVariable("id")Integer id);
}

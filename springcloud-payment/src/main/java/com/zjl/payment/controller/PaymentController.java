package com.zjl.payment.controller;

import com.zjl.cloud.domain.Pay;
import com.zjl.payment.dto.PayDTO;
import com.zjl.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="订单支付接口",description = "订单支付的api")
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Operation(summary = "订单查询接口",description = "根据id查询订单")
    @GetMapping("/pay/get/{id}")
    public Pay selectById(@PathVariable("id")Integer id){
        return paymentService.getOne(id);
    }
    @Operation(summary = "新增订单接口",description = "新增订单，参数是订单数据，json数据格式")
    @PostMapping("/pay/add")
    public int insert(@RequestBody Pay pay){
        return paymentService.addPay(pay);
    }

    @Operation(summary = "更新订单接口",description = "更新订单，参数是订单数据，json数据格式")
    @PutMapping("/pay/update")
    public int update(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        return paymentService.update(pay);
    }

    @Operation(summary = "删除订单接口",description = "删除订单，参数是订单的id")
    @DeleteMapping("/pay/delete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return paymentService.delete(id);
    }

    @Operation(summary = "查询订单接口",description = "查询所有订单")
    @GetMapping("/pay/selectAll/")
    public List<Pay> selectAll(@Parameter(name="无用的参数")String info){
        return paymentService.selectAll();
    }


    @Operation(summary = "测试consul的配置刷新功能",description = "测试consul的配置刷新功能")
    //这里遇到的一个配置刷新的坑，就是每次要去调用这个@value.可以观察到变化
    @GetMapping("/pay/info")
    public String getConsulConfig(@Value("${com}")String info){
        return info+System.currentTimeMillis();
    }

}

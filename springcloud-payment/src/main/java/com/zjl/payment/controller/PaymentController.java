package com.zjl.payment.controller;

import com.zjl.cloud.dto.PayDTO;
import com.zjl.cloud.result.ResultData;
import com.zjl.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@Tag(name="订单支付接口",description = "订单支付的api")
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;
    /**
     * 根据id查询支付流水订单
     * @param id
     * @return
     */
    //swagger3是根据反射来获取方法的所有属性，会在ui端显示例如参数的实体，返回值的实体，即使没有标注swagger的注解
    @Operation(summary = "订单查询接口",description = "根据id查询订单")
    @GetMapping("/pay/get/{id}")
    public ResultData selectById(@PathVariable("id")Integer id){
        log.info("访问的端口号是：{}",port);
        try {TimeUnit.SECONDS.sleep(10);} catch (InterruptedException e) {throw new RuntimeException(e);}
        return paymentService.getOne(id);
    }

    /**
     * 新增订单
     * @param payDTO
     * @return
     */
    @Operation(summary = "新增订单接口",description = "新增订单，参数是订单数据，json数据格式")
    @PostMapping("/pay/add")
    public ResultData insert(@RequestBody PayDTO payDTO){
        log.info("访问的端口号是：{}",port);
        return paymentService.addPay(payDTO);
    }

    /**
     * 更新订单，更新非空的数据
     * @param payDTO
     * @return
     */
    @Operation(summary = "更新订单接口",description = "更新订单，参数是订单数据，json数据格式")
    @PutMapping("/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        log.info("访问的端口号是：{}",port);
        return paymentService.update(payDTO);
    }

    /**
     * 根据id删除支付流水
     * @param id @Parameter(name = "订单id") swagger3对参数的说明
     * @return
     */
    @Operation(summary = "删除订单接口",description = "删除订单，参数是订单的id")
    @DeleteMapping("/pay/delete/{id}")
    public ResultData delete(@PathVariable("id") @Parameter(name = "订单id") Integer id){
        log.info("访问的端口号是：{}",port);
        return paymentService.delete(id);
    }

    /**
     * 查询所有订单
     * @return
     */
    @Operation(summary = "查询订单接口",description = "查询所有订单")
    @GetMapping("/pay/selectAll")
    public ResultData selectAll(){
        log.info("访问的端口号是：{}",port);
        return paymentService.selectAll();
    }

    /**
     * 测试consul的刷新策略
     * @param info
     * @return
     */
    @Operation(summary = "测试consul的配置刷新功能",description = "测试consul的配置刷新功能")
    //这里遇到的一个配置刷新的坑，就是每次要去调用这个@value.可以观察到变化
    @GetMapping("/pay/info")
    public String getConsulConfig(@Value("${com}")String info){
        log.info("访问的端口号是：{}",port);
        return info+System.currentTimeMillis();
    }

}

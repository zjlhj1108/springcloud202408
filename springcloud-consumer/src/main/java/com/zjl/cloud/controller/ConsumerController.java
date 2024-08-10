package com.zjl.cloud.controller;
import com.zjl.cloud.dto.PayDTO;
import com.zjl.cloud.result.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Tag(name="订单接口",description = "订单的增删改查")
@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;
    //这中方式会造成地址写死的情况
//    private  String url = "http://localhost:8818";
    //我们使用这种方式来看一下(这个需要再restTemplate上面加注解@LoadBalancer),会自动到服务中心拉取服务访问
    private  String url = "http://payment-service";

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 测试consul的配种中心刷新策略
     * @return
     */
    @Operation(summary = "测试consul的刷新策略",description = "测试consul配置中心的修改刷新策略")
    @GetMapping("/consumer/pay/info")
    public String getPayInfo(){
        return restTemplate.getForObject(url + "/pay/info", String.class);
    }

    /**
     * 测试consul的配种中心刷新策略
     * @return
     */
    @Operation(summary = "根据id查询支付订单",description = "根据id查询支付订单")
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPay(@PathVariable("id")Integer id){
        return restTemplate.getForObject(url + "/pay/get/"+id, ResultData.class);
    }

    /**
     * 测试consul的配种中心刷新策略
     * @return
     */
    @Operation(summary = "查询所有的支付订单",description = "查询所有支付订单")
    @GetMapping("/consumer/pay/selectAll")
    public ResultData getAllPay(){
        return restTemplate.getForObject(url + "/pay/selectAll", ResultData.class);
    }

    /**
     * 插入支付订单
     * @return
     */
    @Operation(summary = "测试consul的刷新策略",description = "测试consul配置中心的修改刷新策略")
    @PostMapping("/consumer/pay/add")
    public ResultData insertPay(@RequestBody PayDTO payDTO){
                //这个方法参数，1.url 2.你要发的数据 请求体 3.响应体类型 4。参数
        return restTemplate.postForObject(url + "/pay/add", payDTO,ResultData.class);
    }

    /**
     * 修改支付订单
     * @return
     */
    @Operation(summary = "测试consul的刷新策略",description = "测试consul配置中心的修改刷新策略")
    @PutMapping("/consumer/pay/update")
    public ResultData update(@RequestBody PayDTO payDTO){
        return restTemplate.exchange(url + "/pay/update",
                HttpMethod.PUT,new HttpEntity<>(payDTO),
                ResultData.class).getBody();
    }

    /**
     * 删除支付订单
     * @return
     */
    @Operation(summary = "测试consul的刷新策略",description = "测试consul配置中心的修改刷新策略")
    @DeleteMapping("/consumer/pay/delete/{id}")
    public ResultData deletePay(@PathVariable("id")Integer id){
        return restTemplate.exchange(url + "/pay/delete/"+id, HttpMethod.DELETE,
                null, ResultData.class).getBody();
    }

    /**
     * 自定义负载均衡访问payment
     * @return
     */
    @Operation(summary = "自定义查询loadbalancer访问远程",description = "自定义查询loadbalancer访问远程")
    @GetMapping("/consumer/pay/customer/selectAll")
    public ResultData getAllPayCustomer(){
        List<ServiceInstance> instances = discoveryClient.getInstances("payment-service");
        ServiceInstance serviceInstance = instances.get(0);
        URI uri = serviceInstance.getUri();
        ResultData forObject = restTemplate.getForObject(uri + "/pay/selectAll", ResultData.class);
        return forObject;
    };


}

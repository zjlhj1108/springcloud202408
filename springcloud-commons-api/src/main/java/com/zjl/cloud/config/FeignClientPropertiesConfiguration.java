package com.zjl.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;

public class FeignClientPropertiesConfiguration {

    //默认是是从不重试
//    @Bean
//    public Retryer feignRetryer() {
//        return Retryer.NEVER_RETRY;
//    }
    //采用defalut的方式，默认是间隔100毫秒重试，最大间隔1000毫秒。重试最多3次
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100,1000,3);
    }
    //开启feigin的日志功能 NONE代表没有，Basic header,full(打印全部日志，还需要在application.yml配置一下)
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}

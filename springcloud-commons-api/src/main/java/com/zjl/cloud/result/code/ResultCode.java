package com.zjl.cloud.result.code;

import lombok.Data;

import java.util.Arrays;

public enum ResultCode {
    //访问成功
    OK("访问成功",200),
    //访问失败
    FAIL("访问失败",500);
    //状态码的描述
    private String description;
    //状态吗
    private int code;

    private ResultCode(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    //根据描述返回对应的结果码
    public static ResultCode getResultCode(String description) {
        for (ResultCode result : ResultCode.values()) {
            if (description.equals(result.getDescription())) {
                return result;
            }
        }
        return null;
    }

    //根据描述返回对应的结果码 流式写法
    public static ResultCode getReturnCodeEnumV2(String description)
    {
        return Arrays.stream(ResultCode.values()).filter(x -> x.getDescription().equalsIgnoreCase(description)).findFirst().orElse(null);
    }
}

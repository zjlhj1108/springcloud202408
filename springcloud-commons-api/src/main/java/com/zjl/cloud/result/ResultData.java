package com.zjl.cloud.result;

import com.zjl.cloud.result.code.ResultCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@ToString
@Schema(title = "返回值实体")
public class ResultData <T>{
    //返回的数据
    @Schema(title = "结果返回值实体")
    private T data;
    //结果信息
    @Schema(title = "消息返回值")
    private String msg;
    //结果码
    @Schema(title = "结果码")
    private Integer code;
    //时间戳
    @Schema(title = "时间戳")
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }
    //访问成功的的返回值
    public static  <T>ResultData<T> success(T data) {
        ResultData<T> successData = new ResultData<>();
        successData.setData(data);
        successData.setCode(ResultCode.OK.getCode());
        successData.setMsg(ResultCode.OK.getDescription());
        return successData;
    }

    //访问失败的的返回值
    public static  <T>ResultData<T> fail(T data) {
        ResultData<T> failData = new ResultData<>();
        failData.setData(data);
        failData.setCode(ResultCode.FAIL.getCode());
        failData.setMsg(ResultCode.FAIL.getDescription());
        return failData;
    }
}

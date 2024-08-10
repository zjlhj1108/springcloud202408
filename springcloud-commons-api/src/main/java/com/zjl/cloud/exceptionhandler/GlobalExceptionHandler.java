package com.zjl.cloud.exceptionhandler;

import com.zjl.cloud.result.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    //The reason to be used for the response.
    //Defaults to an empty string which will be ignored. Set the reason to
    //a non-empty value to have it used to send a Servlet container error page.
    // In this case, the return value of the handler method will be ignored.
    // 这里不能加reason属性，上面的解释是如果加了reason属性，处理方法返回值将会被忽略。
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exceptionHandler(Exception e) {
        ResultData<String> exceptionResultData = new ResultData<>();
        exceptionResultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        exceptionResultData.setMsg(e.getMessage());
        exceptionResultData.setData(null);
        return exceptionResultData;

    }
}

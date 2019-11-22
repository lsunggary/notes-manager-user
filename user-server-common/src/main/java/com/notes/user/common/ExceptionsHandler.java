package com.notes.user.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Object BizExceptionHandler(BizException e) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("code",  e.getErrCode());
        result.put("message", e.getErrMsg());
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object CusBizExceptionHandler(Exception e) {
        Map<String, String> result = new HashMap<String, String>();
        result.put("code", "400");
        result.put("message", e.getMessage());
        return result;
    }
}

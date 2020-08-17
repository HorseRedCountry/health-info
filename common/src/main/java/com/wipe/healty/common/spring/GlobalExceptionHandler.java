package com.wipe.healty.common.spring;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * 统一异常处理
 *
 * @author changjiang.tang Date:7/31/15 Time:3:54 PM
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public void handleIOException(){

    }

}

package com.qhit.common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by 18203709505 on 2018/12/17.
 */
@Component
@Aspect
public class ExceptionInterceptor {
    @AfterThrowing(value = "execution(* com.qhit.*.controller.*.*(..))",throwing = "e")
    public void afterThrowing(Exception e){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw,true));
        String str = sw.toString();
        String[] arr = str.split("\r\n");
        int len = arr.length > 4 ? 4 : arr.length;
        for (int i =0;i<len;i++){
            System.out.println(arr[i]);
        }
    }


}

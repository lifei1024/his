package com.qhit.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by 18203709505 on 2018/12/12.
 */
@Component
@Aspect
public class LogInterceptor {
    @Before(value = "execution(* com.qhit.*.controller.*.*(..))")
    public void Before(JoinPoint jp){
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        String args = Arrays.toString(jp.getArgs());
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String time = format.format(new Date());
        System.out.println(time+"开始执行类名"+className+"下的方法:"+methodName+",输入参数："+args);
    }
    @AfterReturning(returning = "result",value = "execution(* com.qhit.*.controller.*.*(..))")
    public void afterReturning(JoinPoint jp,Object result){
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String time = format.format(new Date());
        System.out.println(time+"结束执行类名"+className+"下的方法:"+methodName+",返回值："+result);

    }

}

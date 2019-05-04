package com.qhit.test.proxy2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/12/6.
 */
public class FandianCGLIBProxy implements MethodInterceptor {

    public Object getInstance(Object obj){
//        创建一个增强器 用于创建代理实例
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("点菜...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("付款....");
        return result;
    }
}

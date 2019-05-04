package com.qhit.test.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/12/6.
 */
public class ReflectUtil {

    public static void aa(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = object.getClass();
        Method info = clazz.getMethod("info");
        info.invoke(object);
    }

}

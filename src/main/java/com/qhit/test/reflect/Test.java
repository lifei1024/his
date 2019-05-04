package com.qhit.test.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Administrator on 2018/12/6.
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        Student s = new Student();
        Teacher t = new Teacher();
//        s.info();
        ReflectUtil.aa(t);
    }

}

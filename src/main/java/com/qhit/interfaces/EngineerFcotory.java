package com.qhit.interfaces;

/**
 * Created by 18203709505 on 2018/12/17.
 */
public class EngineerFcotory {


    public static Engineer getEngineer(){
        return new EngineerCainiao();
    }
}

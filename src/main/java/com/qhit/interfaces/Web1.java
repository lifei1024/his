package com.qhit.interfaces;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/5/1 0001.
 */
public class Web1 {
    @Autowired
    static Engineer engineer;
    public static void main(String[] args) {
        engineer.judge(12345);
    }

}

package com.qhit.test.proxy;

/**
 * Created by Administrator on 2018/12/6.
 */
public class Zhongcan implements Fandian {
    @Override
    public void tiGongFancai() {
        System.out.println("提供中餐...");
    }

    @Override
    public void tiGongJiushui() {
        System.out.println("提供白酒....");
    }

}

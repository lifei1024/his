package com.qhit.test.proxy;

import javax.sound.midi.Soundbank;

/**
 * Created by Administrator on 2018/12/6.
 */
public class Xican implements Fandian {
    @Override
    public void tiGongFancai() {
        System.out.println("提供西餐...");
    }

    @Override
    public void tiGongJiushui() {
        System.out.println("提供红酒....");
    }

}

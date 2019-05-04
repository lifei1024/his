package com.qhit.test.proxy;

/**
 * Created by Administrator on 2018/12/6.
 */
public class Test {

    public static void main(String[] args) {
        Fandian fandian = new Kuaican();
        FandianProxy fandianProxy = new FandianProxy();
        Fandian fandian1 = (Fandian) fandianProxy.getInstance(fandian);
        fandian1.tiGongFancai();
        fandian1.tiGongJiushui();
    }

}

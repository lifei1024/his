package com.qhit.test.proxy2;

/**
 * Created by Administrator on 2018/12/6.
 */
public class Test {

    public static void main(String[] args) {
        Xican xican = new Xican();
        FandianCGLIBProxy fandianCGLIBProxy = new FandianCGLIBProxy();
        Xican instance = (Xican) fandianCGLIBProxy.getInstance(xican);
        instance.tiGongFancai();
    }

}

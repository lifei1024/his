package com.qhit.test.strings;

/**
 * Created by 18203709505 on 2018/12/18.
 */
public class demo {
    public static void main(String[] args) {

        System.out.println( ss(6));
    }

    private static int ss(int n) {
        if (n==1||n==2){
            return 1;
        }
        return ss(n-1)+ss(n-2);
    }
}

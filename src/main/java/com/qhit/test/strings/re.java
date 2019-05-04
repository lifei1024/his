package com.qhit.test.strings;

import sun.security.util.Length;

/**
 * Created by 18203709505 on 2018/12/18.
 */
public class re {
    private static int sum;
    public static void main(String[] args) {
        //clsc(10);
        //System.out.println(sum);
        boolean huiwen = huiwen(15612);
        System.out.println(huiwen);
    }

    private static boolean huiwen(int i) {
        String a = ""+i;
        if (a.length()>=2){
            if (a.charAt(0)==a.charAt(a.length()-1)){
                a=a.substring(1,a.length()-1);
                huiwen(Integer.parseInt(a));
            }else {
                return false;
            }
        }
        return true;
    }

    private static void clsc(int n) {
        if (n>0){
            sum+=n;
            n--;
            clsc(n);
        }
    }





}

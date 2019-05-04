package com.qhit.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by 18203709505 on 2018/12/29.
 */
public class SortTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(randomArrays(20,100)));
    }
    //生成随机数组
    public static int[] randomArrays(int n,int m){
        Random a = new Random();
        Set<Integer> sets = new HashSet<Integer>();
        while (sets.size()<=n){
            int i = a.nextInt(m);
            sets.add(i);
        }
        Object[] objects = sets.toArray();
        int[] b = new int[objects.length];
        for (int i=0;i<objects.length;i++){
            b[i] = (int) objects[i];
        }
         return b;
    }


}

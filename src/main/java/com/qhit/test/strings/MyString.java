package com.qhit.test.strings;

/**
 * Created by 18203709505 on 2018/12/18.
 */
public class MyString {
    public static char charAt(String str,int i){
        char[] chars = str.toCharArray();
        return chars[i];
    }
    public static String subString(String str,int begin,int end){
        char[] chars = str.toCharArray();
        String result = "";
        for (int i = begin;i<=end;i++){
            result+=chars[i];
        }
        return result;
    }

    public static int indexOf(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0;i<chars1.length;i++){
            for (int j=0;j<chars2.length;j++){
                if (chars1[i]==chars2[j]) {
                    return i;
                }
            }

        }
            return -1;
    }





}

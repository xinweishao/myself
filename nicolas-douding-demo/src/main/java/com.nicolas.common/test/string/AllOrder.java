package com.nicolas.common.test.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test.string
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-12-04 17:14
 */
public class AllOrder {
    private static Set<String> result = new HashSet<String>();

    public static void main(String[] args) {
        char[] a = {'a','b','c'};

        permutation(a, 0, 2);
        System.out.println(result);
    }


    private static void permutation(char[] a, int from, int to) {
        if(a== null || from>to || from<0) {
            return;
        }
        if(from == to) {
            System.out.println("from ="+ from+"  ="+String.valueOf(a));
            result.add(String.valueOf(a));
        }
        for(int i = from; i <= to; i++) {
            swap(a,i,from);
            System.out.println("i="+ i+" from="+from);
            permutation(a, from +1,to);
            swap(a,i,from);
        }
    }


    private static void swap(char[]a, int left, int right) {
        char temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}

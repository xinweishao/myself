package com.nicolas.common.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-06-28 11:57
 */
public class ArrayChildSum {

    public static void main(String[] args) {
        int [] a = new int[]{8,15,30,10,29,10,40,28,31,31,21,10,28,14,25,21,23,14,34,16};

        int sum = 0;
//        for(int i= 0;i<subsetss.size() ; i++){
//            List<Integer> sub = subsetss.get(i);
//            if(sub.size() >1){
//                sum += (sub.get(sub.size() -1) - sub.get(0));
//            }
//        }
        System.out.println("sum = [" + sumSubseqWidths(a) + "]");
    }

    public static int sumSubseqWidths(int[] a) {
        int MOD = 1_000_000_007;
        int n = a.length;
        Arrays.sort(a);

        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; ++i)
            pow2[i] = pow2[i-1] * 2 % MOD;

        long ans = 0;
        for (int i = 0; i < n; ++i)
            ans = (ans + (pow2[i] - pow2[n-1-i]) * a[i]) % MOD;

        return (int) ans;
    }


    public static void getSonSet1(int i,List<Integer> aList,List<Integer> bList){
        if(i>aList.size()-1){
            if(bList.size()<=0){
                System.out.print("@");
            }else {
                /*for(int v:bList){
                    System.out.print(v+",");//可以直接用这种方法输出bList数组里所有值，但是每个子数组最后就会带逗号
                }*/
                System.out.print(bList.get(0));
                for(int m=1;m<bList.size();m++){
                    System.out.print(","+bList.get(m));
                }
            }
            System.out.println();
        }else {
            bList.add(aList.get(i));
            getSonSet1(i+1, aList, bList);
            int bLen=bList.size();
            bList.remove(bLen-1);
            getSonSet1(i+1, aList, bList);
        }
    }

}

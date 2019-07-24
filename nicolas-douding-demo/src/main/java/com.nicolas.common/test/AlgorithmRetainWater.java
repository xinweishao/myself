package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description:  计算蓄水最大的算法
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-18 15:30
 */
public class AlgorithmRetainWater {

    public static void main(String[] args) {

        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("args = [" + calculate(a) + "]");

    }

    private static int calculate(int[] a) {
        if(a== null || a.length == 0){
            return 0;
        }

        int i=0,r=a.length-1,maxarea=0,minarea=0;

        while (i < r){

            maxarea = Math.max(maxarea,Math.min(a[i],a[r]) * (r - i));
            if(a[i] < a[r]){
                i ++;
            }else{
                r -- ;
            }

        }

        return maxarea;
    }
}

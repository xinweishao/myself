package com.nicolas.common.test;

import java.util.Arrays;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-04-29 16:38
 */
public class FIndDemo {

    public static void main(String[] args) {
        int[] array={13,4,56,7,88,7,78,66,34,56};
        System.out.println("待查找的数组序列为：" + Arrays.toString(array));

        quickSort(array,0,array.length -1 );

        System.out.println("排序完后的序列为：" + Arrays.toString(array));

        System.out.println("排序完后的数字对一个的位置是：" + binarySearch(7,array));

    }

    private static int binarySearch(int num,int[] nums) {
        int low = 0,end = nums.length -1;

        while (low <= end){
            int mid = (low + end )/ 2;
            if(num > nums[mid]){
                low = mid +1;
            }else if(num < nums[mid]){
                end = mid -1;
            }else{
                return mid ;
            }
        }
        return -1;
    }

    private static void quickSort(int[] array,int begin,int end) {
        if(begin > end || (array == null && array.length == 0)  ){
            return;
        }
        int i = begin,j = end ,base = array[begin];

        while(i < j){

            while(i< j){
                while (i< j && array[j] > base){
                    j--;
                }
                array[i++] = array[j];

                while(i<j && array[i] < base){
                    i++;
                }
                array[j--] = array[i];
            }
            array[i] = base;
            quickSort(array,begin,i -1);
            quickSort(array,i+1,end);
        }


    }

}

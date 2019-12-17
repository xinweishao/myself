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
//        int[] array={13,4,56,7,88,7,78,66,34,56};
        int[] array={1,2,3,2,4,2,5,2,3};

        System.out.println("待查找的数组序列为：" + Arrays.toString(array));

        quickSort(array );
        MoreThanHalfNum_Solution(array);
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

    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
                j = hight;
            index = a[i]; // 用子表的第一个记录做基准
            while (i < j) { // 从表的两端交替向中间扫描
                while (i < j && a[j] >= index)
                    j--;
                if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序

    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static  int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length== 0){
            return 0;
        }
        quickSort(array);
        int i=array[array.length/2];
        if(array[i]== array[i-1] && array[i]== array[i+1]){
            return 2;
        }else{
            return 0;
        }

    }
}

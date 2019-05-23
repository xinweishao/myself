package com.nicolas.common.test;

import java.util.Arrays;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-04-28 19:14
 */
public class SortAlgorithm {

    public static void main(String[] args) {

//        int[] nums = new int[]{24,32,1,4,7,6,31,0};
//        popSort(nums);
//        selectSort(nums);

        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void popSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int length = nums.length;
        for(int i= 0; i< length -1; i++){
            for(int j=0; j< length -1 -i;j++){

                if(nums[j] > nums[j+1]){
                    nums[j] = nums[j] +nums[j+1];
                    nums[j+1] = nums[j] -nums[j+1];
                    nums[j] = nums[j] - nums[j+1];
                }
                System.out.println("j="+j+"nums = [" + Arrays.toString(nums) + "]");
            }

        }

        System.out.println("nums = [" + Arrays.toString(nums) + "]");
    }

    private static void selectSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int length = nums.length;
        int minIndex =0;
        for(int i= 0; i< length-1 ; i++){
            minIndex = i;
            for(int j=i+1; j< length ;j++){

                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }

            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;

        }

        System.out.println("nums = [" + Arrays.toString(nums) + "]");
    }

    public static void fastSort(int a[],int begin,int end){
        int i,j,base;
        if(begin > end){
            return;
        }

        base = a[begin];
        i = begin;
        j = end;
        while (i != j){
            while(i < j){

                while (i<j && a[j] >= base){
                    j--;
                }
                a[i++] = a[j];

                while(i < j && a[i] <= base){
                    i++;
                }
                a[j--] = a[i];
            }

            a[i] = base;
            fastSort(a,begin,i-1);
            fastSort(a,i+1,end);
        }


    }

    public static void quickSort(int a[], int low, int hight) {
        int i, j, base;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        base = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描

            while (i < j && a[j] >= base)
                j--;
            if (i < j){
                a[i++] = a[j];// 用比基准小的记录替换低位记录
                System.out.println("从右向左："+Arrays.toString(a));
            }

            while (i < j && a[i] < base)
                i++;
            if (i < j){
                // 用比基准大的记录替换高位记录
                a[j--] = a[i];
                System.out.println("从左向右："+Arrays.toString(a));
            }

        }

        a[i] = base;// 将基准数值替换回 a[i]
        System.out.println("循环后结果："+Arrays.toString(a));
        quickSort(a, low, i - 1); // 对低子表进行递归排序
        quickSort(a, i + 1, hight); // 对高子表进行递归排序

    }


    public static void insertSort(int a[]){
        if(a == null || a.length == 0) return;
        int insert,preIndex ;
        for(int i=1;i<a.length;i++){
            insert = a[i];
            preIndex = i - 1;
            while(preIndex >= 0 && insert < a[preIndex] ){
                a[preIndex +1 ] =  a[preIndex];
                preIndex -- ;
            }
            a[preIndex +1] = insert;
        }
    }

}

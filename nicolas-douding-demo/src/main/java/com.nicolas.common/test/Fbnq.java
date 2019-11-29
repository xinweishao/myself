package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-11-26 15:34
 */
public class Fbnq {
    public static void main(String[] args) {

        //建立一个for循环，用于打印第一个至第十个数字
        for(int i = 2;i <= 10;i++) {
            //调用函数进行打印
            System.out.print(fib(i) + "\t");
        }
    }


    public static void fib2(int num){
        int a = 1;
        int b = 1;
        for(int i = 1;i <= num;i++) {
            //循环打印a,b两个数，即两个两个打印
            System.out.print(a + "\t" + b + "\t");
            //打印第三、四个数
            a = a + b;
            b = a + b;
        }
    }

    public static int fib(int a){
        if(a == 1){
            return 0;
        }
        if(a == 2){
            return 1;
        }
        return fib(a-1) + fib(a-2);
    }
}

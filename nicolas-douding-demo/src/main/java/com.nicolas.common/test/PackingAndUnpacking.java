package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-24 11:01
 */
public class PackingAndUnpacking {
    public static void main(String[] args) {

        Integer integer400=400;
        int int400=400;
        System.out.println(integer400==int400);
        System.out.println(integer400.equals(int400));


        Integer integer100=100;
        int int100=100;
        System.out.println(integer100.equals(int100));
        System.out.println(integer100 == int100);


        Integer i1=100;
        Integer i2=100;
        Integer i3=300;
        Integer i4=300;
        System.out.println(i1==i2);
        System.out.println(i3==i4);

    }
}

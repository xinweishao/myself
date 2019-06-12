package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.provider
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2018-11-27 15:33
 */
public class CodeBlockDemo
{
    {
        System.out.println("初始化代码");
    }

    CodeBlockDemo(){
        System.out.println("构造器");
    }

    static
    {
        System.out.println("静态代码块");
    }

    //运行后输出结果?
    public static void main(String[] args)
    {
        {
            int a = 10;
            //10
            System.out.println("局部代码块");
        }

        new CodeBlockDemo();
        new CodeBlockDemo();
    }
}

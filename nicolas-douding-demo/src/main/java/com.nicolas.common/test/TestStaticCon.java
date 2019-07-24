package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-24 17:03
 */
public class TestStaticCon {
    public static int a = 0;
    static {
        a = 10;
        System.out.println("父类的静态代码块在执行a=" + a);
    }
    {
        a = 8;
        System.out.println("父类的非静态代码块在执行a=" + a);
    }
    public TestStaticCon() {

        this("a在父类带参构造方法中的值：" + TestStaticCon.a); // 调用另外一个构造方法
        System.out.println(a);
        System.out.println("父类无参构造方法在执行a=" + a);
    }
    public TestStaticCon(String n) {
        System.out.println(n);
        System.out.println(a);
    }
    public static void main(String[] args) {
        TestStaticCon tsc = null;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!");
        tsc = new TestStaticCon();
    }
}

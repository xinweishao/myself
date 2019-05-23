package com.nicolas.common.test;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2018-11-28 17:15
 */
public class TestDemo {
    public static void main(String[] args)  {

        DemoInvocation  demo = new DemoInvocationImpl();
        InvocationHandler invocationHandler = new DemoInvocationHandler<DemoInvocation>(demo);

        DemoInvocation stuProxy  = (DemoInvocation)Proxy.newProxyInstance(DemoInvocation.class.getClassLoader(),
                new Class[]{DemoInvocation.class},invocationHandler);


        try {
            byte[] bts = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{DemoInvocation.class});
            File file = new File("D:/","$Proxy0.class");
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bts);
            fos.flush();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        stuProxy.giveString();


    }
}

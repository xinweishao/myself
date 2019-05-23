package com.nicolas.common.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2018-11-28 17:16
 */
public class DemoInvocationHandler<T> implements InvocationHandler {

    T target;

    public DemoInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" invoke begin ");
        Object temp = method.invoke(target,args);
        System.out.println(" invoke end ");
        return temp;
    }
}

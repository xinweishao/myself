package com.nicolas.common.test;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.alibaba.dubbo.demo.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2018-11-28 17:12
 */
public class DemoInvocationImpl implements DemoInvocation {

    @Override
    public String giveString() {
        System.out.println(" outString method out print string.");
        return "outString";
    }
}

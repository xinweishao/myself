package com.nicolas.douding;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.douding
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-25 17:18
 */
 //重载HystrixCommand 的getFallback方法实现逻辑
public class HelloWorldCommandFallBack extends HystrixCommand<String> {
    private final String name;
    public HelloWorldCommandFallBack(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                /* 配置依赖超时时间,500毫秒*/
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(500)));
        this.name = name;
    }
    @Override
    protected String getFallback() {
        System.out.println(" ---- result=d");
        return "exeucute Falled";
    }
    @Override
    protected String run() throws Exception {
        //sleep 1 秒,调用会超时
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }
    public static void main(String[] args) throws Exception{
        HelloWorldCommand command = new HelloWorldCommand("test-Fallback");
        String result = command.execute();
    }
}
/* 运行结果:getFallback() 调用运行
getFallback executed
*/
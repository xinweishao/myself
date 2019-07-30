package com.nicolas.douding;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.douding
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-25 17:39
 */
public class HelloWorldCommandSEMAPHORE extends HystrixCommand<String> {
    private final String name;
    public HelloWorldCommandSEMAPHORE(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                /* 配置信号量隔离方式,默认采用线程池隔离 */
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)));
        this.name = name;
    }
    @Override
    protected String run() throws Exception {
        return "HystrixThread:" + Thread.currentThread().getName();
    }
    public static void main(String[] args) throws Exception{
        HelloWorldCommand command = new HelloWorldCommand("semaphore");
        String result = command.execute();
        System.out.println(result);
        System.out.println("MainThread:" + Thread.currentThread().getName());
    }
}
/** 运行结果
 HystrixThread:main
 MainThread:main
 **/
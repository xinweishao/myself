package com.nicolas;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Assert;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-25 17:33
 */
public class RequestCacheCommand extends HystrixCommand<String> {
    private final int id;
    public RequestCacheCommand( int id) {
        super(HystrixCommandGroupKey.Factory.asKey("RequestCacheCommand"));
        this.id = id;
    }
    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName() + " execute id=" + id);
        return "executed=" + id;
    }
    //重写getCacheKey方法,实现区分不同请求的逻辑
    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }

    public static void main(String[] args){
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        try {
            RequestCacheCommand command2a = new RequestCacheCommand(2);
            RequestCacheCommand command2b = new RequestCacheCommand(2);
//            Assert.assertTrue(command2a.execute());
            //isResponseFromCache判定是否是在缓存中获取结果
            Assert.assertFalse(command2a.isResponseFromCache());
//            Assert.assertTrue(command2b.execute());
            Assert.assertTrue(command2b.isResponseFromCache());
        } finally {
            context.shutdown();
        }
        context = HystrixRequestContext.initializeContext();
        try {
            RequestCacheCommand command3b = new RequestCacheCommand(2);
//            Assert.assertTrue(command3b.execute());
            Assert.assertFalse(command3b.isResponseFromCache());
        } finally {
            context.shutdown();
        }
    }
}
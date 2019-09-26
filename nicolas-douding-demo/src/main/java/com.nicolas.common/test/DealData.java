package com.nicolas.common.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-05-28 17:49
 */
public class DealData implements Callable<Map<String, String>> {

    private int fileIndex = 0;

    public DealData(int fileIndex) {
        this.fileIndex = fileIndex;
    }

    /**
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
     *
     * @return
     * @throws Exception
     */
    public Map<String, String> call() throws Exception {

        Map<String, String> errorMessageMap = new HashMap<String, String>();
        errorMessageMap.put("key--dd",System.currentTimeMillis()+"");
        Thread.sleep(100000);
        return errorMessageMap;
    }
}

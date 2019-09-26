package com.nicolas.common.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-05-28 17:48
 */
public class TreadPoolTest {
    //线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {

//        getAppTokenInfo("fb704ef691f49bab414ac3a08a86ca7864419437");

        try {
            //多线程操作
            List<Future<Map<String, String>>> resultList = new ArrayList<Future<Map<String, String>>>();
            for (int i=1;i<=1000;i++) {

                Future<Map<String, String>> future = executorService.submit(new DealData(i));
                resultList.add(future);
            }

            // 遍历任务的结果
            for (Future<Map<String, String>> fs : resultList) {
                try {
                    Map<String, String> map = fs.get();
                    if (map != null && map.size() > 0) {
                        System.out.println("线程组执行过程中异常："+ map.toString());
                    }
                } catch (Exception e) {
                    System.out.println("线程组执行过程中异常：{}"+ e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

//        ReentrantLock lock = new ReentrantLock();
//        BlockingQueue

    }

}

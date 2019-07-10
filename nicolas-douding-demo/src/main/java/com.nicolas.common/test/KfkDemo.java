package com.nicolas.common.test;


import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.ProducerFencedException;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-07-05 14:15
 */
public class KfkDemo<K, V> implements Producer<K,V> {


    public void send(){
        Producer<K, V> producer = new KafkaProducer(new Properties());

        producer.send(new ProducerRecord("topic", "nihao","moadd"));


    }


    public static void main(String[] args) throws Exception{

        LinkedHashMap linkedHashMap = new LinkedHashMap();

//        linkedHashMap.get();

        LinkedList linkedList = new LinkedList();

        Map<String,String> treeMap = new TreeMap<>();

        Map<String,String> currentHashMap = new ConcurrentHashMap<>();









        String pathDirectory = "C:\\Users\\xinweishao\\Desktop\\pushtoke_ios.json";
//
//        List<String> fileNameList =  getAllFileName(pathDirectory);
//        for(String fileName : fileNameList){
//            FileInputStream fis = new FileInputStream(pathDirectory+"\\"+fileName);
//            // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
//            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//            String line = "",msg="";
//            int lineNum = 0;
//            while ((line = br.readLine()) != null) {
//                KafkaUtil.send(Constant.MSMC_SMC_USER_CLIENT_IPHONE_TO_OFFLINE_ONLINE,line+",1");
//                lineNum ++;
//            }
//            br.close();
//            isr.close();
//            fis.close();
//            System.out.println("文件已经读取完毕 [" + fileName + "],读取"+lineNum+"行。");
//        }
//
//        FileInputStream fis = new FileInputStream(pathDirectory);
//        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
//        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//        BufferedReader br = new BufferedReader(isr);
//        String line = "",msg="";
//        int lineNum = 0;
//        Set<String> hashSet = new HashSet<String>();
//        while ((line = br.readLine()) != null) {
//            KafkaUtil.send(Constant.MSMC_SMC_USER_CLIENT_IPHONE_TO_OFFLINE_ONLINE,line);
//            lineNum ++;
//        }
//        br.close();
//        isr.close();
//        fis.close();
//        for (String str : hashSet) {
//            KafkaUtil.send(Constant.MSMC_SMC_USER_CLIENT_IPHONE_TO_OFFLINE_ONLINE,str+",1");
//        }
//        List<String> fileNameList =  getAllFileName(pathDirectory);
//        for(String fileName : fileNameList){
//            FileInputStream fis = new FileInputStream(pathDirectory+"\\"+fileName);
//            // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
//            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//            String line = "",msg="";
//            int lineNum = 0;
//            while ((line = br.readLine()) != null) {
//                // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
//                String[] lineArr = line.split("\\t");
//                msg =  lineArr[0]+","+lineArr[1];
//                KafkaUtil.send(Constant.MSMC_SMC_USER_CLIENT_IPHONE_TO_OFFLINE_ONLINE,msg);
//                lineNum ++;
//            }
//            br.close();
//            isr.close();
//            fis.close();
//            System.out.println("文件已经读取完毕 [" + fileName + "],读取"+lineNum+"行。");
//        }

    }

    @Override
    public void initTransactions() {

    }

    @Override
    public void beginTransaction() throws ProducerFencedException {

    }

    @Override
    public void sendOffsetsToTransaction(Map<TopicPartition, OffsetAndMetadata> map, String s) throws ProducerFencedException {
        return;
    }



    @Override
    public void commitTransaction() throws ProducerFencedException {

    }

    @Override
    public void abortTransaction() throws ProducerFencedException {

    }

    @Override
    public Future<RecordMetadata> send(ProducerRecord<K, V> producerRecord) {
        return null;
    }

    @Override
    public Future<RecordMetadata> send(ProducerRecord<K, V> producerRecord, Callback callback) {
        return null;
    }



    @Override
    public void flush() {

    }

    @Override
    public List<PartitionInfo> partitionsFor(String s) {
        return null;
    }

    @Override
    public Map<MetricName, ? extends Metric> metrics() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void close(long l, TimeUnit timeUnit) {

    }
}

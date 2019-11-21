package com.nicolas.common.test.string;

import java.util.ArrayList;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-11-21 17:18
 */
public class StringTest {
    public static void main(String[] args) {
        System.out.println("args = [" + lengthOfLongestSubstring1(" ") + "]");
    }


    public static int lengthOfLongestSubstring1(String s) {
        //如果s为空，length不大于0，是一个空串，就没有向下执行的必要了
        if(s != null && s.length() > 0 && s != ""){
            //String -> char[]
            char[] strChar = s.toCharArray();
            // 存储最长字串 key:char值，value:index下标
            ArrayList<String> maxStr = new ArrayList<>();
            //临时的字串存储空间
            ArrayList<String> tempStr = new ArrayList<>();
            //循环
            for(int i=0; i<strChar.length; i++){
                //char -> String
                String str = new String(new char[]{strChar[i]});
                //判断str是否存在于tempStr中
                if(tempStr.contains(str)){
                    //先判断tempStr的长度是否大于等于maxStr的长度,大于，才能将最长字串覆盖
                    if(tempStr.size() > maxStr.size()){
                        maxStr = new ArrayList<>(tempStr);
                    }
                    //存储重复字符
                    int reIndex = tempStr.indexOf(str);
                    // 删除tempStr中的重复字节及其之前的字符
                    for(int j=0;j<=reIndex;j++){
                        tempStr.remove(0);
                    }
                }
                //将当前字符存入tempStr中
                tempStr.add(str);
            }
            //最终判断
            if(tempStr.size() > maxStr.size()){
                maxStr = tempStr;
            }
            //返回最长字串的长度
            return maxStr.size();
        }
        return 0;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 1;
        int maxNoRepeatLength = 0;
        int tempNorepeatLenth = 0;
        String maxRepeatStr = "";
        int i =0 ;
        while(i < s.length()){
            if(maxRepeatStr.indexOf(s.substring(i,i+1)) < 0){
                tempNorepeatLenth ++;
                maxRepeatStr = maxRepeatStr + s.substring(i,i+1);
                i++;
                continue;
            }else{

                maxNoRepeatLength  = Math.max(maxNoRepeatLength,tempNorepeatLenth);
                tempNorepeatLenth = 0;
                maxRepeatStr = "";
            }
        }
        System.out.println("maxNoRepeatLength = [" + maxNoRepeatLength + "]");

        return maxNoRepeatLength;
    }

}

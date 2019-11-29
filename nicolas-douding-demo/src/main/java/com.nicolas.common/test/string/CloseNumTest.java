package com.nicolas.common.test.string;

import java.util.Arrays;

/**
 * @version V1.0
 *          注意：本内容仅限于搜狐新闻，禁止外泄以及用于其他的商业目
 * @Package com.nicolas.common.test.string
 * @Description: 用一句话描述该文件做什么)
 * @author: 搜狐 - 新闻客户端 - 云端业务 - shaoxinwei
 * @date: 2019-11-22 11:34
 */
public class CloseNumTest {
    public static void main(String[] args) {
        int[] ss = new int[]{1,1,-1,-1,3};
        System.out.println("argss = [" + threeSumClosest(ss,3) + "]");
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 排序

        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int threeSum = nums[i] + nums[i+1] + nums[i+2];
            if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                closestNum = threeSum;
            }

        }

        return closestNum;
    }

}

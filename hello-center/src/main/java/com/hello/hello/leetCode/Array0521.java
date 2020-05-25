package com.hello.hello.leetCode;

public class Array0521 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length; //翻转数 超过数组个数相当于 翻转 k % nums.length
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
//        int temp, previous;
//        for (int i = 0; i < k; i++) {
//            previous = nums[nums.length - 1];
//            for (int j = 0; j < nums.length; j++) {
//                temp = nums[j];
//                nums[j] = previous;
//                previous = temp;
//            }
//        }
    }

    /**
     * 翻转数组
     * @param ints 数组对象
     * @param start 开始索引
     * @param end 结束索引
     */
    private void reverse(int[] ints, int start, int end){
        while (start < end){
            int temp = ints[start];
            ints[start] = ints[end];
            ints[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        //动态规划 dp
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[nums.length + 1];

//        int preMax = 0;
//        int currMax = 0;
//        for (int num : nums) {
//            //临时保存 当前最大
//            int temp = currMax;
//            //当前最大 与 之前最大加新值 比较，后取最大值（相当于隔开取值相加）
//            currMax = Math.max(preMax + num, currMax);
//            preMax = temp;
//        }
//        return currMax;
    }
}

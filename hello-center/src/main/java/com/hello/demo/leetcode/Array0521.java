package com.hello.demo.leetcode;

import java.util.Arrays;

public class Array0521 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //双指针 注意：数组必须升序排列后
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right){
            if (target == nums[left] + nums[right])
                return new int[]{left + 1, right + 1};
            else if (target < nums[left] + nums[right]) right--;
            else left++;
        }
        //借用map空间
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int subNum = target - nums[i];
//            if (hashMap.containsKey(subNum)) {
//                return new int[]{i, hashMap.get(subNum)};
//            }
//            hashMap.put(nums[i], i);
//        }
        //双循环
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i,j};
//                }
//            }
//        }
        return null;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        //二分法 时间复杂度：O(logn)
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int min = (left + right) / 2;
            if (target == nums[min]){
                return min;
            }else if(target > nums[min]){
                left = min + 1;
            }else {
                right = min - 1;
            }
        }
        return left;
        //O（n）的时间复杂度
//        if (null == nums || nums.length == 0) return 0;
//        int i;
//        for (i = 0; i < nums.length; i++) {
//            if (nums[i] >= target) return i;
//        }
//        return i;
    }

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
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        //动态规划 dynamic programming
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

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int resultNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[resultNum]) {
                resultNum++;
                nums[resultNum] = nums[i];
            }
        }
        return resultNum + 1;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) return 0;
        int resultNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[resultNum] = nums[i];
                resultNum++;
            }
        }
        return resultNum;
    }

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * @param nums1 原数组
     * @param m     原数组长度
     * @param nums2 合并数组
     * @param n     合并数组长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //反着比较 由于原数组长度足够 比较后直接将大值放入合并后数组中
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 || j>=0) {
            //注意两个边界条件，i<0以及j<0，这表示一个数组已经拷贝完了
            if (i < 0){
                nums1[k--] = nums2[j--];
            }else if (j < 0){
                nums1[k--] = nums1[i--];
            }else if (nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }else {
                nums1[k--] = nums1[i--];
            }
        }

        //数组合并，然后排序
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
    }
}

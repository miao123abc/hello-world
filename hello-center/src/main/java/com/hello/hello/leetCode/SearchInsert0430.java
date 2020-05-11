package com.hello.hello.leetCode;

public class SearchInsert0430 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
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
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     *
     * 如果不存在最后一个单词，请返回 0 。
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        if (s.isEmpty()) return 0;
        int max = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (max == 0) continue;
                break;
            }
            max++;
        }
        return max;

//        if (s.isEmpty()) return 0;
//        int lastIndexOf = s.trim().lastIndexOf(" ") + 1;
//        return s.trim().substring(lastIndexOf).length();
    }

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        if (null == digits || digits.length == 0) return null;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (0 != (digits[i] %= 10)) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        //保证字符串a 长度是较长者
        if (a.length() < b.length()) return addBinary(b, a);
        int shortLength = b.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '1') ++carry;
            if (shortLength > -1 && b.charAt(shortLength--) == '1') ++carry;
            stringBuilder.append(carry % 2);
            carry /= 2;
        }
        if (carry == 1) stringBuilder.append('1');
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
//        int searchInsert = searchInsert(new int[]{1, 3, 5, 6}, 8);
//        System.out.println("searchInsert = " + searchInsert);

//        int maxSubArray = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
//        System.out.println("maxSubArray = " + maxSubArray);

//        int helloWorld = lengthOfLastWord("aaaa xcv ");
//        System.out.println("helloWorld = " + helloWorld);

//        int[] plusOne = plusOne(new int[]{9});
//        System.out.println("plusOne = " + Arrays.toString(plusOne));

        String addBinary = addBinary("11", "11");
        System.out.println("addBinary = " + addBinary);
    }
}

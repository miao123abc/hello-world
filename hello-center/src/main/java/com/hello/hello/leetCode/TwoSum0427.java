package com.hello.hello.leetCode;

import java.util.Arrays;

class TwoSum0427 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //双指针 注意：数组必须升序排列后
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
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int y = 0;
        while (x != 0){
            if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
//        if(x == Integer.MIN_VALUE) return 0;
//        int abs = Math.abs(x);
//        StringBuilder stringBuilder = new StringBuilder(abs + "");
//        long parseLong = Long.parseLong(stringBuilder.reverse().toString());
//        long result = x < 0 ? -parseLong : parseLong;
//        if (parseLong > Integer.MAX_VALUE || parseLong < Integer.MIN_VALUE) {
//            return 0;
//        }
//        return (int)result;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x 整数
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x !=0)) return false;
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        while (left <= right){
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
//        int reverse = 0;
//        while (x > reverse){
//            reverse = reverse * 10 + x % 10;
//            x /= 10;
//        }
//        return x == reverse || x == reverse / 10;

//        String str = new StringBuilder(String.valueOf(x)).reverse().toString();
//        return str.equals(String.valueOf(x));
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 3, 4}, 6);
        System.out.println("ints = " + Arrays.toString(ints));

        int reverse = reverse(994748399);
        System.out.println("reverse = " + reverse);

        boolean palindrome = isPalindrome(1221);
        System.out.println("palindrome = " + palindrome);
    }
}
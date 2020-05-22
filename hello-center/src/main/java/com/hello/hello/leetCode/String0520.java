package com.hello.hello.leetCode;

public class String0520 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * @param s 字符串
     */
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("\\W", "").toLowerCase();
        int left = 0;
        int right = s1.length() - 1;
        while (left <= right){
            if (s1.charAt(left++) != s1.charAt(right--)) return false;
        }
        return true;
        //StringBuilder 翻转结果与之前比较
//        return new StringBuilder(s1).reverse().toString().equalsIgnoreCase(s1);
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param nums 非空整数数组
     * @return 只出现了一次的元素
     */
    public int singleNumber(int[] nums) {
        //异或
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;

        //hashSet去重获取
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int num : nums) {
//            if (!hashSet.add(num)) hashSet.remove(num);
//        }
//        return hashSet.iterator().next();
    }
}

package com.hello.hello.leetCode;

import java.util.HashMap;

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

    /**
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     */
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }

    private boolean isIsomorphicHelper(String s, String t){
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (hashMap.containsKey(c1)) {
                if (hashMap.get(c1) != c2) return false;
            }else {
                hashMap.put(c1, c2);
            }
        }
        return true;
    }
}

package com.hello.hello.leetCode;

import java.util.HashMap;
import java.util.Stack;

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

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) return "";
        String res = strs[0];
        for (String str : strs) {
            //表示必须从0开始包含
            while (str.indexOf(res) != 0) {
                //开始滑动
                res = res.substring(0, res.length()-1);
            }
        }
        return res;

//        if (null == strs || strs.length == 0) return "";
//        for (int i = 0; i < strs[0].length(); i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (i == strs[j].length() || c != strs[j].charAt(i))
//                    return strs[0].substring(0, i);
//            }
//        }
//        return strs[0];
    }

    /**
     *
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     有效字符串需满足：
     1.左括号必须用相同类型的右括号闭合。
     2.左括号必须以正确的顺序闭合。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (null == s || s.isEmpty()) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            } else if (stack.empty() || stack.pop() != c){
                return false;
            }
        }
        return stack.empty();

//        if (s.contains("()") || s.contains("[]") || s.contains("{}")) {
//            return isValid(s.replace("()", "").replace("[]", "").replace("{}", ""));
//        } else {
//            return "".equals(s);
//        }
    }

    /**
     * indexOf 方法的实现
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if (needle.isEmpty()) return 0;
        if (!haystack.contains(needle)) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     *
     * 如果不存在最后一个单词，请返回 0 。
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
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
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
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

}

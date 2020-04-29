package com.hello.hello.leetCode;

import java.util.Stack;

class RomanToInt0428 {

    /**
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char right = 'a';
            if (i + 1 < s.length()) {
                right = s.charAt(i + 1);
            }
            int swicth;
            switch (c){
                case 'I': swicth = 1; break;
                case 'V': swicth = 5; break;
                case 'X': swicth = 10; break;
                case 'L': swicth = 50; break;
                case 'C': swicth = 100; break;
                case 'D': swicth = 500; break;
                case 'M': swicth = 1000; break;
                default:  swicth = 0; break;
            }
            if ((c == 'I' && (right == 'V' || right == 'X')) ||
                    (c == 'X' && (right == 'L' || right == 'C')) ||
                    (c == 'C' && (right == 'D' || right == 'M'))) {
                swicth = -swicth;
            }
            sum += swicth;
        }
        return sum;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
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
    public static boolean isValid(String s) {
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

    public static void main(String[] args) {
//        int romanToInt = romanToInt("MCMXCIV");
//        System.out.println("romanToInt = " + romanToInt);
//
//        String s = longestCommonPrefix(new String[]{"flower","flow","flight"});
//        System.out.println("s = " + s);

        boolean valid = isValid("}){}");
        System.out.println("valid = " + valid);
    }
}
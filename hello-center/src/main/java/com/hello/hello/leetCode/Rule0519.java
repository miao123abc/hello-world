package com.hello.hello.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rule0519 {

    /**
     * 给定一个非负整数 numRows，生成 杨辉三角 的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * @param numRows 第几行
     * @return 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(resList.get(i - 1).get(j - 1) + resList.get(i - 1).get(j));
                }
            }
            resList.add(list);
        }
        return resList;
    }

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * @param rowIndex 索引行
     * @return 杨辉三角的第 k 行
     */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(resList.get(j - 1) + resList.get(j));
                }
            }
            resList = list;
        }
        return resList;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     * @param prices 价格列表
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        //贪心算法，从左向右，维护一个最小值low，与每一天的股票价格做差，差最大的为答案
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        //双循环
//        for (int i = prices.length - 2; i >= 0; i--) {
//            for (int j = prices.length - 1; j > i; j--) {
//                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
//            }
//        }
        return maxProfit;
    }

    /**
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
     * @param prices 价格列表
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0)
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }

    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 例如：
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     */
    public String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n --;//这里稍作处理，因为它是从1开始
            stringBuilder.insert(0, (char)(n % 26 + 'A'));
            n /= 26;
        }
        return stringBuilder.toString();
    }

    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     */
    public int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 64;
            ans = ans * 26 + num;
        }
        return ans;

//        int sum = 0;
//        int i = 0;
//        for (int length = s.length() - 1; length >= 0; length--) {
//            char c = s.charAt(length);
//            sum += Math.pow(26, i++) * (c - 64);
//        }
//        return sum;
    }

    /**
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * @param s
     * @return
     */
    public int romanToInt(String s) {
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
     *
     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

        //借用map 先统计 再比较找出结果
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            }else {
//                map.put(num, map.get(num) + 1);
//            }
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > nums.length / 2) {
//                return entry.getKey();
//            }
//        }
//        return 0;
    }

    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;

        //计算结果
//        BigInteger nFactorial = BigInteger.ONE;
//        for (int i = 2; i <= n; i++) {
//            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
//        }
//        int zeroCount = 0;
//        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
//            nFactorial = nFactorial.divide(BigInteger.TEN);
//            zeroCount++;
//        }
//        return zeroCount;
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * @param x
     * @return
     */
    public int reverse(int x) {
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
    public boolean isPalindrome(int x) {
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

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
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
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int thrid = first + second;
            first = second;
            second = thrid;
        }
        return second;
    }
}

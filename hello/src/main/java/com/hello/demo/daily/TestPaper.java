package com.hello.demo.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestPaper {

    public static void main(String[] args) {
        String str = "aab";
        str = str.replaceFirst("a", "");
        System.out.println("str = " + str);

        String a = "helloWorld";
        String b = "hello" + new String("World");
        System.out.println(a == b); //false

        System.out.println("三目运算结果：" + (a == b ? 99.9 : 9));

        Character character = find("gbgkkdehh", 2, 1);
        System.out.println("character = " + character);  // d
    }

    /**
     * 找到在字符串str中 第m个只出现过n次的字符
     */
    public static Character find(String str, Integer m, Integer n) {
        Character c = null;
        Map<Character, Integer> map = new HashMap<>();
        for (char c1 : str.toCharArray()) {
            if (map.get(c1) == null) {
                map.put(c1, 1);
            } else {
                map.replace(c1, map.get(c1) + 1);
            }
        }
        Set<Character> set = new HashSet<>();
        for (char character : str.toCharArray()) {
            if (set.contains(character)) continue;
            Integer count = map.get(character);
            if (count.equals(n)) m--;
            if (m == 0) {
                c = character;
                break;
            }
            set.add(character);
        }
        return c;
    }


}

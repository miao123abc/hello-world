package com.hello.hello.dailyTest;

import lombok.Data;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HelloStream {

    @Data
    private static class Person {
        private String name;
        private int age;
        private List<String> languagesSpoken;

        Person(String name, int age, List<String> languagesSpoken) {
            this.name = name;
            this.age = age;
            this.languagesSpoken = languagesSpoken;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Bob", 21, Arrays.asList("English", "French", "German"));
        Person p2 = new Person("Alice", 33, Arrays.asList("English", "Chinese", "Spanish"));
        Person p3 = new Person("Joe", 43, Arrays.asList("English", "Dutch", "Spanish", "German"));
        //存放到list中
        List<Person> people = Arrays.asList(p1,p2,p3);
        Map<String, List<Person>> langPersons =
                people.stream()
                        .flatMap(p -> p.getLanguagesSpoken()
                                .stream()
                                .map(l -> new AbstractMap.SimpleEntry<>(l,p)))
                        .collect(Collectors.groupingBy(Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue,
                                        Collectors.toList())));
        System.out.println("langPersons = " + langPersons);
        langPersons.entrySet().forEach(System.out::println);
    }

}

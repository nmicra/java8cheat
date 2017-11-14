/*
 * User: nisann
 * Date: 12/11/2017 
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA. 
 */
package com.lambdas;

import com.streams.ApplesGenerator;
import com.streams.pojo.Apple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class BasicLambdas3 {


    private final ApplesGenerator generator = new ApplesGenerator();

    private List<Apple> appleList;

    private Map<String, Set<Apple>> applesByColor;


    @BeforeEach
    public void setUp() throws Exception {
        appleList = generator.generate(1000);
        assertTrue(appleList.size() > 0);
        applesByColor = new HashMap<>();
    }


    @Test
    public void groupByColors() throws Exception {
        for (final Apple apple : appleList) {
            Set<Apple> applesLst = applesByColor.get(apple.getColor());
            if (applesLst == null) {
                applesLst = new HashSet<>();
                applesByColor.put(apple.getColor(), applesLst);
            }
            applesLst.add(apple);
        }

        for (String color : applesByColor.keySet()) {
            Set<Apple> apples = applesByColor.get(color);
            System.out.println(String.format("There is %s %s apples", color, apples.size()));
        }
    }


    @Test
    public void groupByColorsNewWay() throws Exception {
        appleList.forEach(apple -> {
            applesByColor.computeIfAbsent(apple.getColor(), h -> new HashSet<>()).add(apple);
        });

        applesByColor.keySet().forEach(k -> System.out.println(String.format("There is %s %s apples", applesByColor.getOrDefault(k, Collections.emptySet()).size(), k)));
    }

    @Test
    public void removeBigApples() throws Exception {
        appleList.forEach(apple -> {
            applesByColor.computeIfAbsent(apple.getColor(), h -> new HashSet<>()).add(apple);
        });

        applesByColor.values().forEach(k -> k.removeIf(apple -> apple.getWeight() > 10));
        applesByColor.keySet().forEach(k -> System.out.println(String.format("There is %s %s apples", applesByColor.getOrDefault(k, Collections.emptySet()).size(), k)));
    }


    @Test
    public void findTheBiggestApple() throws Exception {
        appleList.stream().max(Comparator.comparingDouble(a -> a.getWeight())).ifPresent(System.out::print);
    }

    @Test
    public void streamToArray() throws Exception {
        Double[] orangeColoredSizes = appleList.stream().filter(a -> a.getColor().equals("orange")).map(Apple::getWeight).toArray(Double[]::new);
        assertTrue(orangeColoredSizes.length > 0);
    }
}
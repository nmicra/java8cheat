/*
 * User: nisann
 * Date: 09/11/2017 
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA. 
 */
package com.lambdas;

import com.streams.ApplesGenerator;
import com.streams.pojo.Apple;
import com.streams.utils.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class BasicLambdas2 {

    private final ApplesGenerator generator = new ApplesGenerator();

    private List<Apple> appleList;


    @BeforeEach
    public void setUp() throws Exception {
        appleList = generator.generate(1000);
        assertTrue(appleList.size() > 0);

    }

    @Test
    public void deleteRandomApple() {
        int size = appleList.size();
        deleteAppleByWeightOldWay(getRandomApple().getWeight());
        assertTrue(size - 1 == appleList.size());
        deleteAppleByWeightNewWay(getRandomApple().getWeight());
        assertTrue(size - 2 == appleList.size());
    }

    public void deleteAppleByWeightNewWay(double weight) {
        Apple apple = findByWeight(weight).orElseThrow(() -> new RuntimeException("Apple wasnt found in the list"));
        deleteApple(apple);
    }

    public void deleteAppleByWeightOldWay(double weight) {
        Optional<Apple> apple = findByWeight(weight);
        if (!apple.isPresent()) {
            throw new RuntimeException("Apple wasnt found in the list");
        }
        deleteApple(apple.get());
    }

    private void deleteApple(Apple apple) {
        appleList.remove(apple);
    }

    private Optional<Apple> findByWeight(double weight) {
        return appleList.stream().filter(a -> a.getWeight() == weight).findFirst();
    }

    private Apple getRandomApple() {
        return appleList.get(RandomUtils.random(appleList.size()));
    }

}
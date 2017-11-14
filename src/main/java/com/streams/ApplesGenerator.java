/*
 * User: nisann
 * Date: 09/11/2017 
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA. 
 */
package com.streams;


import com.streams.pojo.Apple;
import com.streams.utils.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class ApplesGenerator {


	private final List<String> colors = Arrays.asList("red", "blue", "green", "yellow", "purple", "grey", "black", "orange");

	public List<Apple> generate(int num){
		return IntStream.range(0,num)
				.mapToObj(i ->  new Apple(colors.get(i % colors.size()) , RandomUtils.getRn().nextDouble() * num) )
				.collect(Collectors.toList());
	}



}
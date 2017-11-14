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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class BasicLambdas1 {

	private final ApplesGenerator generator = new ApplesGenerator();

	private List<Apple> appleList;


	@BeforeEach
	public void setUp() throws Exception {
		appleList = generator.generate(1000);
		assertTrue(appleList.size() > 0);
	}

	@Test
	public void generateApples() throws Exception {

		// print the green apples that weight more than 5 kg, limit to 7 items
		appleList.stream().filter(apple -> apple.getColor().equals("green")).
				filter(apple -> apple.getWeight() > 5).
				limit(7).
				forEach(System.out::print);
	}


	@Test
	public void ifThenElse() throws Exception {

		Apple a1 = getAppleNumber50(null);
		Apple a2 = getAppleNumber50J8(null);
		assertTrue(a1.equals(a2));

		List<Apple> apples = generator.generate(70);
		Apple a3 = getAppleNumber50(apples);
		Apple a4 = getAppleNumber50J8(apples);
		assertTrue(a3.equals(a4));

		List<Apple> tenApples = generator.generate(10);
		Apple a5 = getAppleNumber50(tenApples);
		Apple a6 = getAppleNumber50J8(tenApples);
		assertTrue(a5.equals(a6));
	}


	private Apple getAppleNumber50(List<Apple> apples) {
		return (apples != null && apples.size() >= 50 && apples.get(50) != null) ? apples.get(50) : new Apple("green", 0);
	}

	private Apple getAppleNumber50J8(List<Apple> apples) {
		return Optional.ofNullable(apples).
				filter(apples1 -> apples1.size() >= 50).
				map(a -> a.get(50)).
				orElse(new Apple("green", 0));
	}

}
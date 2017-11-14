/*
 * User: nisann
 * Date: 09/11/2017 
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA. 
 */
package com.streams.utils;

import java.util.Random;

/**
 *
 */
public class RandomUtils {

	private final static Random rn = new Random();


	public static Random getRn() {
		return rn;
	}

	/**
	 * random number including min & max
	 *
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min, int max) {
		return rn.nextInt(max - min + 1) + min;
	}

	public static int random(int num) {
		return random(0, num);
	}
}
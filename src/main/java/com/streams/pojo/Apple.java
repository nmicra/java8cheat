/*
 * User: nisann
 * Date: 09/11/2017 
 *
 * Copyright (2005) IDI. All rights reserved.
 * This software is a proprietary information of Israeli Direct Insurance.
 * Created by IntelliJ IDEA. 
 */
package com.streams.pojo;

/**
 *
 */
public class Apple {

	private  String color;

	private double weight;

	public Apple(String color, double weight) {
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple{" +
				"color='" + color + '\'' +
				", weight=" + weight +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Apple apple = (Apple) o;

		if (Double.compare(apple.weight, weight) != 0) return false;
		return color.equals(apple.color);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = color.hashCode();
		temp = Double.doubleToLongBits(weight);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
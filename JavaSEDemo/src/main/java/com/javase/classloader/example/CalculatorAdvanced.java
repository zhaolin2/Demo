package com.javase.classloader.example;


import com.javase.classloader.ICalculator;

public class CalculatorAdvanced implements ICalculator {

	public String calculate(String expression) {
		return "Result is " + expression;
	}

	@Override
	public String getVersion() {
		return "2.0";
	}

}

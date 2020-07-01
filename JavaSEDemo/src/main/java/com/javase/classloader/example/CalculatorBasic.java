package com.javase.classloader.example;


import com.javase.classloader.ICalculator;

public class CalculatorBasic implements ICalculator {

	public String calculate(String expression) {
		return expression;
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

}

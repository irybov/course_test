package ru.parsentev.task_001;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;

/**
 * @author parsentev
 * @since 18.07.2016
 */
public class Calculator {
    private static final Logger log = getLogger(Calculator.class);

    private double result;
    
    public double getResult() {
        return result;
    }

    public void add(double first, double second) {
        result = first + second;
    }

    public void substract(double first, double second) {
        result = first - second;
    }

    public void multiple(double first, double second) {
        result = first * second;
    }

    public void div(double first, double second) {
    	if(second==0) {
    		throw new IllegalStateException();
    	}
        result = first / second;
    }

    public void expand(double first, double second) {
        result = Math.pow(first, second);
    }
}

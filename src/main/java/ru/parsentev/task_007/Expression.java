package ru.parsentev.task_007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.parsentev.task_001.Calculator;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {
    	if(expr.length()!=3) {
        throw new IllegalStateException();
    	}
    	Calculator calculator = new Calculator();
    	String[] values = expr.split("");
    	double a = Double.valueOf(values[0]);
    	double b = Double.valueOf(values[2]);
    	if(values[1].equals("+")) {
    		calculator.add(a, b);
    	}
    	else if(values[1].equals("-")) {
    		calculator.substract(a, b);
    	}
    	else if(values[1].equals("/")) {
    		calculator.div(a, b);
    	}
    	else if(values[1].equals("*")) {
    		calculator.multiple(a, b);
    	}
    	else {
    		calculator.expand(a, b);
    	}
    	return calculator.getResult();
    }
}

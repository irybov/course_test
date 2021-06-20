package ru.parsentev.task_010;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.parsentev.task_009.UniqueChars;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Brackets {
    private static final Logger log = getLogger(Brackets.class);
    private final String line;

    public Brackets(final String line) {
        this.line = line;
    }

    public boolean isCorrect() {
    	int open = 0;
    	int close = 0;
    	String[] values = line.split("");
        for(String value: values) {
        	if(value.equals("(")) {
        		open++;
        	}
        	else {
        		close++;
        	}
        }
    	if(open == close) {
    		return true;
    	}
        return false;
    }
}

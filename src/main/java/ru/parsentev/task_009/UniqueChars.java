package ru.parsentev.task_009;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class UniqueChars {
    private final String line;

    public UniqueChars(final String line) {
        this.line = line;
    }

    public int unique() {
    	String[] values = line.split("");
    	Set<String> unique = new HashSet<>();
    	for(String value: values) {
    		unique.add(value);
    	}
    	return unique.size();
    }
}

package ru.parsentev.task_020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ru.parsentev.task_015.CycleShift;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Combine {
    private static final Logger log = getLogger(Combine.class);

    private final int[] values;

    public Combine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> generate() {

    	CycleShift shifter = new CycleShift(values);
    	List<List<Integer>> lists = new ArrayList<>();
    	lists.add(convertion(values));
    	
    	int counter = 0;
    	while(counter<values.length-1) {
    	int[] result = shifter.shift(1);
    	lists.add(convertion(result));
    	counter++;
    	}
    	return lists;
    }
    
    private List<Integer> convertion(int[] numbers){
    	
    	List<Integer> converted = new ArrayList<>();

    	for(int number: numbers) {
    		converted.add(number);
    	}
    	
    	return converted;
    }
}

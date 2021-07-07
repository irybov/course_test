package ru.parsentev.task_020;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

//    	CycleShift shifter = new CycleShift(values);
    	List<List<Integer>> lists = new ArrayList<>();  	
    	lists.add(convertion(values));
    	int[] result = reverse();
    	if(values.length > 2) {
	    	lists.add(convertion(result));
    	}
    	
    	int counter = 0;
    	while(counter<values.length-1) {
	    	result = new CycleShift(result).shift(1);
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
    
    private int[] reverse(){

    	int[] head = Arrays.copyOfRange(values, 0, values.length/2);   	
    	int[] tail = Arrays.copyOfRange(values, values.length/2, values.length);
    	
    	CycleShift shifter = new CycleShift(tail);		
    	tail = shifter.shift(tail.length-1);
    	
    	int[] result = new int[head.length + tail.length];
    	System.arraycopy(head, 0, result, 0, head.length);  
    	System.arraycopy(tail, 0, result, head.length, tail.length);    	
    	return result;
    }
    
}

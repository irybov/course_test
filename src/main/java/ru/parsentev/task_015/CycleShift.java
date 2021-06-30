package ru.parsentev.task_015;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.Arrays;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CycleShift {
    private static final Logger log = getLogger(CycleShift.class);

    private final int[] values;

    public CycleShift(final int[] values) {
        this.values = values;
    }

    public int[] shift(int position) {
//    	if(values.length==1) {
    	if(values.length<=1 || position==0) {
    		return values;
    	}
//    	int counter = 0;
//    	while(counter<position) {
        int temp = values[values.length-1];
        for(int i = values.length-1; i>0; i--) {
        	values[i] = values[i-1];
        }
        values[0] = temp;
//        counter++;
//    	}
    	return shift(position-1);
    }
}

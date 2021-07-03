package ru.parsentev.task_017;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class CashMachine {
    private static final Logger log = getLogger(CashMachine.class);

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
    	
    	int temp = note;
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	for(int i = 0; i < values.length; i++) {
	  		if(temp < values[i]){
	    		continue;
	    	}
    		else {
				List<Integer> coins = new ArrayList<>();
    			while(temp>=values[i]) {
    				temp-=values[i];
	    			coins.add(values[i]);
    			}
    			result.add(coins);
    		}
    		temp = note;
    	}   	
    	return sorting(result);
    }
    
    private  List<List<Integer>> sorting(List<List<Integer>> result){
    	
        result.sort((xs1, xs2) -> xs1.size() - xs2.size());
    	return result;
    }
    
}

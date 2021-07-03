package ru.parsentev.task_017;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	for(int i = 0; i < values.length; i++) {
    		if(note == values[i]) {
    			result.add(Collections.singletonList(values[i]));
    		}
    		else if(note < values[i]){
    			continue;
    		}
    		else {
    			note-=values[i];
    			List<Integer> fiber = new ArrayList<>();
    			fiber.add(note);
    			result.add(fiber);
    		}
    	}   	
    	return sorting(result);
    }
    
    private  List<List<Integer>> sorting(List<List<Integer>> result){
/*    	
    	Collections.sort(result, new Comparator<List>(){
    	    public int compare(List a1, List a2) {
    	        return a1.size() - a2.size();
    	    }
    	});
*/    	
        result.sort((xs1, xs2) -> xs1.size() - xs2.size());
    	return result;
    }
    
}

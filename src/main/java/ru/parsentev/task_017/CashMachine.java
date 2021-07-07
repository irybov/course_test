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
    	
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	
        combine(results, new ArrayList<Integer>(), values, note, 0, 0);
  	
    	return sorting(results);
    }
    
    private void combine(List<List<Integer>> results, List<Integer> coins, int[] values,
    					 								   int note, int sum, int start){
        if(sum == note){
            List<Integer> stock = new ArrayList<Integer>(coins);
            results.add(stock);
            return;
        }
        if(sum > note) {
        	return;
        }
        
        for(int i = start; i<values.length; i++){
            coins.add(values[i]);
            combine(results, coins, values, note, sum + values[i], i);
            coins.remove(coins.size()-1);
        }       
    }
    
    private  List<List<Integer>> sorting(List<List<Integer>> results){
    	
    	for(List<Integer> coins: results) {
    		Collections.sort(coins, Collections.reverseOrder());
    	}    	
        results.sort((xs1, xs2) -> xs1.size() - xs2.size());
    	return results;
    }
    
}

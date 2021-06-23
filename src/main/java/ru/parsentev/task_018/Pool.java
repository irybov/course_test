package ru.parsentev.task_018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Pool {
    private static final Logger log = getLogger(Pool.class);

    private final int[][] values;

    public Pool(final int[][] values) {
        this.values = values;
    }

    public int maxUnion() {
    	List<Node> root = new ArrayList<>();
        int max = 0;
        int row, col;
        for(row=0; row<values.length; row++) {
        	for(col=0; col<values[row].length; col++) {
        		if(values[row][col]==1) {
        			root.add(new Node(row, col, Copier.deepCopy(values)));
        		}
        	}
        }
        for(int i = 0; i < root.size(); i++) {
        	int current = root.get(i).seeker(8);
        	if(max < current) {
        		max = current;
        	}
        }        
        return max;
    }
    
}

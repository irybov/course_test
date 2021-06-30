package ru.parsentev.task_018;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;
import ru.parsentev.task_002.Point;

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

        for(int row=0; row<values.length; row++) {
        	for(int col=0; col<values[row].length; col++) {
        		if(values[row][col]==1) {
        			root.add(new Node(new Point(row,col), values));
        		}
        	}
        }
        for(int i = 0; i < root.size(); i++) {
        	if(max < root.get(i).starter()) {
        		max = root.get(i).starter();
        	}
        }        
        return max;
    }
    
}

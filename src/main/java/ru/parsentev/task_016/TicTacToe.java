package ru.parsentev.task_016;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class TicTacToe {
    private static final Logger log = getLogger(TicTacToe.class);

    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        int result = 0;
        int row, col;
        for(row=0; row<values.length; row++) {
        	for(col=0; col<values[row].length; col++) {
        			result+=values[row][col];
    		}
			if(result==3) {
				return true;
			}
			result = 0;
        }
        for(col=0; col<values.length; col++) {
        	for(row=0; row<values.length; row++) {
    			result+=values[row][col];
    		}
			if(result==3) {
				return true;
			}
			result = 0;
        }
        for(row=0; row<values.length; row++) {
        	col=row;
			result+=values[row][col];
        }
			if(result==3) {
				return true;
			}
		result = 0;
        for(col=0; col<values.length; col++) {
        	row=(values.length-1)-col;
			result+=values[row][col];
        }
			if(result==3) {
				return true;
			}
		result = 0;
		return false;
    }
}

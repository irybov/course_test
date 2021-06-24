package ru.parsentev.task_019;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_018.Pool;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Maze {
    private static final Logger log = getLogger(Maze.class);

    private final int[][] values;
    
    public Maze(final int[][] values) {
        this.values = values;
    }

    public List<Point> solution(Point start, Point finish) {
    	
        Pool pool = new Pool(values);   	
        pool.maxUnion();
        
        for(int i = 0; i < pool.root.size(); i++) {
        	
        }
        
        return;
    }
}

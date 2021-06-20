package ru.parsentev.task_003;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parsentev.task_002.Point;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Triangle {
    private static final Logger log = getLogger(Triangle.class);

    protected final Point first;
    protected final Point second;
    protected final Point third;

    public Triangle(final Point first, final Point second, final Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean exists() {
        return ((first.getX()-second.getX()-third.getX())!=0
        		&& (first.getY()-second.getY()-third.getY())!=0);
    }

    public double area() {
    	if(exists()) {
    		double legX = Math.abs(first.getX()-second.getX()-third.getX());
    		double legY = Math.abs(first.getY()-second.getY()-third.getY());
    		double triangleArea = (legX * legY) / 2;
    		return triangleArea;
    	}
        throw new java.lang.IllegalStateException();
    }
}

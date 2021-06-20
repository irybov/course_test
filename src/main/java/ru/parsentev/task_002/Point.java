package ru.parsentev.task_002;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Class Point defines a point in coordination system (x, y).
 * @author parsentev
 * @since 19.07.2016
 */
public class Point {
    private static final Logger log = getLogger(Point.class);

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(final Point point) {
        double legX = Math.abs(point.x - x);
        double legY = Math.abs(point.y - y);
        double hypotenuse = Math.sqrt(Math.pow(legX, 2) + Math.pow(legY, 2));
        return hypotenuse;
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

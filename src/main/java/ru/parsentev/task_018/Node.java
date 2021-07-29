package ru.parsentev.task_018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ru.parsentev.task_002.Point;
import ru.parsentev.task_019.Copier;

public class Node {
	
	private Point entry;
	private int[][] board;
	
	private List<List<Point>> path = new ArrayList<List<Point>>();
	private Point finish;
	private List<Point> fiber = new ArrayList<>();
	
	public Node(Point entry, int[][] board){
		this.entry = entry;
		this.board = board;
	}
	
	public List<Point> getPath(Point finish) {
		this.finish = finish;
		finder(entry);
		return minimal(path);
	}

	public int starter() {
		return seeker(entry);
	}

	public int seeker(Point point) {

		List<Point> legal = generator(point);
		if(legal.size()==0) {
			return 0;
		}
		List<Integer> scores = new ArrayList<>();
			
		for(int i = 0; i < legal.size(); i++) {

			board[legal.get(i).getX()][legal.get(i).getY()] = 0;		
			
			int score = seeker(legal.get(i));
			score+=1;
			scores.add(score);
			
			board[legal.get(i).getX()][legal.get(i).getY()] = 1;				
			}		
		return max(scores);
	}
	
	public void finder(Point point) {

		path.add(fiber);

		while(!point.equals(finish)) {
			fiber.add(point);
			board[point.getX()][point.getY()] = 0;
		List<Point> legal = generator(point);
		if(legal.size()==0) {
			break;
		}
		for(int i = 0; i < legal.size(); i++) {
			
			if(i > 0) {
				List<Point> fork = new ArrayList<>(path.get(path.size()-1));
				fork.addAll((new Node(legal.get(i), Copier.deepCopy(board))).getPath(finish));
				path.add(fork);
			}
			else {
			point = legal.get(i);
			}
		}
		}
		fiber.add(finish);
	}
	
	private List<Point> generator(Point root){
		
		List<Point> moves = new ArrayList<>();
		int r, c;

		r = root.getX() + 1;
		c = root.getY();
		if(correct(r,c) && board[r][c]==1) {
			moves.add(new Point(r,c));
		}
		r = root.getX() - 1;
		c = root.getY();
		if(correct(r,c) && board[r][c]==1) {
			moves.add(new Point(r,c));
		}
		r = root.getX();
		c = root.getY() + 1;
		if(correct(r,c) && board[r][c]==1) {
			moves.add(new Point(r,c));
		}
		r = root.getX();
		c = root.getY() - 1;
		if(correct(r,c) && board[r][c]==1) {
			moves.add(new Point(r,c));
		}		
		return moves;
	}
	
	private boolean correct (int r, int c) {
		return ((r >=0 & r < board.length) & ( c >=0 & c < board[0].length));
	}
	
	private int max(List<Integer> scores) {	

		int max = Integer.MIN_VALUE+1;
		for(int i=0; i<scores.size();i++){
			if (scores.get(i) > max){
				max = scores.get(i);
			}
		}	
	return max;	
	}
	
	
    private List<Point> minimal(List<List<Point>> lists){
    	
    	return Collections.min(lists, Comparator.comparingInt(List::size));
    }
}

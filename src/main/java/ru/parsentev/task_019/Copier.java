package ru.parsentev.task_019;

public class Copier {

	public static int[][] deepCopy(int[][] A) {
		int[][] B = new int[A.length][A[0].length];
	    for (int x = 0; x < A.length; x++) {
	      for (int y = 0; y < A[x].length; y++) {
	          B[x][y] = A[x][y];
	      	}
	    }
	    return B;
	  }
}

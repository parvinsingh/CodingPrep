package HackerRank2;

import java.util.ArrayDeque;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/

public class RottenOranges2 {

	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
		int[][] grid1 = {{2,1,1},{1,1,0},{0,1,1}};
		int[][] grid2 = {{0,2}};
		int[][] grid3 = {{1,1,2,0,2,0}};
		System.out.println(timeToRot(grid));
	}

	private static int timeToRot(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int goodCount = 0;
		Queue<Orange> badOranges = new ArrayDeque<Orange>();
		RottenOranges2 ro = new RottenOranges2();
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					goodCount++;
				}else if(grid[i][j] == 2) {
					badOranges.add(ro. new Orange(i, j));
				}
			}
		}
		int time = 0;
		while(!badOranges.isEmpty()) {
			int size = badOranges.size();
			boolean change = false;
			for(int i=0; i<size; i++) {
				Orange O = badOranges.remove();
				
				if(O.row-1 >= 0 && grid[O.row-1][O.col] == 1) {
					grid[O.row-1][O.col] = 2;
					goodCount--;
					badOranges.add(ro. new Orange(O.row-1, O.col));
					change = true;
				}
				if(O.row+1 < rows && grid[O.row+1][O.col] == 1) {
					grid[O.row+1][O.col] = 2;
					goodCount--;
					badOranges.add(ro. new Orange(O.row+1, O.col));
					change = true;
				}
				if(O.col-1 >= 0 && grid[O.row][O.col-1] == 1) {
					grid[O.row][O.col-1] = 2;
					goodCount--;
					badOranges.add(ro. new Orange(O.row, O.col-1));
					change = true;
				}
				if(O.col+1 < cols && grid[O.row][O.col+1] == 1) {
					grid[O.row][O.col+1] = 2;
					goodCount--;
					badOranges.add(ro. new Orange(O.row, O.col+1));
					change = true;
				}
			}
			if(change) {
				time++;
			}
		}
		
		return goodCount == 0 ? time : -1;
	}
	
	class Orange{
		int row;
		int col;
		
		Orange(int r, int c){
			row = r;
			col = c;
		}
	}
}

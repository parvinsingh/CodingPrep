package HackerRank2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * grid of rooms
 * 4 walls - each wall has a door
 * 
 * 1011
 * 0110
 * 1000
 * 1101
 * 
 * r1,r2,r7
 * r3,r4,r8
 * r5,r6,r9
 * 
 * room[] rooms = {room1, room2, room3, room4}
 * 
 * 11
 * 00     room (r,l,t,b)   (0110)
 */
public class mockTest {

	public static void main(String args[]) {
		int[][] input = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
		room[][] grid = GridSetup(3, 3, input);
		boolean result = isThereAPath(grid);
		System.out.println(result);
	}
	
	public static room[][] GridSetup(int rows, int cols, int[][] doors){
		mockTest mt = new mockTest();
		room[][] grid = new room[rows][cols];
		int idx = 0;
		int idxfact = 0;
		for(int i=0; i<rows; i++) {
			idxfact = idxfact + cols;//3,6,9
			for(int j=0; j<cols && idx<idxfact; j++) {
				grid[i][j] = mt. new room(doors[idx][0],doors[idx][1],doors[idx][2],doors[idx][3],i,j);//0,1,2,3
				idx = idx+1;
			}
		}
		return grid;
	}
	
	public static boolean isThereAPath(room[][] grid) {
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		Queue<room> q = new ArrayDeque<>();
		q.add(grid[rows-1][cols-1]); // add Grid(room)
		
		while(!q.isEmpty()) {
			room currentRoom = q.remove();

			if(currentRoom.row == 0 && currentRoom.col == 0) {
				return true;
			}
			
			List<room> openRooms = OpenRooms(currentRoom, grid);//from rm9 -> rm6, 8
			boolean result = false;
			for(room orm: openRooms) { //rm6 -> rm4
				if(!orm.canVisit) {
					orm.visit(); //to avoid duplicate insertion into queue
					q.add(orm);//rm6, rm4

					result = true;
				}
			}
			if(!result) {
				return false;//no open rooms at this point
			}
		}
		return true;
	}
	
	//ip = rm9   
	private static List<room> OpenRooms(room currentRoom, room[][] grid) {
		int row = currentRoom.row;
		int col = currentRoom.col;
		List<room> openRooms = new ArrayList<room>();
		if(currentRoom.l == 1) {
			openRooms.add(grid[row][col-1]);
		}
		if(currentRoom.t == 1) {
			openRooms.add(grid[row-1][col]);
		}
		if(currentRoom.r == 1) {
			openRooms.add(grid[row][col+1]);
		}
		if(currentRoom.b == 1) {
			openRooms.add(grid[row+1][col]);
		}
		return openRooms;
	}

	class room{
		int r;
		int l;
		int t;
		int b;
		int row;
		int col;
		boolean canVisit = false;
		
		room(int r, int l, int t, int b, int i, int j){
			r=r;
			l=l;
			t=t;
			b=b;
			row = i;
			col = j;
		}
		
		public void visit() {
			canVisit = true;
		}
	}
}

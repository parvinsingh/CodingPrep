package HackerRank2;

public class FlipGames {

	public static void main(String args[]) {
		System.out.println(canWin("++++"));
	}

	private static boolean canWin(String str) {
		if(str == null || str.isEmpty()) {
			return false;
		}
		return canWinHelper(str.toCharArray());
	}

	private static boolean canWinHelper(char[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] == '+' && arr[i+1] == '+') {
				arr[i] = '-';
				arr[i+1] = '-';
				
				boolean canWin = canWinHelper(arr);//--++, --++ false
				
				arr[i] = '+';
				arr[i+1] = '+';
				
				if(!canWin) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}

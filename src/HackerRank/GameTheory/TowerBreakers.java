package HackerRank.GameTheory;

public class TowerBreakers {

	static int towerBreakers(int numOfTowers, int height) {
        int[] towers = new int[numOfTowers];
        for(int i=0; i<numOfTowers; i++){
            towers[i] = height;
        }
        return makeMove(towers, 1, numOfTowers);
    }

    static int makeMove(int[] towers, int player, int num){
        int i=0;
        while(i < num){
            if(towers[i]%2 == 0){
                towers[i] = towers[i]/2;
                player = (player == 1) ? 2 : 1;
            }else{
                i++;
            }
        }
        return (player == 1) ? 2 : 1;
    }
    
    public static void main(String args[]) {
    	System.out.println(towerBreakers(1, 4));
    }
}

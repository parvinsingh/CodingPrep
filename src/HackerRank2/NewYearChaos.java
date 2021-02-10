package HackerRank2;

public class NewYearChaos {

	public static void main(String args[]) {
		int[] queue = {5, 1, 2, 3, 7, 8, 6, 4};
		minimumBribes(queue);
	}
	
	//q= 1,2,5,3,7,8,6,4
	//i= 0,1,2,3,4,5,6,7
	//i=7
	static void minimumBribes(int[] q) {
        int total = 0;
        for(int i=q.length-1; i>0; i--){
            if(q[i] - (i+1) > 2 ){
                System.out.println("Too chaotic");
                return;
            }
            //check how many people are ahead of q[i]
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {//2,3,4,5 to 7
                if (q[j] > q[i]) 
                {
                     total++;
                }
            }
            //int bribes = q[i] - (i+1);
            //total = bribes<=0 ? total : total+bribes;
        }
        System.out.println(total);
    }
}

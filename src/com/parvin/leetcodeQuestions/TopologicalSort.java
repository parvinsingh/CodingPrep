package com.parvin.leetcodeQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
	
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    // TODO: Write your code here
    HashMap<Integer, Integer> map2Edge = new HashMap<>();
    for(int i=0; i<vertices; i++){
      map2Edge.put(i, 0);
    }

    for(int k=0; k<edges.length; k++){
      int c = map2Edge.get(edges[k][1]);
      map2Edge.put(edges[k][1], ++c);//2 - 3, 0-3,2, 1-2
      //3-2, 3-0, 2-0,1 
    }

    List<Integer> keys = new ArrayList<>(map2Edge.keySet());
    Queue<Integer> qu = new LinkedList<>();

    for(int m : keys){
      if(map2Edge.get(m)==0){
        qu.add(m);
      }
    }
    
    while(!qu.isEmpty()){
      int top = qu.poll();//3
      sortedOrder.add(top);//3
      for(int k=0; k<edges.length; k++){
        if(top == edges[k][0]){
          int temp = map2Edge.get(edges[k][1]);
          map2Edge.put(edges[k][1], --temp);
          if(temp==0){
            qu.add(edges[k][1]);
          }
        }
      }
    }

    return sortedOrder;
  }
  
  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
        new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
        new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
        new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}
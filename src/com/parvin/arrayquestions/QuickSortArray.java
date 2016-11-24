package com.parvin.arrayquestions;

public class QuickSortArray {
	
	public static void main(String[] args){
		int[] arr = {1,2,21,45,11,13,7,8,9,4};
		quickSort(arr);
	}

	//QuickSort time: O(nlog n) average, worst O(n^2). Memory:O(log N)
	 
    public static void quickSort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        quickSort(inputArr, 0, inputArr.length-1);
        for(int i=0; i<inputArr.length; i++){
			System.out.println(inputArr[i]);
		}
    }
 
    private static void quickSort(int[] array, int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(array, i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
 
    private static void exchangeNumbers(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

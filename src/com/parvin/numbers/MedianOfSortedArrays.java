package com.parvin.numbers;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 * 
 * @author papanesa
 *
 */
public class MedianOfSortedArrays {

	public static void main(String args[]) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4,5};
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println(median);
	}
	
	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median;
		int l1 = nums1.length;
		int l2 = nums2.length;
        int[] nums3 = mergeTwoSortedArrays(nums1, nums2, l1, l2);
        if(nums3.length % 2 == 0) {
        	//even number of values
        	int medianIndex = nums3.length / 2;
        	median = ((double)nums3[medianIndex] + (double)nums3[medianIndex-1])/2;
        }else {
        	int medianIndex = nums3.length / 2;
        	median = nums3[medianIndex];
        }
        return median;
    }
	
	private static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2, int l1, int l2) {

        int[] nums3 = new int[l1+l2];
        int i = 0,j = 0, k=0;
        while(i<l1 && j<l2) {
        	if (nums1[i] < nums2[j]) {
        		nums3[k] = nums1[i];
        		i++;
        	}else {
        		nums3[k] = nums2[j];
        		j++;
        	}
        	k++;
        }
        while(i < l1) {
        	nums3[k] = nums1[i];
        	i++;
        	k++;
        }
        while(j < l2) {
        	nums3[k] = nums2[j];
        	j++;
        	k++;
        }
        return nums3;
	}
}

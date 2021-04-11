package com.parvin.arrayquestions;

/*
 * We need to perform multiple operations on a large number of files over our network. 
 * Each file is represented by a lowercase English letter. 
 * The complete file list will be provided to us in the form of a string like "abacdc". 
 * The position of each letter tells us the sequence in which the files need to be processed.
 * 
 * We’ll be provided with a string of characters representing the number of files in the sequence they need to be processed. 
 * Our task is to divide the files according to the defined criteria and return the number of nodes needed to process them.
 */
public class DivideFilesOverNetwork {

    public static int partitionLabels(String files) {
        // Compute the last occurences of each letter
        int[] last = new int[26];
        for (int i = 0; i < files.length(); ++i)
            last[files.charAt(i) - 'a'] = i;
        
        int start = 0, end = 0, count = 0;

        // Traverse the string
        for (int i = 0; i < files.length(); ++i) {
            // Compute the highest last occurence position
            end = Math.max(end, last[files.charAt(i) - 'a']);
            
            // Clause for when we reach the highest last occurence position
            if (i == end) {
                count++;
                start = i + 1;
            }
        }
        return count;
    }
    public static void main( String args[] ) {
        // Driver code

        String files = "abacdc";
        System.out.println("The files " + '"' + files + '"' + " will be divided into " + partitionLabels(files) + " worker nodes!");
    }
}

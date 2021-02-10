package com.parvin.arrayquestions;

public class ImageFinder {
  public static void main(String[] argv) {
    int[][] image1 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image2 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 0}
    };

    int[][] image3 = {
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 0, 0},
      {1, 1, 1, 1, 1, 0, 0}
    };

    int[][] image4 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1}
    };

    int[][] image5 = {
      {0}
    };

    rectangle(image1);
    rectangle(image2);
    rectangle(image3);
    rectangle(image4);
    rectangle(image5);
    
  }
  
  private static void rectangle(int[][] image){
    int firstR = -1; int firstC = -1;
    int height = 1; int width = 1;
    for(int i=0; i<image.length; i++){
      for(int j=0; j<image[0].length; j++){
        if(image[i][j]==0){
          //System.out.println(i + "," +j);
          firstR = i;
          firstC = j;
          break;
        }
      }
      if(firstR != -1 && firstC != -1) {
      	break;
      }
    }
    if(firstR == -1 && firstC == -1) {
    	System.out.println("no image found");
    	return;
    }
  int startRowIndex = firstR;
  int startColIndex = firstC;
  
  while(firstR < image.length-1 && firstC < image[0].length-1){
	  if(image[firstR][firstC+1]==1 && image[firstR+1][firstC]==1) {
	    	break;
	    }
    if(image[firstR+1][firstC] == 0){
      height++;
      firstR++;
    }
    if(image[firstR][firstC+1] == 0){
      width++;
      firstC++;
    }
  }
  System.out.println(startRowIndex + "," + startColIndex + "," + height + "," +width);
    
  }
}

/* 
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's: top-left coordinate and bottom-right coordinate OR top-left coordinate, width, and height.

image1 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

Sample output variations (only one is necessary):

findRectangle(image1) =>
  x: 3, y: 2, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases:

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  x: 6, y: 4, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  x: 5, y: 3, width: 2, height: 2
  3,5 4,6
  
image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]

findRectangle(image5) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

n: number of rows in the input image
m: number of columns in the input image
*/
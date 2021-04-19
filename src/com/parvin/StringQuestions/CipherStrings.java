package com.parvin.StringQuestions;
/*

You decide to create a substitution cipher. 
The cipher alphabet is based on a key shared amongst those of your friends who don't mind spoilers.

Suppose the key is:
"The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!".
Map<String, Integer>
buffer <- THEQUICKONYXG

We use only the unique letters in this key to set the order of the characters in the substitution table.

T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

(spaces added for readability)

We then align it with the regular alphabet:
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
T H E Q U I C K O N Y X G B L R A S W D J M P V Z F

Which gives us the substitution mapping: A becomes T, B becomes H, C becomes E, etc.

Write a function that takes a key and a string and encrypts the string with the key.

Example:
key = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!"
encrypt("It was all a dream.", key) -> "Od ptw txx t qsutg."
encrypt("Would you kindly?", key) -> "Pljxq zlj yobqxz?"

Complexity analysis:

m: The length of the message
k: The length of the key



*/

public class CipherStrings {
  public static void main(String[] argv) {

  
    String key = "The quick onyx goblin, Grabbing his sword ==}-------- jumps over the 1st lazy dwarf!";
    String message = "It was all a dream.";
    String message2 = "Would you kindly?";

    System.out.println(doEncrypt(key, message));
    System.out.println("================");
    System.out.println(doEncrypt(key, message2));
  }
  
  private static String getMessage(String input, int rows, int cols){
    StringBuffer buff = new StringBuffer();
    String[] arr = input.split("");
    for(int i=0; i<cols; i++){
      buff.append(arr[i]);
      for(int k=i+cols; k<arr.length; k+=cols){
        buff.append(arr[k]);//Oe
      }
    }
    return buff.toString();
  }
  
  private static String doEncrypt(String key, String inpMessage){
    String mapString = createMapping(key);
    return encrypt(inpMessage, mapString);
  }
  
  private static String createMapping(String input){
    input = input.toUpperCase();
    StringBuffer buff = new StringBuffer();
    int i=0;
    while(i < input.length()){
      char c = input.charAt(i);
      if(Character.isLetter(c)){
        if(buff.indexOf(String.valueOf(c))==-1){
          buff.append(c);
        }
      }
      i++;
    }
    return buff.toString();
  }

  private static String encrypt(String input, String mappedString){
    String tempUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String tempLower = tempUpper.toLowerCase();
    System.out.println(mappedString);
    System.out.println(input);
    System.out.println(tempUpper);
    System.out.println(tempLower);
//A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//T H E Q U I C K O N Y X G B L R A S W D J M P V Z F
    StringBuffer buff = new StringBuffer();
    char[] arr = input.toCharArray();
    for(int i=0; i<arr.length; i++){
      if(Character.isLetter(arr[i])){
        int idx = Character.isLowerCase(arr[i]) ? tempLower.indexOf(arr[i]) : tempUpper.indexOf(arr[i]);
        char tempch = Character.isLowerCase(arr[i]) ? mappedString.toLowerCase().charAt(idx) : mappedString.charAt(idx);
        buff.append(tempch);
      }else{
        buff.append(arr[i]);
      }
    }//missing capital case
    return buff.toString();
  }
  
}


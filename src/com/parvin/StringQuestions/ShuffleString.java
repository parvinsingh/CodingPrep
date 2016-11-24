package com.parvin.StringQuestions;

    public class ShuffleString
    {
        public static void main(String args[])
        {

           
            String userInput = "AABBCCCDDDD";//length=11
            String answer = "";
            boolean stillSimilar = true;

            char[] inputArray = userInput.toCharArray();
            while (stillSimilar)
            {
                for (int i = 0; i <= inputArray.length - 1; i++)
                {
                    if (inputArray[i] == inputArray[i + 1])
                    {
                        char tmp = inputArray[i + 1];
                        inputArray[i + 1] = inputArray[(i + 2)%inputArray.length];
                        inputArray[i + 2] = tmp;
                    }
                }
                stillSimilar = isSimilar(inputArray);
            }

            for (int i = 0; i < inputArray.length; i++)
            {
                answer += inputArray[i];
            }
            System.out.print(answer);
        }

        public static boolean isSimilar(char[] input)
        {
            for (int i = 0; i < input.length - 1; i++)
            {
                if (input[i] == input[i + 1]) {
                    return true;
                }
            }
            return false;
        }
    }
package com.parvin.interviewprep;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FlatFileParsing {

	private static final String INPUT_FILE = "SimplePositionalRecordParsingExampleInput.dat";

	public static void main(String args[]){
		try {
			readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block,,,,,,,,
		}
	}
	
	public static void readFile() throws IOException{
		BufferedReader textFileReader = new BufferedReader(new FileReader(INPUT_FILE));
        String line;
        while ( (line = textFileReader.readLine()) != null) {
            System.out.println("Able to read the file");
        }
        textFileReader.close();
	}
}

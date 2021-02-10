package com.parvin.highspot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.*;

public class HighSpot {
	
	final static String INPUT_FILE = "C:\\Users\\papanesa\\git\\CodingPrep\\src\\com\\parvin\\highspot\\mixtape-data.json";
	final static String CHANGE_FILE = "C:\\Users\\papanesa\\git\\CodingPrep\\src\\com\\parvin\\highspot\\ChangeFile.json";
	final static String RESULT_FILE = "C:\\Users\\papanesa\\git\\CodingPrep\\src\\com\\parvin\\highspot\\output.json";
	static Album mixTapeData = new Album();
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String args[]) {
		HighSpot hs = new HighSpot();
		
		displayHelpContent();
		
		Scanner s = new Scanner(System.in);
		String cmd = s.next();
		
		if(cmd.equalsIgnoreCase("Q")) {
			System.exit(1);	
		}
        
		ReadInput();
		
		while(!cmd.equalsIgnoreCase("Q"))
        {
			if(cmd.contains("ShowData")) {
				//hs.showData();
			}else if(cmd.contains("Modify")) {
				hs.modifyData();
			}
			
			System.out.println("Continue making edits ! Enter the change file path or Q for Quit");
			cmd = s.next();
        }
		
		System.exit(1);
	}
	
	private void modifyData() {
    	System.out.println("Inside Modify");
    	try (FileReader reader = new FileReader(CHANGE_FILE))
        {
			ChangeTape edits = mapper.readValue(reader, ChangeTape.class);
			ModifyPlaylist modify = new ModifyPlaylist(mixTapeData.getPlaylists());
			
			System.out.println("Size of remove playlist array = " + edits.getRemovePlaylist().length);
        	
			modify.Remove(edits.getRemovePlaylist());
			
        	System.out.println("Size of create playlist array = " + edits.getCreatePlaylist().length);
        	modify.Create(edits.getCreatePlaylist());
        	
        	System.out.println("Size of Add Songs playlist array = " + edits.getAddSong().length);
        	modify.AddSong(edits.getAddSong());
        	
        	mixTapeData.setPlaylists(modify.getUpdatedList());
        	
        	mapper.writeValue(new File(RESULT_FILE), mixTapeData);
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private static void displayHelpContent() {
		System.out.println("HighSpot Coding Exercies. Use the following helpful commands.");
		System.out.println("-action Modify : To make changes provide the change file");
		System.out.println("-action ShowData - To see the data");
		System.out.println("Q - Quit");
	}
	
	public static void ReadInput() {
		try (FileReader reader = new FileReader(INPUT_FILE))
        {
			mixTapeData = mapper.readValue(reader, Album.class);
        	
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}
	
}

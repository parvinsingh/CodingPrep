package com.parvin.interviewprep;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class MergeFiles {
	
	private static ArrayList<File> existingFiles = new ArrayList<MergeFiles.File>();
	
	public static void main(String args[]) {
		MergeFiles mf = new MergeFiles();
		
		File f1 = mf. new File("123", getDate(31), "fdgwffsds");
		File f2 = mf. new File("234", getDate(15), "ertergf");
		File f3 = mf. new File("345", getDate(25), "dhregbdbb");
		File f4 = mf. new File("456", getDate(5), "bcvbgergdfbv");
		File f5 = mf. new File("567", getDate(12), "sdgsfs");
		File f6 = mf. new File("897", getDate(10), "erpokljsdf");
		File f7 = mf. new File("777", getDate(9), "eofjmcnvx");
		File f8 = mf. new File("555", getDate(30), "cxvmniuoiehnfk");
		File f9 = mf. new File("444", getDate(19), "cxvmniuoiehnfk");
		existingFiles.addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9));
		
		File f10 = mf. new File("345", getDate(0), "dhregbdbb");
		File f11 = mf. new File("888", getDate(0), "bcvbgergdfbv");
		File f12 = mf. new File("123", getDate(0), "bvbefgeravdfv");
		File f13 = mf. new File("111", getDate(0), "safdsgsas");
		List<File> latestFiles = Arrays.asList(f10,f11,f12,f13);
		
		Collections.sort(existingFiles);
		Collections.sort(latestFiles);
		
		FileObject fo = merge(latestFiles);
		
		printList(fo.toAddFiles);
		printList(fo.toUpdateFiles);
		printList(fo.toDeleteFiles);
	}
	
	private static void printList(List<File> files) {
		for(File f: files) {
			System.out.print(f.fileId + ",");
		}
		System.out.println("-----------");
	}
	
	public static FileObject merge(List<File> latestFiles) {
		MergeFiles mf = new MergeFiles();
		
		FileObject fo = mf.new FileObject();
		/*
		 * Update all files that can be updated, and add that are not present
		 * DeleteFiles older than 180
		 * if there are still files to add, delete more files and then add
		 */
		List<File> newLatest = updateAndAddFiles(latestFiles, fo); // updated and add
		
		deleteFiles(newLatest, fo);//deleted old files
		
		if(!newLatest.isEmpty()) {
			newLatest = addFiles(newLatest, fo);
		}
		
		return fo;
	}
	
	private static List<File> updateAndAddFiles(List<File> latest, FileObject fo) {
		List<File> tempLatest = new ArrayList<File>(latest);
		
		SortedSet<String> sortedSet = new TreeSet<String>();
		for(File f : existingFiles) {
			sortedSet.add(f.fileId);
		}
		
		for(File f : latest) {
			boolean isAdd = sortedSet.add(f.fileId);
			if(!isAdd) {
				fo.toUpdateFiles.add(f);
				existingFiles.remove(f);
			}else {
				fo.toAddFiles.add(f);
			}
			tempLatest.remove(f); //remove it from the latest files list.
		}
		return tempLatest;
	}

	private static void deleteFiles(List<File> latest, FileObject fo) {
		List<File> temp = new ArrayList<File>();
		
		for(File f : existingFiles) {
			if(isOlderThan30Days(f.LastModifiedTime)) {
				fo.toDeleteFiles.add(f);
				temp.add(f);
			}
		}

		existingFiles.removeAll(temp); //delete older than 180 days
	}
	
	//this method should free up space, and add file to the existingFiles list
	private static List<File> addFiles(List<File> latest, FileObject fo){
		List<File> tempLatest = new ArrayList<File>(latest);
		List<File> tempRemove = new ArrayList<File>();
		
		for(File f : latest) {
			if(existingFiles.size()>=10) {
				fo.toDeleteFiles.add(f);
				tempRemove.add(f); //assumption: list is sorted, with the oldest record in the front	
			}
			fo.toAddFiles.add(f);
			tempLatest.remove(f);
		}
		existingFiles.removeAll(tempRemove);
		
		return tempLatest;
	}
	
	private static boolean isOlderThan30Days(Date modifiedDate)
	{
	  LocalDate date = modifiedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	  date = date.plusDays(30);
	  LocalDate todaysDate = LocalDate.now();
	  
	  return !date.isAfter(todaysDate);
	}
	
	private static Date getDate(int numOfDays) {
		//default time zone
		ZoneId defaultZoneId = ZoneId.systemDefault();
		
		LocalDate dt = LocalDate.now();
		dt = dt.minusDays(numOfDays);
		
		Date date = Date.from(dt.atStartOfDay(defaultZoneId).toInstant());
		
		return date;
	}
	
	class File implements Comparable<File>{
		private String fileId;
		private Date LastModifiedTime;
		private String fileContent;
		
		//for simplicity using String for timestamp
		File(String id, Date fileTimeStamp, String content){
			fileId = id;
			LastModifiedTime = fileTimeStamp;
			fileContent = content;
		}

		@Override
		public int compareTo(File o) {
			return LastModifiedTime.compareTo(o.LastModifiedTime);
		}
	}
	
	//This class can be made public depending on how it will end up being used.
	class FileObject {
		private List<File> toAddFiles = new ArrayList<MergeFiles.File>();
		private List<File> toDeleteFiles = new ArrayList<MergeFiles.File>();
		private List<File> toUpdateFiles = new ArrayList<MergeFiles.File>();
		
		public List<File> addFiles(){
			return toAddFiles;
		}
		
		public List<File> deleteFiles(){
			return toDeleteFiles;
		}
		
		public List<File> updateFiles(){
			return toUpdateFiles;
		}
	}
}

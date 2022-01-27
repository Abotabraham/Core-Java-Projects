package fileprocessingproject;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * This project specifically works with file system in Java. That's creating, searching, and deleting files in current directory in menu driven manner.
 * Project runs along as the user doen't choose the exit option. 
 * @author George Abot Abraham Ret
 * @version 1.0, 23/01/2022
 *
 */
public class LockedMe {
	private static final String projectFilePath = "/Users/georgeabot/PythonProjects";  // path for the project files 
	// graceful error message for the user
	private static final String erroMessage = "Some error occurred. Please contact: admin@LockedMe.com"; 

	public static void main(String[] args) {
		  System.out.println("****************************************************************");
		  System.out.println("\t\tWelcome to Lockedme.com");
		  System.out.println("****************************************************************\n");
		int choice;
		Scanner scanner = new Scanner(System.in);
		// keep asking the user to perform the operation until exit
		do {
			DisplayFileMenu();
			System.out.print("Enter you choice: ");
			choice = Integer.parseInt(scanner.nextLine());
			switch(choice) {
			case 1: getAllFiles();
			break;
			case 2: createFile();
			break;
			case 3: searchFile();
			break;
			case 4: deleteFile();
			break;
			case 5: System.exit(0);
			default:System.out.println("Invalid Option");
			break;
			}
		}while(choice > 0);
		 scanner.close();
	}
	
	/**
	 *  
	 *  searches a file in the current directory.
	 *  
	 *
	 */
	private static void searchFile() {
		String fileName;
		Scanner scanner = new Scanner(System.in);
		
		try {
		System.out.print("Enter the file name to search: ");
		fileName = scanner.nextLine();
		File folder = new File(projectFilePath);
		File [] listOfFiles = folder.listFiles();
		for(var file: listOfFiles) {
			if(file.getName().equals(fileName)) {
				System.out.println("File Found!");
				return;
			}
		}
		
		System.out.println("File Not Found.");
		
		} catch (Exception ex) {
			System.out.println(erroMessage);
		} 
	}
	/**
	 *  
	 *  Adds file to the current directory.
	 *  Write to the file currently created.
	 *
	 */
	private static void createFile() {
		
		Scanner scanner = new Scanner(System.in);
		
		String fileName;
		try {
		System.out.print("Enter the file: ");
		fileName = scanner.nextLine();
		
		int lineCount;
		
		System.out.print("Enter how many lines to add to the file: ");
		lineCount = Integer.parseInt(scanner.nextLine());
		FileWriter fileWriter = new FileWriter(projectFilePath + "/" + fileName);
		for(int line = 1; line <= lineCount; line++) {
			System.out.print("Enter the file line: ");
			fileWriter.write(scanner.nextLine() + "\n");
		}
		fileWriter.close();
		} catch (Exception ex) {
			System.out.println(erroMessage);
		} 
	}

	/**
	 *  
	 *  Displays the list of all the operations to perform on the files in the current directory.
	 *  
	 *
	 */
	private static void DisplayFileMenu() {
		  System.out.println();
		  System.out.println("\t\t1. Display all the files in current directory. ");
		  System.out.println("\t\t2. Add a new file to the directory. ");
		  System.out.println("\t\t3. Search a file.");
		  System.out.println("\t\t4. Delete a file.");
		  System.out.println("\t\t5. Exit\n");  
	}
	

	/**
	 *  
	 *  Displays the list of all the files in the current directory.
	 *  
	 *
	 */
	private static void getAllFiles() {
		
		File folder = new File(projectFilePath);
		
		File[] listOfFiles = folder.listFiles();
		
		try {
			if(listOfFiles.length == 0) {
				System.out.println("Folder empty. Add some files.");
			}else {
				System.out.println("Below are files in this directory: " + folder);
				Arrays.sort(listOfFiles); // sort files base on their natural order
				System.out.println("\n");
				for(var file: listOfFiles) {
					System.out.println("\t\t"+ file.getName());
				}
			}
		}catch(Exception ex) {
			System.out.println(erroMessage);
		}
	}
	/**
	 *  
	 *  Deletes a specified file from a user.
	 *  
	 *
	 */
	
	private static void deleteFile() {
		String fileName;
		
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter the name of the file to delete: ");
		    fileName  = scanner.nextLine();
		    File file = new File(projectFilePath + "/" + fileName);
		    if(file.exists()) {
		    	file.delete();
		    	System.out.println(fileName + "Deleted Successfully. ");
		    }else {
		    	System.out.println(fileName + " this file doesn't exist in this directory.");
		    }
		}catch(Exception ex) {
			System.out.println(erroMessage);
		} 
		
		
	}
}

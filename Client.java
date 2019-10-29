/**
* Java RMI Client program
*
* @author  Arda Celik
* @version 1.0
* @since   2019-29-10
*/

import java.io.*;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Scanner;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		
		Scanner usrIn = new Scanner(System.in);
		String userId = "";
		String selectService;
		String userQuote;
		File file = null;
		String filename = "./src/"+ userId +".txt/";
		String path = "./src/";
		
		// Welcome the user and get the user ID
		System.out.println("Welcome to the JournalApp.\nPlease enter a 9-digit number as your user ID");
		
		while(true) {
			userId = usrIn.next();
            if(userId.length() != 9) {
            	System.out.println("Incorrect ID format, please enter the 9-digit number");
                continue;
            }
            break;
        }
		
		// Create a user object and assign the ID
		User user = new User();
        user.setUserId(userId);
        
        // Select a service or end the program
        System.out.println("Welcome " + userId + ". To select an activity please enter the corresponding number:");
        System.out.println("1. Create a journal entry");
        System.out.println("2. Reverse a journal entry");
        System.out.println("3. Remove white space from a journal entry");
        System.out.println("4. Delete a journal entry");
        System.out.println("5. Update journal entry");
        System.out.println("6. Exit");
        while(true) {
        	System.out.println("Waiting for user input");
        	selectService = usrIn.next();
        	if(selectService.equals("6")) {
        		// End program
        		System.out.println("Ending the program...");
        		System.exit(1);
        	}
        	else if(selectService.equals("5")) {
        		// Update entry
        		System.out.println("Updating journal");
        		try {
        	         if(file.exists()) {
        	        	 Desktop desktop = Desktop.getDesktop();
        	        	 desktop.open(file);
        	        	 user.setUserJournal(file);
            	         continue;
        	         }
        	         else { 
        	        	 System.out.println ("File does not exist.");
        	        	 continue;
        	         }
        	      }
        	      catch(IOException ioe) {
        	         ioe.printStackTrace();
        	      }
        	}
        	else if(selectService.equals("4")) {
        		// Delete the entry
        		try {
        			Registry registry = LocateRegistry.getRegistry(null);
        			
        			Journal stub = (Journal) registry.lookup("Journal");
        			
        			System.out.println(stub.deleteFile(file, user, path));
        			
        		} catch(Exception e) {
        			 System.err.println("Client exception: " + e.toString()); 
        	         e.printStackTrace();
        		}
        		continue;
        	}
        	else if(selectService.equals("3")) {
        		// Remove white space
        		try {
        			Registry registry = LocateRegistry.getRegistry(null);
        			
        			Journal stub = (Journal) registry.lookup("Journal");
        			
        			System.out.println(stub.removeWhiteSpace(file, user, path));
        			
        		} catch(Exception e) {
        			 System.err.println("Client exception: " + e.toString()); 
        	         e.printStackTrace();
        		}
        		continue;
        		
        	}
        	else if(selectService.equals("2")) {
        		// Reverse
        		try {
        			Registry registry = LocateRegistry.getRegistry(null);
        			
        			Journal stub = (Journal) registry.lookup("Journal");
        			
        			System.out.println(stub.reverseEntry(file, user, path));
        			
        		} catch(Exception e) {
        			 System.err.println("Client exception: " + e.toString()); 
        	         e.printStackTrace();
        		}
        		continue;
        	}
        	else if(selectService.equals("1")) {
        		// Create the journal entry
        		System.out.println("Creating a new journal entry");
        		try {
        			file = new File("./src/"+ userId +".txt/");
        	         
        	         if(file.createNewFile())System.out.println("File successfully created");
        	         else System.out.println ("File already exists.");
        	         
        	         Desktop desktop = Desktop.getDesktop();
        	         if(file.exists()) desktop.open(file);
        	         user.setUserJournal(file);
        	         continue;
        	      }
        	      catch(IOException ioe) {
        	         ioe.printStackTrace();
        	      }
        		
        	}
        	
        }
        
	}

}

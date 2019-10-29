import java.io.*;
import java.util.Scanner;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		
		Scanner usrIn = new Scanner(System.in);
		
		String userId;
		String selectService;
		
		try {
			Registry registry = LocateRegistry.getRegistry(null);
			
			Journal stub = (Journal) registry.lookup("Journal");
			
			stub.createAnEntry();
		} catch(Exception e) {
			 System.err.println("Client exception: " + e.toString()); 
	         e.printStackTrace();
		}
		
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
        System.out.println("2. Read a journal entry");
        System.out.println("3. Update a journal entry");
        System.out.println("4. Delete a journal entry");
        System.out.println("5. Exit");
        while(true) {
        	selectService = usrIn.next();
        	if(selectService.equals("5")) {
        		System.out.println("Ending the program...");
        		System.exit(1);
        	}
        	else if(selectService.equals("4")) {
        		// delete
        	}
        	else if(selectService.equals("3")) {
        		// update
        	}
        	else if(selectService.equals("2")) {
        		// read
        	}
        	else if(selectService.equals("1")) {
        		// create
        		System.out.println("Creating a new journal entry");
        		
        	}
        	else {
        		System.out.println("Invalid input please try again");
        		continue;
        	}
        	
        }
        
	}

}

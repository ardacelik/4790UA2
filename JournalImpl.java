/**
* Java RMI remote interface implementation
*
* @author  Arda Celik
* @version 1.0
* @since   2019-29-10
*/

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.io.*;

public class JournalImpl implements Journal {
	
	/**
	* This method reverses the text in the journal entry.
	* @param file:name of the file to be reversed
	* @param user:user object
	* @param path:the location to store the reversed file
	* @return reversed text
	* @exception IOException and Exception
	*/	
	public String reverseEntry(File file, User user, String path) throws RemoteException {
		// Create an empty file for the reversed version
		File reversedFile = new File(path + user.getUserId()+ "reversed.txt");
		BufferedWriter writer = null;
		try {			
			FileReader fileReader = new FileReader(file);
			String text = "";
			String reverse = "";
			int character;			
            // Take each character and add to the empty string
			while ((character = fileReader.read()) != -1) {
				text += Character.toString((char) character);
			}
			System.out.println("Original File : " + text);
			// Reverse and print
			for(int i = text.length() - 1; i >= 0; i--) {
				reverse = reverse + text.charAt(i);
			}
			System.out.println(reverse);
			// Write the reversed file to the empty file
			fileReader.close();
			try {
				writer = new BufferedWriter(new FileWriter(reversedFile));
				writer.write(reverse);
				writer.close();
			} catch (IOException ie) {
				return "IO Exception";
			}
			return reverse;
            
		} catch (Exception e) {
			return "Something went wrong";
		} 
	}
	
	/**
	* This method removes the white space from the journal entry.
	* @param file:name of the file to be updated
	* @param user:user object
	* @param path:the location to store the reversed file
	* @return updated text
	* @exception IOException and Exception
	*/
	public String removeWhiteSpace(File file, User user, String path) throws RemoteException {
		// Create an empty file for the reversed version
		File noSpaceFile = new File(path + user.getUserId()+ "noSpace.txt");
		BufferedWriter writer = null;
		try {			
			FileReader fileReader = new FileReader(file);
			String text = "";
			String noSpace = "";
			int character;			
            // Take each character and add to the empty string
			while ((character = fileReader.read()) != -1) {
				text += Character.toString((char) character);
			}
			System.out.println("Original File : " + text);
			// Remove space and print
			noSpace = text.replaceAll("\\s", "");
			System.out.println("File after removing all white space: " + noSpace);
			// Write the reversed file to the empty file
			fileReader.close();
			try {
				writer = new BufferedWriter(new FileWriter(noSpaceFile));
				writer.write(noSpace);
				writer.close();
			} catch (IOException ie) {
				return "IO Exception";
			}
			return noSpace;
            
		} catch (Exception e) {
			return "Something went wrong";
		}		
	}

	/**
	* This method removes the journal entry.
	* @param file:name of the file to be removed
	* @param user:user object
	* @param path:the location to remove the file
	* @return success/failure message
	*/	
	public String deleteFile(File file, User user, String path) throws RemoteException {
		if(file.delete()) {
			user.setUserJournal(null);
			
            System.out.println("Journal entry deleted successfully");
            return "Journal entry deleted from the server";
        } else { 
            System.out.println("Failed to delete the journal entry"); 
            return "Journal entry could not be deleted from the server";
        } 
		
	}
		
}


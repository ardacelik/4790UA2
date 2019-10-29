import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.io.*;

public class JournalImpl implements Journal {

	@Override
	public void createAnEntry() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	public String reverseEntry(File file, User user, String path) throws RemoteException {
		// Create an empty file for the reversed version
		File reversedFile = new File(path + user.getUserId()+ "reversed.txt");
		BufferedWriter writer = null;
		try {			
			FileReader fileReader = new FileReader(file);
			String stringToCast = "";
			String reverse = "";
			int character;			
            // Take each character and add to the empty string
			while ((character = fileReader.read()) != -1) {
				stringToCast += Character.toString((char) character);
			}
			System.out.println("Original File : " + stringToCast);
			// Reverse and print
			for(int i = stringToCast.length() - 1; i >= 0; i--) {
				reverse = reverse + stringToCast.charAt(i);
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
		

}


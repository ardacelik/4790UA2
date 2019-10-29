import java.io.File;
import java.rmi.*;

public interface Journal extends Remote {
	//public final static String SERVICE = "JournalService";

	// Example:
	// public int computeFib(int i) throws RemoteException;
	
	// Create journal entry
	public void createAnEntry() throws RemoteException;
	
	// Reverse a journal entry
	public String reverseEntry(File file, User user, String path) throws RemoteException;
	
	// Update a journal entry
	// public void updateAnEntry() throws RemoteException;
	
	// Delete a journal entry
	// public void deleteAnEntry() throws RemoteException;
}

import java.rmi.*;

public interface Journal extends Remote {
	//public final static String SERVICE = "JournalService";

	// Example:
	// public int computeFib(int i) throws RemoteException;
	
	// Create journal entry
	public void createAnEntry() throws RemoteException;
	
	// See all journal entries
	// public void seeAllEntries() throws RemoteException;
	
	// Update a journal entry
	// public void updateAnEntry() throws RemoteException;
	
	// Delete a journal entry
	// public void deleteAnEntry() throws RemoteException;
}

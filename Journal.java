import java.io.File;
import java.rmi.*;

public interface Journal extends Remote {	
	
	// Reverse journal entry
	public String reverseEntry(File file, User user, String path) throws RemoteException;

	// Remove white space from journal
	public String removeWhiteSpace(File file, User user, String path) throws RemoteException;

	// Delete journal entry
	public String deleteFile(File file, User user, String path) throws RemoteException;

}

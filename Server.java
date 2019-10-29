/**
* Java RMI Server program
*
* @author  Arda Celik
* @version 1.0
* @since   2019-29-10
*/

import java.rmi.*;
import java.rmi.registry.Registry; 
import java.rmi.registry.LocateRegistry; 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 

public class Server extends JournalImpl {
	public static void main(String[] args) {
		try {
			JournalImpl ji = new JournalImpl();
			
			Journal stub = (Journal) UnicastRemoteObject.exportObject(ji, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			
			registry.bind("Journal", stub);
			
			System.err.println("Server is running");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

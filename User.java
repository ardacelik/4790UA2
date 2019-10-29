import java.io.File;
import java.io.Serializable;

public class User implements Serializable {
	
	String userId = null;
	File journal = null;
	
	public User() {
		
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserJournal(File journal) {
		this.journal = journal;
	}
	
	public File getUserJournal() {
		return journal;
	}

}

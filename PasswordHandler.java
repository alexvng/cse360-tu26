package application;

public class PasswordHandler {
	

	private static String myPassword = "Password"; 
	private static String myUsername = "Username"; 

	public static void setUsername(String username) { 
		myUsername = username; 
	}
	
	public static void setPassword(String password) { 
		myPassword = password; 
	}
	
	public static boolean compareData(String username, String password) { 
		if(username.equals(myUsername) && password.equals(myPassword)) { 
			return true; 
		}
		else { 
			return false; 
		}
	}
	
	
}

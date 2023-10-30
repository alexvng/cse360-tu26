package src;

import java.util.Scanner;

// Code author: Alex Vuong
public class InputSanitizationPrototype {

	// Try this SQL injection query:
	// ' UNION SELECT username, password FROM users--
	// source: https://portswigger.net/web-security/sql-injection/union-attacks
	
	public static void main(String[] args) {
		// set up user input
		Scanner scanner = new Scanner(System.in);
		
		// Username input field (prototype, will be replaced with UI)
		System.out.print("Enter your username: ");
		String rawinput = scanner.nextLine();
		
		// compare raw and sanitized input to see if an attack was detected
		if (rawinput != sanitizeSQLInjection(rawinput)) {
			System.out.println("Illegal characters detected in field: Username.");
			System.out.println("Sanitized input: " + sanitizeSQLInjection(rawinput));
		} else {
			System.out.println("No illegal characters detected.");
		}
		
		System.out.println("Prototype continues from here...");
	}

	private static String sanitizeSQLInjection(String input) {
		// Remove all leading and trailing whitespace (reduces user error)
		input = input.trim();
		
		// All characters within the [] will be matched, OR the "--" symbol used as SQL comment
		// Each of these characters have a use in SQL queries but will be disallowed in usernames
		String regexSQLMatcher = "[\"'<>`()=*, ;]|--";
		
		// Strip out all of the offending characters if any exist, and return the result
		input = input.replaceAll(regexSQLMatcher, "");
		return input;
	}
}

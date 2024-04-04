package com.coderscampus.com.Unit5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserService {

	private UserPOJO[] users;

	public UserService() {
		users = new UserPOJO[4];
	}

	public void readUserDataFromFile() {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader("data.txt"));

			String dataLine;
			int attempts = 0;
			while ((dataLine = fileReader.readLine()) != null && attempts < 5) {
				String[] userData = dataLine.split(",");

				String username = userData[0];
				String password = userData[1];
				String name = userData[2];
				users[attempts] = new UserPOJO(username, password, name);
				attempts++;

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public UserPOJO validateLogin(String username, String password) {
		for (UserPOJO user : users) {
			if (user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;

	}

	public void login() {
		readUserDataFromFile();

		int attempts = 0;
		boolean LoggedIn = false;
		UserPOJO authenticatedUser = null;

		try (Scanner scanner = new Scanner(System.in)) {
			while (attempts < 5) {
				System.out.println("Enter your username: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				authenticatedUser = validateLogin(username, password);

				if (authenticatedUser != null) {
					LoggedIn = true;
					break;
				} else {
					attempts++;
					System.out.println("Invalid Login, please try again");
				}

			}
			if (LoggedIn) {
				System.out.println("Welcome " + authenticatedUser.getName());
			} else {
				System.out.println("Too many failed login attempts, you are now locked out");
			}

		}

	}

}

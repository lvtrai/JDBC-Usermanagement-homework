package vn.msita.usermanagement.main;

import java.util.ArrayList;
import java.util.Scanner;

import vn.msita.usermanagement.bo.User;
import vn.msita.usermanagement.dao.UserDAO;
import vn.msita.usermanagement.utils.UserUtils;

public class Main {
	public static void main(String[] args) {
	
		UserDAO userDao = new UserDAO();
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = true;
		while (isContinue){
			System.out.println("=================================================");
			// Enter userName
			System.out.print("Enter userName: ");
			String userName = scanner.nextLine();
			
			// Find the user by the name you just entered
			ArrayList<User> userList = userDao.findUserByUsername(userName);
			
			// If not found: create new user and insert into database
			if(userList.size() == 0) {
				System.out.println("No record found");
				
				// Enter the userName
				System.out.print("Enter new username: ");
				String newUsername = scanner.nextLine();
				
				// Enter the password
				System.out.print("Enter new password: ");
				String newPassword = scanner.nextLine();
				
				// Enter age
				System.out.print("Enter new age: ");
				int newAge = scanner.nextInt();
				
				// Set data for newUser
				User newUser = new User();
				newUser.setUserName(newUsername);
				newUser.setPassword(newPassword);
				newUser.setAge(newAge);
				
				// Call userDAO to add a new user to the database
				userDao.addUserViaPreparedStatement(newUser);
				System.out.println("Insert successfully!");			
			}
			
			// If there is only one user: enter the new password from the keyboard and update the password for the user in the database.
			if(userList.size() == 1) {
				// Display user results found: id - userName - password - age
				UserUtils.displayUserList(userList);
				// Enter a new password
				System.out.print("Enter new password: ");
				String password= scanner.nextLine();
				// Call userDAO to update the new password for the user
				userDao.updateUserPassword(password, userName);
				
				System.out.println("Update successfully!");
			}
			
			// If there is more than one user: delete all in the database only keep the first user.
			if (userList.size() > 1){
				// Display the results of all users found: id - userName - password - age
				UserUtils.displayUserList(userList);
				// Call userDAO to delete the second user to the N of the listUser in the database.
				userDao.deleteUser(userName);
				System.out.println("Delete successfully!");
			}
			
			// Do you continue to work?
			scanner = new Scanner(System.in);
			System.out.print("Continue (Y/N): ");
			String result = scanner.nextLine();
			isContinue = "Y".equalsIgnoreCase(result);
		}
		scanner.close();
		
	}

}

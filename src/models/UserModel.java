package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class UserModel extends Observable{
	private UserBean user;
	private UserDAO dao;
	private ArrayList<UserBean> data;
	
	public UserModel() {
		this.dao = UserDAO.getIntance();
	}
	
	//Checks if a username already exists in the database (userlist).
	public boolean usernameExists(String username) {
		boolean usernameExists = false;
		
		for (UserBean user : MainDTO.userList) {
			if (user.getUsername().equals(username)) {
				usernameExists = true;
				break;
			}
		}
			
		return usernameExists;
	}
	

	//Boolean. Checks if user credentials match with the database's.
	public boolean login(String username, String password) {
		boolean matchFound = false;
	
		for (UserBean user : MainDTO.userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				matchFound = true;
				break;
			}
		}
		
		return matchFound;
	}

	
	//Creates new user in userList. Requires unclaimed username;
	public void addUser(String entityId, String username, String password, String type) {
		if (!usernameExists(username)) {
			//if the username already exists, and the user belongs to restaurant entity, make sure only one manager or restaurateur exists at once in the database
			//else simply add the user
			if (type.equals("manager") || type.equals("restaurateur")) {
				boolean userTypeExists = false;
				//Check each user that is part of the same restaurant to see if this user type already exists
				for (UserBean existingUser : MainDTO.userList) {
					System.out.println(existingUser.getEntityId());
					System.out.println(existingUser.getUserType());
					if(!existingUser.getUserType().equals("admin")){	
						if (existingUser.getEntityId().equals(entityId) && existingUser.getUserType().equals(type)) {
							userTypeExists = true;
							break;
						}
					}
				}
				
				if (userTypeExists) {
					System.out.println("User not added. User of type " + type + " already exists for restaurant with id #" + entityId);
				} else {
					user = new UserBean(entityId, username, password, type);
					dao.addUser(user);
				}
			} else {
				user = new UserBean(entityId, username, password, type);
				dao.addUser(user);
			}

		}
	}
	
	//update a user
	public void editUser(String id, String entityId, String username, String password, String type) {
		user = new UserBean(id, entityId, username, password, type);
		dao.editUser(user);
	}
	
	public void deleteUser(String id) {
		user = dao.getUserById(id);
		dao.deleteUser(user);
	}

	//returns user as a User object. If user not found, returns null.
	public UserBean getUserById(String id) {
		return dao.getUserById(id);
	}
	
	//returns user as a User object. If user not found, returns null.
	public UserBean getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}
	
	
	public String getCurrentUser() {
		return dao.getCurrentUser();
	}
	
	public void setCurrentUser(String id) {
		dao.setCurrentUser(id);
	}
	
	public ArrayList<UserBean> getAllUsers() {
		data = dao.getAllUsers();
				
		setChanged();
		notifyObservers();
		
		return data;
	}
	
}

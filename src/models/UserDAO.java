package models;

import java.util.ArrayList;

public class UserDAO {
	private static UserDAO instance = null;
	
	private UserDAO() {
	}
	
	public static UserDAO getIntance() {
		if(instance == null) 
			instance = new UserDAO();
		
		return instance;
	}
	
	public void addUser(UserBean user) {
		int id = MainDTO.id;
		MainDTO.id ++;
		user.setId(Integer.toString(id));
		MainDTO.userList.add(user);
		System.out.println("New User added: " + user);
	}
	
	public void editUser(UserBean user) {
		int index;
		String userId = user.getId();
		for (UserBean existingUser : MainDTO.userList) {
			if (existingUser.getId().equals(userId)) {
				index = MainDTO.userList.indexOf(existingUser);
				MainDTO.userList.set(index, user);
				System.out.println("User edited: " + user);
				break;
			}
		}
	}
	
	public void deleteUser(UserBean user) {
		MainDTO.userList.remove(user);
		System.out.println("User deleted: " + user);
	}
	
	public UserBean getUserById(String id) {
		for (UserBean user : MainDTO.userList) {
			if (user.getId().equals(id))
				return user;
		}
		
		return null;	
	}
	
	public UserBean getUserByUsername(String username) {
		for (UserBean user : MainDTO.userList) {
			if (user.getUsername().equals(username))
				return user;
		}
		
		return null;	
	}
	
	public String getCurrentUser() {
		return MainDTO.currentUser;
	}
	
	public void setCurrentUser(String username) {
		MainDTO.currentUser = username;
	}
	
	
	public ArrayList<UserBean> getAllUsers(){
		return MainDTO.userList;
	}
	
}

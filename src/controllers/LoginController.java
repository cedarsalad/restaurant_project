package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import models.ClientModel;
import models.DeliveryManModel;
import models.MainDTO;
import models.OrderModel;
import models.RestaurantModel;
import models.UserBean;
import models.UserModel;
import views.AddClientView;
import views.LoginView;

public class LoginController {
	private UserModel userModel;
	private ClientModel clientModel;
	private RestaurantModel restaurantModel;
	private JMenuBar menuBar;
	private LoginView loginView;
	private AddClientView addClientView;
	private DeliveryManModel deliveryManModel;
	private OrderModel orderModel;
	
	public LoginController(UserModel userModel) {
		this.userModel = userModel;
		loginView = new LoginView();
		clientModel = new ClientModel();
		restaurantModel = new RestaurantModel();
		deliveryManModel = new DeliveryManModel();
		orderModel = new OrderModel();
		
		System.out.println("MainDTO IdCount = " + MainDTO.id);
		///// add default user-entities at app-start
		if (MainDTO.id==1) {
		//add default user: Admin
		userModel.addUser(null, "admin", "admin", "admin");
		
		//add client
		clientModel.addNewClient("Nathanial", "Sarrouf", "1800 Upyourmutluck", "sexybeast69@hotmail.com", "(514)-641-2800");
		//create user for client
		userModel.addUser(Integer.toString(MainDTO.id-1), "nates", "123123", "client");
		
		//add restaurant
		restaurantModel.addNewRestaurant("Amir", "1222 St-Catherine Ouest", "(514)-223-4900", "9am-11pm", "H3H, H9K, H2B");
		String[][] menu = {{"Pizza", "2.50"},{"Burger", "2"},{"Fries", "1"}};
		restaurantModel.getSingleRestaurant(Integer.toString(MainDTO.id-1)).setMenu(menu);

		restaurantModel.addNewRestaurant("Chao Ling's", "52 St-Catherine Ouest", "(514)723-4780", "11am-8m", "H3H, H9K");
		String[][] menu2 = {{"Sushi", "7.50"},{"Noodles", "3"},{"Dumplings", "4"}};
		restaurantModel.getSingleRestaurant(Integer.toString(MainDTO.id-1)).setMenu(menu2);

		//add manager user
		userModel.addUser(Integer.toString(MainDTO.id-1), "manager", "manager", "manager");

		//add restaurateur user
		userModel.addUser(Integer.toString(MainDTO.id-2), "resto", "asdasd", "restaurateur");
		
		//add default delivery guy
		deliveryManModel.addNewDeliveryMan("simon", "(514)-222-2112", "H3H, H9K");
		
		//add delivery guy user
		userModel.addUser(Integer.toString(MainDTO.id-1), "dvman", "asdasd", "deliveryMan");
		
		//items ordered
		String orderItems[][] = {{"Chicken","9.99", "5"},{"Sushi", "10.99", "9"}};
		//create default order
		orderModel.addNewOrder("1224 Upyourmutluck", "2018/11/22", "13h30", "H3H2E9", "2", "4", orderItems);
		orderModel.getSingleOrder(Integer.toString(MainDTO.id-1)).setStatus("3");
		}
		///// Add Login Buttons Event Handlers
		
		// Connect Btn
		loginView.getBtnConnect().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = loginView.getTfUsername().getText();
				String password = loginView.getTfPassword().getText();
				
				if (userModel.login(username, password)) {
			        UserBean user = userModel.getUserByUsername(username);
					JOptionPane.showMessageDialog(null, "Logged in as " +  username, "Login Successful", JOptionPane.INFORMATION_MESSAGE);
			        userModel.setCurrentUser(username);
			        String type = user.getUserType();
			        showMenuView(user.getUserType());
			        
				} else {
					loginView.getTfPassword().setText("");
			        JOptionPane.showMessageDialog(null, "Username and password do not match. Please try again.", "Login Error", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		
		// New Client Btn
		loginView.getBtnNewClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addClientView = new AddClientView();
				loginView.getFrame().dispose();
				///// add button event handlers
				//Quit Btn
				addClientView.getBtnQuit().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					} 
					
				});
				//Return Btn
				addClientView.getBtnReturn().addActionListener(new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//create login view
						LoginController loginController = new LoginController(userModel);
						//dispose current window
						addClientView.getFrame().dispose();
					} 
					
				});
				//Save Btn
				addClientView.getBtnSave().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String tfUsername = addClientView.getTfUsername().getText();
						String tfPassword = addClientView.getTfPassword().getText();
						String tfConfirm = addClientView.getTfConfirm().getText();
						String tfFirstName = addClientView.getTfFirstName().getText();
						String tfLastName = addClientView.getTfLastName().getText();
						String tfAddress = addClientView.getTfAddress().getText();
						String tfEmail = addClientView.getTfEmail().getText();
						String ftfPhone = addClientView.getFtfPhone().getText();
						
						// make sure the fields are filled
						if (isEmpty(tfUsername) || isEmpty(tfPassword) || isEmpty(tfFirstName) || isEmpty(tfLastName) || isEmpty(tfAddress) || isEmpty(tfEmail) || isEmpty(ftfPhone)) {
							JOptionPane.showMessageDialog(null, "Error: Please fill out all fields.", "Edit Error", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						// validate username
						if (tfUsername.length() < 5) {
							JOptionPane.showMessageDialog(null, "Error: Username must be at least 5 characters long.", "Edit Error", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (userModel.usernameExists(tfUsername)) {
							JOptionPane.showMessageDialog(null, "Error: Username already exists.", "Edit Error", JOptionPane.WARNING_MESSAGE);
							addClientView.getTfUsername().setText("");
							return;
						}
						if (!isNumeric(ftfPhone.substring(13))) {
							JOptionPane.showMessageDialog(null, "Error: Please fill out a correct phone number.", "Edit Error", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						// make sure all the password fields are filled
						if (!isEmpty(tfPassword)) {
							if (isEmpty(tfConfirm)) {
								JOptionPane.showMessageDialog(null, "Error: Please Confirm Password.", "Edit Error", JOptionPane.WARNING_MESSAGE);
								return;
							} else if(!tfPassword.equals(tfConfirm)) {
								JOptionPane.showMessageDialog(null, "Error: Passwords do not match.", "Edit Error", JOptionPane.WARNING_MESSAGE);
								return;
							} else if(tfPassword.length() < 6) {
								JOptionPane.showMessageDialog(null, "Error: Password must be at least 6 characters long.", "Edit Error", JOptionPane.WARNING_MESSAGE);
								return;
							}
							//if filled correctly, change all
							int response = JOptionPane.showConfirmDialog(null, 
									"Username: " + tfUsername 
									+ "\nFirst Name: " + tfFirstName
									+ "\nLast Name: " + tfLastName
									+ "\nAddress: " + tfAddress
									+ "\nEmail: " + tfEmail
									+ "\nPhone Number: " + ftfPhone
									+ "\n\nCreate User " + tfUsername + "?", 
									"Confirm Creation" , JOptionPane.CANCEL_OPTION);
							
							if (response == JOptionPane.YES_OPTION) {
								clientModel.addNewClient(tfFirstName, tfLastName, tfAddress, tfEmail, ftfPhone);
								userModel.addUser(Integer.toString(MainDTO.id-1), tfUsername, tfPassword, "client");
								JOptionPane.showMessageDialog(null, "Success: User Created. Please Login", "User Creation Successful", JOptionPane.INFORMATION_MESSAGE);
								//create login view
								LoginController loginController = new LoginController(userModel);
								//dispose current window
								addClientView.getFrame().dispose();
							}
						}
								
					}
					
				});
				
			}
			
		});
	}
	
	private void showMenuView(String userType) {
		switch (userType) {
			case "client":
				ClientModel clientModel = new ClientModel();
				ClientController clientController = new ClientController(clientModel);
				loginView.getFrame().dispose();
				break;
			case "admin":
				RestaurantModel restoModel = new RestaurantModel();
				DeliveryManModel dManModel = new DeliveryManModel();
				AdminController adminController = new AdminController(restoModel, dManModel);
	             loginView.getFrame().dispose();
				break;
			case "manager":
				break;
			case "restaurateur":
				RestaurantModel restaurantModel = new RestaurantModel();
				RestaurantController controller = new RestaurantController(restaurantModel);
				loginView.getFrame().dispose();
				break;
			case "deliveryMan":
				DeliveryManModel deliveryManModel = new DeliveryManModel();
				DeliveryManController deliveryManController = new DeliveryManController(deliveryManModel);
				loginView.getFrame().dispose();
				break;
			default:
				break;
		}
	}
	
	private boolean isEmpty(String s) {
		return (s.equals(null) || s.equals(""));
	}
	
	public boolean isNumeric(String s) {
	    return s.matches("\\d+");
	}
}

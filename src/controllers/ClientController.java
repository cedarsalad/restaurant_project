package controllers;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import custom_controls.MenuBar;
import models.ClientBean;
import models.ClientModel;
import models.OrderBean;
import models.OrderModel;
import models.RestaurantBean;
import models.RestaurantModel;
import models.UserBean;
import models.UserModel;
import views.AddClientView;
import views.DeleteClientView;
import views.EditClientView;
import views.MenuView;
import views.OrderFoodView;
import views.OrderHistoryView;

public class ClientController {
	// models used in this controller
	private UserModel userModel;
	private ClientModel clientModel;
	private OrderModel orderModel;
	private RestaurantModel restaurantModel;
	// client views used by this controller
	private MenuView menuView;
	private AddClientView addClientView;
	private EditClientView editClientView;
	private DeleteClientView deleteClientView;
	private OrderFoodView orderFoodView;
	private OrderHistoryView orderHistoryView;
	
	// menubar for group
	private MenuBar menuBar;
	
	public ClientController(ClientModel clientModel) {
		// Instantiating models
		this.clientModel = clientModel;
		orderModel = new OrderModel();
		userModel = new UserModel();
		restaurantModel = new RestaurantModel();
		//// create the menu bar
		menuBar = new MenuBar();
		// Turn on (make visible) relevant menus
		menuBar.getAccount().setVisible(true);
		menuBar.getOrderClient().setVisible(true);

		///// Show landing page and set the menu bar to its default
		showMenuView();
		
		///// Add Action Listener to menus  
		
		// Disconnect 
		menuBar.getFile().getItem(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//reset logged in user
				userModel.setCurrentUser(null);
				//create login view
				LoginController loginController = new LoginController(userModel);
				//dispose current window
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
				activeWindow.dispose();
			}
			
		});
		
		// Edit Account
		 menuBar.getAccount().getItem(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(userModel.getAllUsers().toString());
				// create new frame
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
				activeWindow.dispose();
		        editClientView = new EditClientView();
				// disable current menu item
		        enableAllMenus();
				menuBar.getAccount().getItem(0).setEnabled(false);
				editClientView.getFrame().setJMenuBar(menuBar);
				editClientView.getFrame().repaint();
				editClientView.getFrame().revalidate();
				
				// Fill textfields
				String clientUsername = userModel.getCurrentUser();
				UserBean user = userModel.getUserByUsername(clientUsername);
				String clientId = user.getEntityId();
				ClientBean client = clientModel.getSingleClient(clientId);
				editClientView.getTfUsername().setText(user.getUsername());
				editClientView.getTfFirstName().setText(client.getFirstName());
				editClientView.getTfLastName().setText(client.getLastName());
				editClientView.getTfAddress().setText(client.getAddress());
				editClientView.getTfEmail().setText(client.getEmail());
				editClientView.getFtfPhone().setText(client.getPhone());
				
				///// Action Listeners
				
				// Quit Button
				editClientView.getBtnQuit().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					} 
					
				});
				
				//Return Button
				editClientView.getBtnReturn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						showMenuView();
						menuBar.getAccount().getItem(0).setEnabled(true);
						editClientView.getFrame().dispose();
					} 
					
				});
				
				//Save Button
				editClientView.getBtnSave().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String tfUsername = editClientView.getTfUsername().getText();
						String tfOldPassword = editClientView.getTfOldPassword().getText();
						String tfPassword = editClientView.getTfPassword().getText();
						String tfConfirm = editClientView.getTfConfirm().getText();
						String tfFirstName = editClientView.getTfFirstName().getText();
						String tfLastName = editClientView.getTfLastName().getText();
						String tfAddress = editClientView.getTfAddress().getText();
						String tfEmail = editClientView.getTfEmail().getText();
						String ftfPhone = editClientView.getFtfPhone().getText();
						
						// make sure the essential fields are filled
						if (isEmpty(tfUsername) || isEmpty(tfFirstName) || isEmpty(tfLastName) || isEmpty(tfAddress) || isEmpty(tfEmail) || isEmpty(ftfPhone)) {
							JOptionPane.showMessageDialog(null, "Error: Please fill out all fields.", "Edit Error", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						//make sure if he changes the name, the name is still unique
						if (!clientUsername.equals(tfUsername)) {
							if (tfUsername.length() < 5) {
								JOptionPane.showMessageDialog(null, "Error: Username must be at least 5 characters long.", "Edit Error", JOptionPane.WARNING_MESSAGE);
								return;
							}
							if (!userModel.usernameExists(tfUsername)) {
								
							} else {
								JOptionPane.showMessageDialog(null, "Error: Username already exists.", "Edit Error", JOptionPane.WARNING_MESSAGE);
								editClientView.getTfUsername().setText(clientUsername);
								return;
							}
						}
						if (!isNumeric(ftfPhone.substring(13))) {
							JOptionPane.showMessageDialog(null, "Error: Please fill out a correct phone number.", "Edit Error", JOptionPane.WARNING_MESSAGE);
							return;
						}
						
						// if the password needs to be changed, change it with the rest
						// else just change everythign else
						
						// if password has text, make sure all the password fields are filled
						if (!isEmpty(tfPassword)) {
							if (isEmpty(tfConfirm)) {
								JOptionPane.showMessageDialog(null, "Error: Please Confirm Password.", "Edit Error", JOptionPane.WARNING_MESSAGE);
								return;
							} else if(isEmpty(tfOldPassword)) {
								JOptionPane.showMessageDialog(null, "Error: Please enter old password.", "Edit Error", JOptionPane.WARNING_MESSAGE);
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
									+ "\n\nConfirm edit for #" + client.getId() + " - " + clientUsername + "?", 
									"Confirm Edit" , JOptionPane.CANCEL_OPTION);
							
							if (response == JOptionPane.YES_OPTION) {
								clientModel.editClient(client.getId(), tfFirstName, tfLastName, tfAddress, tfEmail, ftfPhone);
								userModel.editUser(user.getId(), client.getId(), tfUsername, tfPassword, "client");
								userModel.setCurrentUser(tfUsername);
								showMenuView();
								menuBar.getAccount().getItem(0).setEnabled(true);
								editClientView.getFrame().dispose();
								JOptionPane.showMessageDialog(null, "Success: Client edited successfully.", "Edit Success", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						} else {
							//if the password isn't changed, since the rest of the fields are filled properly
							int response = JOptionPane.showConfirmDialog(null, 
									"Username: " + tfUsername 
									+ "\nFirst Name: " + tfFirstName
									+ "\nLast Name: " + tfLastName
									+ "\nAddress: " + tfAddress
									+ "\nEmail: " + tfEmail
									+ "\nPhone Number: " + ftfPhone
									+ "\n\nConfirm edit for #" + client.getId() + " - " + clientUsername + "?",
									"Confirm Edit" , JOptionPane.CANCEL_OPTION);
							
							if (response == JOptionPane.YES_OPTION) {
								clientModel.editClient(client.getId(), tfFirstName, tfLastName, tfAddress, tfEmail, ftfPhone);
								userModel.editUser(user.getId(), client.getId(), tfUsername, user.getPassword(), "client");
								userModel.setCurrentUser(tfUsername);
								showMenuView();
								menuBar.getAccount().getItem(0).setEnabled(true);
								editClientView.getFrame().dispose();
								JOptionPane.showMessageDialog(null, "Success: Client edited successfully.", "Edit Success", JOptionPane.INFORMATION_MESSAGE);
								return;
							}
						}
								
					}
					
				});
			}
			
		});
		 
		// Delete Account
		menuBar.getAccount().getItem(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteClientView = new DeleteClientView();
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
				activeWindow.dispose();
				// disable current menu item
		        enableAllMenus();
				menuBar.getAccount().getItem(1).setEnabled(false);
				deleteClientView.getFrame().setJMenuBar(menuBar);
				deleteClientView.getFrame().repaint();
				deleteClientView.getFrame().revalidate();
				
				
				String clientUsername = userModel.getCurrentUser();
				UserBean user = userModel.getUserByUsername(clientUsername);
				
				deleteClientView.getTfUsername().setText(clientUsername);
				deleteClientView.getTfUsername().setEnabled(false);
				
				//delete button event handler
				deleteClientView.getBtnDelete().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (deleteClientView.getTfPassword().getText().equals(user.getPassword())) {
							clientModel.deleteClient(user.getEntityId());
							userModel.deleteUser(user.getId());
							//reset logged in user
							userModel.setCurrentUser(null);
							//create login view
							LoginController loginController = new LoginController(userModel);
							//dispose current window
							Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
							activeWindow.dispose();
							JOptionPane.showMessageDialog(null, "Success: Account deleted successfully.", "Delete Success", JOptionPane.INFORMATION_MESSAGE);

						} else 
							JOptionPane.showMessageDialog(null, "Error: Password is incorrect.", "Delete Error", JOptionPane.WARNING_MESSAGE);

							
					}
					
				});
			}
			
		});
		
		// Order Food
		menuBar.getOrderClient().getItem(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				orderFoodView = new OrderFoodView();
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
				activeWindow.dispose();
				// disable current menu item
		        enableAllMenus();
				menuBar.getOrderClient().getItem(0).setEnabled(false);
				orderFoodView.setJMenuBar(menuBar);
				orderFoodView.repaint();
				orderFoodView.revalidate();
				
				
				//Useful Lists
				ArrayList<RestaurantBean> refinedRestaurantList = new ArrayList<>();
				ArrayList<String[]> menuItems= new ArrayList<>();
				ArrayList<String[]> orderItems= new ArrayList<>();
//			    ArrayList<RestaurantBean> restaurantList = restaurantModel.getAllRestaurants();
//                String[] stringRestaurantList = new String[restaurantList.size()];
//                
//                for (int i = 0; i < restaurantList.size(); i++) {
//                    String restaurant = restaurantList.get(i).getName();
//                    stringRestaurantList[i] = restaurant;
//                    
//                    ((DefaultListModel)orderFoodView.getRestaurant_JList().getModel()).addElement(restaurant);
//                }
//                
                // hour validation
                orderFoodView.getHour_Ftf().addKeyListener(new KeyListener() {
                	
					@Override
					public void keyPressed(KeyEvent arg0) {
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						String hour = orderFoodView.getHour_Ftf().getText();
	                	int intHour = 0;
	                	if (isNumeric(hour)) {
	                		intHour = Integer.parseInt(hour);
	                	}
	                	if (intHour < 0 || intHour > 24) {
	                		orderFoodView.getHour_Ftf().setText("");
	                	}	
	                	if (hour.equals("24")) {
	                		orderFoodView.getMinute_Ftf().setText("00");
	                	}
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
                	
                });
                
                // minute validation
                orderFoodView.getMinute_Ftf().addKeyListener(new KeyListener() {
                	
					@Override
					public void keyPressed(KeyEvent arg0) {
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
						String min = orderFoodView.getMinute_Ftf().getText();
						String hour = orderFoodView.getHour_Ftf().getText();
	                	int intMin = 0;
	                	if (isNumeric(min)) {
	                		intMin = Integer.parseInt(min);
	                	}
	                	
	                	if (hour.equals("24")) {
	                		orderFoodView.getMinute_Ftf().setText("00");
	                	} else if (intMin < 1 || intMin > 60) {
	                		orderFoodView.getMinute_Ftf().setText("");
	                	}
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
                	
                });
                
                // postal code change
                orderFoodView.getPostalCode_Ftf().addKeyListener(new KeyListener() {
                	
					@Override
					public void keyPressed(KeyEvent arg0) {
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
	                    ((DefaultListModel)orderFoodView.getRestaurant_JList().getModel()).clear();;
	                    ((DefaultListModel)orderFoodView.getMenu_JList().getModel()).clear();;

						
						String postalCode = orderFoodView.getPostalCode_Ftf().getText().toUpperCase().replaceAll("\\s+","");
						String areaCode = orderFoodView.getPostalCode_Ftf().getText().substring(0,3).toUpperCase().replaceAll("\\s+","");
						RestaurantBean[] refinedRestaurants;
						refinedRestaurantList.clear();
						if (postalCode.length()==7) {
							for (RestaurantBean restaurant : restaurantModel.getAllRestaurants()) {
								String areas = restaurant.getDeliveryAreas().toUpperCase();

								if(areas.contains(areaCode) && areaCode.length()==3){
									refinedRestaurantList.add(restaurant);
								}
							}
							refinedRestaurants = new RestaurantBean[refinedRestaurantList.size()];
							for (int i = 0; i < refinedRestaurantList.size(); i++) {
								refinedRestaurants[i] = refinedRestaurantList.get(i);
			                    ((DefaultListModel)orderFoodView.getRestaurant_JList().getModel()).addElement(refinedRestaurants[i].getName());
							}
						}
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
                	
                });
                
                // click Restaurant List event handler 
                orderFoodView.getRestaurant_JList().addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseReleased(MouseEvent arg0) {
	                    ((DefaultListModel)orderFoodView.getMenu_JList().getModel()).clear();;
        				int i = orderFoodView.getRestaurant_JList().getSelectedIndex();
        				String[][] menu = refinedRestaurantList.get(i).getMenu();
        				menuItems.clear();
        				for (int j = 0; j < menu.length; j++) {
    	                    ((DefaultListModel)orderFoodView.getMenu_JList().getModel()).addElement(menu[j][0]);
    	                    menuItems.add(menu[j]);
						}

        			}
        		});
                
                // Restaurant List selection change
                orderFoodView.getRestaurant_JList().addListSelectionListener(new ListSelectionListener () {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						orderItems.clear();
	                    ((DefaultListModel)orderFoodView.getOrder_JList().getModel()).clear();
	                    orderFoodView.getTotal_Ftf().setText("");
					}
                	
                });
                
                // click Menu List event handler 
                orderFoodView.getMenu_JList().addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseReleased(MouseEvent arg0) {
        				int i = orderFoodView.getMenu_JList().getSelectedIndex();
        				orderFoodView.getMeal_Ftf().setText(menuItems.get(i)[0]);
        				orderFoodView.getPrice_Ftf().setText(menuItems.get(i)[1]);
        			}
        		});
                
                // quantity change
                orderFoodView.getQuantity_Ftf().addKeyListener(new KeyListener() {
                	
					@Override
					public void keyPressed(KeyEvent arg0) {
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub

						
						String qString = orderFoodView.getQuantity_Ftf().getText();
						if (isNumeric(qString)) {
							float quantity = Float.parseFloat(qString);
							if (quantity<1 || quantity>10) {
								orderFoodView.getQuantity_Ftf().setText("");							
							}
						} else {
							orderFoodView.getQuantity_Ftf().setText("");							
						}
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
                	
                });
                
                // add item
                orderFoodView.getAdd_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String name = orderFoodView.getMeal_Ftf().getText();
						String price =  orderFoodView.getPrice_Ftf().getText();
						String quantity =  orderFoodView.getQuantity_Ftf().getText();
						float priceFloat = Float.parseFloat(price);
						float total = 0;
						if ((orderFoodView.getTotal_Ftf().getText()).length()>1){
							total = Float.parseFloat(orderFoodView.getTotal_Ftf().getText());
						}
						if (orderFoodView.getQuantity_Ftf().getText().length() > 0 && orderFoodView.getMeal_Ftf().getText().length() > 0) {
							
							String[] orderItem = {name, price, quantity};
							String orderString = name + ", Qty: " + quantity + ", Price: " + price + "$";
							orderItems.add(orderItem);
							
							total += priceFloat * Integer.parseInt(quantity);
							orderFoodView.getTotal_Ftf().setText(total+"");							
							
							
    	                    ((DefaultListModel)orderFoodView.getOrder_JList().getModel()).addElement(orderString);
						}
					}
                	
                });

                // delete item
                orderFoodView.getDelete_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
        				int i = orderFoodView.getOrder_JList().getSelectedIndex();
        				if (!orderItems.isEmpty() && i >= 0) {
	        				float total = Float.parseFloat(orderFoodView.getTotal_Ftf().getText());
							float priceFloat = Float.parseFloat(orderItems.get(i)[1]);

							total -= priceFloat * Integer.parseInt(orderItems.get(i)[2]);

	        				orderItems.remove(i);
		                    ((DefaultListModel)orderFoodView.getOrder_JList().getModel()).remove(i);
		                    
							orderFoodView.getTotal_Ftf().setText(total+"");							
		                    
        				}
					}
                	
                });
                
                // create order
                orderFoodView.getOrder_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String deliveryDate = orderFoodView.getDeliveryDate_Ftf().getText();
						String deliveryTime = orderFoodView.getHour_Ftf().getText() + "h" + orderFoodView.getMinute_Ftf().getText();
						String postalCode = orderFoodView.getPostalCode_Ftf().getText().substring(0,3).toUpperCase().replaceAll("\\s+","");
						String[][] order = new String[orderItems.size()][3];
						
						for (int i = 0; i < order.length; i++) {
							order[i] = orderItems.get(i);
						}
						
						if (orderItems.size()>0) {
							String restaurantId = refinedRestaurantList.get(orderFoodView.getRestaurant_JList().getSelectedIndex()).getId();
							if(!deliveryDate.substring(deliveryDate.length()-1).isEmpty() && deliveryTime.length()>0 && postalCode.length() == 3) {
								String orderDetails = "";
								for (String[] orderItem : orderItems) {
									orderDetails += orderItem[0] + ", Qty: " + orderItem[2] + ", Price: " + orderItem[1] + "$\n";
								}
								orderDetails += "\nConfirm Order?";
								
								int response = JOptionPane.showConfirmDialog(null, orderDetails, "Confirm Order" , JOptionPane.CANCEL_OPTION);
								
								if (response == JOptionPane.YES_OPTION) {
									String address = "";
									while (address.equals("")) {
										address = JOptionPane.showInputDialog("Please enter a full address:");
									}
									String deliveryDetails = "Delivery Information\n" + "Date: " + deliveryDate + "\nPostal Code: " + postalCode + "\nAddress: " + address;
									deliveryDetails += "\n Finalize Order?";
									response = JOptionPane.showConfirmDialog(null, deliveryDetails, "Finish Order" , JOptionPane.CANCEL_OPTION);
									if (response == JOptionPane.YES_OPTION) {
										String clientId = userModel.getUserByUsername(userModel.getCurrentUser()).getEntityId();
										
										orderModel.addNewOrder(clientModel.getSingleClient(clientId).getAddress(), deliveryDate, deliveryTime, postalCode, clientId, restaurantId, order);
										showMenuView();
										menuBar.getOrderClient().getItem(0).setEnabled(true);
										orderFoodView.dispose();
										JOptionPane.showMessageDialog(null, "Success: Order Created. Total: " + orderFoodView.getTotal_Ftf().getText() + "$", "Order Successful", JOptionPane.INFORMATION_MESSAGE);
										return;
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "Error: Please fill out all fields.", "Order Error", JOptionPane.WARNING_MESSAGE);
							}
							
						}
					}
                	
                });
			}
			
			
		});
		
		//View Orders
		menuBar.getOrderClient().getItem(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				orderHistoryView = new OrderHistoryView();
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
				activeWindow.dispose();
				// disable current menu item
		        enableAllMenus();
				menuBar.getOrderClient().getItem(1).setEnabled(false);
				orderHistoryView.setJMenuBar(menuBar);
				orderHistoryView.repaint();
				orderHistoryView.revalidate();
				
				// fill list
				ArrayList<OrderBean> orders = orderModel.getAllOrders();
				// get current user id
				String clientId = userModel.getUserByUsername(userModel.getCurrentUser()).getEntityId();
				ArrayList<OrderBean> refinedOrders = new ArrayList<OrderBean>(); 
				
				for (OrderBean order : orders) {
					if (order.getClient().equals(clientId)) {
						refinedOrders.add(order);
					}
				}

				for (OrderBean order : refinedOrders) {
					String restoName = restaurantModel.getSingleRestaurant(order.getRestaurant()).getName();
					System.out.println(restoName);
					String orderInfo = (refinedOrders.indexOf(order)+1) + "- " + order.getDeliveryDate() + " " + order.getDeliveryTime();
                    ((DefaultListModel)orderHistoryView.getRestaurant_JList().getModel()).addElement(orderInfo);
				}
				
		        // restaurant list select 
				orderHistoryView.getRestaurant_JList().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent arg0) {
						int i = orderHistoryView.getRestaurant_JList().getSelectedIndex();
						OrderBean selectedOrder = refinedOrders.get(i);
						orderHistoryView.getDeliveryDate_Ftf().setText(selectedOrder.getDeliveryDate());
						orderHistoryView.getDeliveryTime_Ftf().setText(selectedOrder.getDeliveryTime());
						orderHistoryView.getPostalCode_Ftf().setText(selectedOrder.getPostalCode());
						String[][] order = selectedOrder.getOrder();
							
						for (String[] orderItem : order) {
							String itemDetails = orderItem[0] + ", Qty: " + orderItem[2] + ", Price: " + orderItem[1] + "$";
		                    ((DefaultListModel)orderHistoryView.getMeal_JList().getModel()).addElement(itemDetails);
						}

					}
				});
				
                // Order selection change
				orderHistoryView.getRestaurant_JList().addListSelectionListener(new ListSelectionListener () {

					@Override
					public void valueChanged(ListSelectionEvent arg0) {
	                    ((DefaultListModel)orderHistoryView.getMeal_JList().getModel()).clear();
					}
                	
                });
				
			}
			
		});
		

	}
	
	private void showMenuView() {
		// Show landing page
		menuView = new MenuView();

		// Add Menu Bar to menu view
		menuView.setJMenuBar(menuBar);
		menuView.repaint();
		menuView.revalidate();
		
	}
	
	private boolean isEmpty(String s) {
		return (s.equals(null) || s.equals(""));
	}
	
	public boolean isNumeric(String s) {
	    return s.matches("\\d+");
	}
	
	private void enableAllMenus() {
		menuBar.getAccount().getItem(0).setEnabled(true);
		menuBar.getAccount().getItem(1).setEnabled(true);
		menuBar.getOrderClient().getItem(0).setEnabled(true);
		menuBar.getOrderClient().getItem(1).setEnabled(true);
	}

}

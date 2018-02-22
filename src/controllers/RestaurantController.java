package controllers;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import custom_controls.MenuBar;
import models.OrderBean;
import models.OrderModel;
import models.RestaurantModel;
import models.UserModel;
import views.AcceptOrderView;
import views.MenuView;
import views.ReadyOrderView;

public class RestaurantController {
	
		//Create Controllers
		private LoginController loginController;
		
		//Create Models
		private UserModel userModel;
		private OrderModel orderModel;
		private RestaurantModel restaurantModel;
		
		//Create Views
		private MenuView menuView;
		private AcceptOrderView acceptOrderView;
		private ReadyOrderView readyOrderView;
		private MenuBar menuBar;
		
		public RestaurantController(RestaurantModel restaurantModel) {
			this.restaurantModel = restaurantModel;
			userModel = new UserModel();
			orderModel = new OrderModel();
			
			//Creating MainView 	
			menuView = new MenuView();
			
		//Show menu bar buttons (menus)
			menuBar = new MenuBar();
		
		//Retrieve relevant menus
			menuBar.getOrderRestaurateur().setVisible(true);
			
		//Add MenuBar to the view
			menuView.setJMenuBar(menuBar);
			menuView.repaint();
			menuView.revalidate();
			
			//----------------------------------------ACCEPT ORDER
			//Accept Order
			menuBar.getOrderRestaurateur().getItem(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					acceptOrderView = new AcceptOrderView();
					
					
					//Close active window
					Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow(); 
					activeWindow.dispose();
					//Overwrite MenuBar
					MenuBar ordersItem = menuBar;
					
					//Retrieve relevant menus
					ordersItem.getOrderRestaurateur().setVisible(true);
					ordersItem.getOrderRestaurateur().getItem(0).setEnabled(false);
					ordersItem.getOrderRestaurateur().getItem(1).setEnabled(true);
					
					//Add MenuBar to the view
					acceptOrderView.setJMenuBar(ordersItem);
					acceptOrderView.repaint();
					acceptOrderView.revalidate();
					
					//Populate Pending Orders JList
					ArrayList<OrderBean> orderList = orderModel.getAllOrders();
					ArrayList<OrderBean> unacceptedOrderList = new ArrayList<>();

					//Create new arraylist of order beans with just status 1
					for (OrderBean order : orderList) {
						if (order.getStatus().equals("1"))
							unacceptedOrderList.add(order);
					}
					String[] stringList = new String[orderList.size()];
					
					for (int i = 0; i < unacceptedOrderList.size(); i++) {
						String order = unacceptedOrderList.get(i).getId() + " - " + unacceptedOrderList.get(i).getDeliveryDate() + " - " + unacceptedOrderList.get(i).getDeliveryTime();
						stringList[i] = order;
						((DefaultListModel)acceptOrderView.getPendingOrder_JList().getModel()).addElement(order);
						//System.out.println(order);
					}
					acceptOrderView.repaint();
					acceptOrderView.revalidate();
					
					//Creation of Pending Orders JList Selection
					acceptOrderView.getPendingOrder_JList().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							
							int i = acceptOrderView.getPendingOrder_JList().getSelectedIndex();
							
							//Implement date into text field
							String date = orderList.get(i).getDeliveryDate();
							acceptOrderView.getDeliveryTime_Ftf().setText(date);
							
							//Implement time into text field
							String hour = orderList.get(i).getDeliveryTime();
							acceptOrderView.getHour_Ftf().setText(hour);
							
							//Implement postal code into text field
							String postal = orderList.get(i).getPostalCode();
							acceptOrderView.getPostalCode_Ftf().setText(postal);
							
							//Populate Meal JList
							//String[] stringList = new String[menuList.size()];
							String[][] menu = unacceptedOrderList.get(i).getOrder();
							
							//Remove Populated Meal List
							((DefaultListModel)acceptOrderView.getMeal_JList().getModel()).removeAllElements();
							
							for (int j = 0; j < menu.length; j++) {
								String menuItem = menu[j][0] + " - " + " Qty. : " + menu[j][1] + " - Price " + menu[j][2] + "$";
								((DefaultListModel)acceptOrderView.getMeal_JList().getModel()).addElement(menuItem);
								//System.out.println(menu);
							}
							acceptOrderView.repaint();
							acceptOrderView.revalidate();
						}
					});
					
					//Creating Action Listener for Accept Order Button
					acceptOrderView.getAcceptOrder_Btn().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							int i = acceptOrderView.getPendingOrder_JList().getSelectedIndex();
							
							if (i != -1) {
								
								orderList.get(i).setStatus("2");
						//Confirm message for Accept Button
								JOptionPane.showMessageDialog(acceptOrderView, "Order Accepted!", "Confirm Order", JOptionPane.INFORMATION_MESSAGE);
						//Delete the selected index in the JList after button is pressed.
								int selectedIndex = acceptOrderView.getPendingOrder_JList().getSelectedIndex();
								acceptOrderView.getListModel().remove(selectedIndex);
								
						//Set text fields to null
								acceptOrderView.getDeliveryTime_Ftf().setText(null);
								acceptOrderView.getHour_Ftf().setText(null);
								acceptOrderView.getPostalCode_Ftf().setText(null);
								
						//Clear Meal List
								acceptOrderView.getListModel2().removeAllElements();
								
								acceptOrderView.repaint();
								acceptOrderView.revalidate();
								
							}
							
						}
					});
				}	
			});
			
			//----------------------------------------READY ORDER
			JMenuItem readyOrderItem = (JMenuItem) menuBar.getOrderRestaurateur().getMenuComponent(1);
			readyOrderItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					readyOrderView = new ReadyOrderView();
					
					//Close active window
					Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow(); 
					activeWindow.dispose();
					//Overwrite MenuBar
					MenuBar readyOrderItem = menuBar;
					
					//Retrieve relevant menus
					readyOrderItem.getOrderRestaurateur().setVisible(true);
					readyOrderItem.getOrderRestaurateur().getItem(1).setEnabled(false);
					readyOrderItem.getOrderRestaurateur().getItem(0).setEnabled(true);
					
					//Add MenuBar to the view
					readyOrderView.setJMenuBar(readyOrderItem);
					readyOrderView.repaint();
					readyOrderView.revalidate();
					
					//Populate Accepted Orders JList
					ArrayList<OrderBean> orderList = orderModel.getAllOrders();
					ArrayList<OrderBean> readyOrderList = new ArrayList<>();
					
					//Create new arraylist of order beans with status 2
					for (OrderBean order : orderList) {
						if (order.getStatus().equals("2"))
							readyOrderList.add(order);
					}
					String[] stringList = new String[orderList.size()];
					
					for (int i = 0; i < readyOrderList.size(); i++) {
						String order = readyOrderList.get(i).getId() + " - " + readyOrderList.get(i).getDeliveryDate() + " - " + readyOrderList.get(i).getDeliveryTime();
						stringList[i] = order;
						((DefaultListModel)readyOrderView.getAcceptedOrder_JList().getModel()).addElement(order);
						//System.out.println(order);
					}
					readyOrderView.repaint();
					readyOrderView.revalidate();
					
					//Creation of Pending Orders JList Selection
					readyOrderView.getAcceptedOrder_JList().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							
							int i = readyOrderView.getAcceptedOrder_JList().getSelectedIndex();
							
							//Implement date into text field
							String date = orderList.get(i).getDeliveryDate();
							readyOrderView.getDeliveryTime_Ftf().setText(date);
							
							//Implement time into text field
							String hour = orderList.get(i).getDeliveryTime();
							readyOrderView.getHour_Ftf().setText(hour);
							
							//Implement postal code into text field
							String postal = orderList.get(i).getPostalCode();
							readyOrderView.getPostalCode_Ftf().setText(postal);
							
							//Populate Meal JList
							//String[] stringList = new String[menuList.size()];
							String[][] menu = readyOrderList.get(i).getOrder();
							
							//Remove populated meal List
							((DefaultListModel)readyOrderView.getMeal_JList().getModel()).removeAllElements();
							for (int j = 0; j < menu.length; j++) {
								String menuItem = menu[j][0] + " - " + " Qty. : " + menu[j][1] + " - Price " + menu[j][2] + "$";
								((DefaultListModel)readyOrderView.getMeal_JList().getModel()).addElement(menuItem);
								//System.out.println(menu);
							}
							readyOrderView.repaint();
							readyOrderView.revalidate();
						}
					});
					
					
				//Action listener for Order Ready button
					readyOrderView.getOrderReady_Btn().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							int i = readyOrderView.getAcceptedOrder_JList().getSelectedIndex();
							
							if (i != -1) {
							orderList.get(i).setStatus("3");
							//System.out.println(orderList.get(i).getStatus());
					//Confirm message for Accept Button
							JOptionPane.showMessageDialog(readyOrderView, "Order marked as ready!", "Ready Order", JOptionPane.INFORMATION_MESSAGE);
					//Delete the selected index in the JList after button is pressed.
							int selectedIndex = readyOrderView.getAcceptedOrder_JList().getSelectedIndex();
							readyOrderView.getListModel().remove(selectedIndex);
							
					//Set text fields to null
							readyOrderView.getDeliveryTime_Ftf().setText(null);
							readyOrderView.getHour_Ftf().setText(null);
							readyOrderView.getPostalCode_Ftf().setText(null);
							
					//Clear Meal List
							readyOrderView.getListModel2().removeAllElements();
							
							readyOrderView.repaint();
							readyOrderView.revalidate();
							
							}
						}
					});
					
				}
			});
			
			//Creating Action Listener for QUIT
			JMenuItem quitItem = (JMenuItem) menuBar.getFile().getMenuComponent(1);
			quitItem.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
					
				}
			});
	
		//Creating Action Listener for DISCONNECT
			JMenuItem disconectItem = (JMenuItem) menuBar.getFile().getMenuComponent(0);
			disconectItem.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					userModel.setCurrentUser(null);
					
					//Open Login Screen
					LoginController mainScreen = new LoginController(userModel);
					
					//Close active window
					Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow(); 
					activeWindow.dispose();
					
				}
			});
		}
}

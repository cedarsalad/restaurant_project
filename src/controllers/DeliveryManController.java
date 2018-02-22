package controllers;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import custom_controls.MenuBar;
import models.DeliveryManModel;
import models.OrderBean;
import models.OrderModel;
import models.UserModel;
import views.AcceptDeliveriesView;
import views.AcceptOrderView;
import views.DeliveryDoneView;
import views.MenuView;
import views.ViewDeliveriesView;

public class DeliveryManController {
	
	//Create Controllers
	private LoginController loginController;
	
	//Create Models
	private UserModel userModel;
	private OrderModel orderModel;
	private DeliveryManModel deliveryManModel;
	
	//Create Views
	private MenuView menuView;
	private ViewDeliveriesView viewDeliveriesView;
	private AcceptDeliveriesView acceptDeliveriesView;
	private DeliveryDoneView deliveryDoneView;
	private MenuBar menuBar;
	
	public DeliveryManController(DeliveryManModel deliveryManModel) {
		this.deliveryManModel = deliveryManModel;
		userModel = new UserModel();
		orderModel = new OrderModel();

		menuView = new MenuView();
		
	//Show menu bar buttons (menus)
		menuBar = new MenuBar();
	
	//Retrieve relevant menus
		menuBar.getDelivery().setVisible(true);
		
	//Add MenuBar to the view
		menuView.setJMenuBar(menuBar);
		menuView.repaint();
		menuView.revalidate();
	
	//Creating Action Listener for VIEW-DELIVERIES
		JMenuItem viewDeliveriesItem = (JMenuItem) menuBar.getDelivery().getMenuComponent(0);
		viewDeliveriesItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewDeliveriesView = new ViewDeliveriesView();
				
				//Close active window
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow(); 
				activeWindow.dispose();
				//Overwrite MenuBar
				MenuBar viewDeliveriesMenuBar = menuBar;
				
				//Retrieve relevant menus
				viewDeliveriesMenuBar.getDelivery().setVisible(true);
				viewDeliveriesMenuBar.getDelivery().getItem(0).setEnabled(false);
				viewDeliveriesMenuBar.getDelivery().getItem(1).setEnabled(true);
				viewDeliveriesMenuBar.getDelivery().getItem(2).setEnabled(true);
				
				//Add MenuBar to the view
				viewDeliveriesView.setJMenuBar(viewDeliveriesMenuBar);
				viewDeliveriesView.repaint();
				viewDeliveriesView.revalidate();
				
				//Populate Pending Orders JList
				ArrayList<OrderBean> orderList = orderModel.getAllOrders();
				ArrayList<OrderBean> statusList3 = new ArrayList<>();
				
				//Create new arraylist of order beans with just status 3
				for (OrderBean order : orderList) {
					if (order.getStatus().equals("3"))
						statusList3.add(order);
				}
				String[] stringList = new String[orderList.size()];
				
				for (int i = 0; i < statusList3.size(); i++) {
					String order = statusList3.get(i).getId() + " - " + statusList3.get(i).getDeliveryDate() + " - " + statusList3.get(i).getDeliveryTime();
					stringList[i] = order;
					((DefaultListModel)viewDeliveriesView.getOrders_JList().getModel()).addElement(order);
					//System.out.println(order);
				}
				viewDeliveriesView.repaint();
				viewDeliveriesView.revalidate();
				
				//Creation of Pending Orders JList SELECTION
				viewDeliveriesView.getOrders_JList().addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						
						int i = viewDeliveriesView.getOrders_JList().getSelectedIndex();
						
						//Implement orderNumber into text field
						String orderNumber = orderList.get(i).getId();
						viewDeliveriesView.getOrderNumber_Label().setText("Order # : " + orderNumber);
						
						//Implement restaurantNumber into text field
						String restaurantNumber = orderList.get(i).getRestaurant();
						viewDeliveriesView.getRestaurantNumber_Label().setText("Restaurant # : " + restaurantNumber);
						
						//Implement Address into text field
						String deliveryAddress = orderList.get(i).getAddress();
						viewDeliveriesView.getDeliveryAddress_Label().setText("Restaurant Address :" + deliveryAddress);
						
						//Implement postalCode into text field
						String postalCode = orderList.get(i).getPostalCode();
						viewDeliveriesView.getDeliveryPostal_Label().setText("Postal Code :" + postalCode);
						
						viewDeliveriesView.repaint();
						viewDeliveriesView.revalidate();
					}
				});
				
			}
		});
		
	
	//Creating Action Listener for ACCEPT-DELIVERIES
			JMenuItem acceptDeliveriesItem = (JMenuItem) menuBar.getDelivery().getMenuComponent(1);
			acceptDeliveriesItem.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					acceptDeliveriesView = new AcceptDeliveriesView();
					
					//Close active window
					Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow(); 
					activeWindow.dispose();
						
					//Overwrite MenuBar
					MenuBar acceptDeliveriesMenuBar = menuBar;
					
					//Retrieve and hide relevant menus
					acceptDeliveriesMenuBar.getDelivery().setVisible(true);
					acceptDeliveriesMenuBar.getDelivery().getItem(1).setEnabled(false);
					acceptDeliveriesMenuBar.getDelivery().getItem(0).setEnabled(true);
					acceptDeliveriesMenuBar.getDelivery().getItem(2).setEnabled(true);
						
					//Add MenuBar to the view
					acceptDeliveriesView.setJMenuBar(acceptDeliveriesMenuBar);
					acceptDeliveriesView.repaint();
					acceptDeliveriesView.revalidate();
					
					//Populate Pending Orders JList
					ArrayList<OrderBean> orderList = orderModel.getAllOrders();
					ArrayList<OrderBean> statusList3 = new ArrayList<>();
					
					//Create new arraylist of order beans with just status 3
					for (OrderBean order : orderList) {
						if (order.getStatus().equals("3"))
							statusList3.add(order);
					}
					String[] stringList = new String[orderList.size()];
					
					for (int i = 0; i < statusList3.size(); i++) {
						String order = statusList3.get(i).getId() + " - " + statusList3.get(i).getDeliveryDate() + " - " + statusList3.get(i).getDeliveryTime();
						stringList[i] = order;
						((DefaultListModel)acceptDeliveriesView.getOrders_JList().getModel()).addElement(order);
						//System.out.println(order);
					}
					acceptDeliveriesView.repaint();
					acceptDeliveriesView.revalidate();
					
					//Creation of Pending Orders JList SELECTION
					acceptDeliveriesView.getOrders_JList().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							
							int i = acceptDeliveriesView.getOrders_JList().getSelectedIndex();
							
							//Implement orderNumber into text field
							String orderNumber = orderList.get(i).getId();
							acceptDeliveriesView.getOrderNumber_Label().setText("Order # : " + orderNumber);
							
							//Implement restaurantNumber into text field
							String restaurantNumber = orderList.get(i).getRestaurant();
							acceptDeliveriesView.getRestaurantNumber_Label().setText("Restaurant # : " + restaurantNumber);
							
							//Implement Address into text field
							String deliveryAddress = orderList.get(i).getAddress();
							acceptDeliveriesView.getDeliveryAddress_Label().setText("Restaurant Address :" + deliveryAddress);
							
							//Implement postalCode into text field
							String postalCode = orderList.get(i).getPostalCode();
							acceptDeliveriesView.getDeliveryPostal_Label().setText("Postal Code :" + postalCode);
							
							acceptDeliveriesView.repaint();
							acceptDeliveriesView.revalidate();
						}
					});
					
					//ActionListener for AcceptDeliveryButton
					acceptDeliveriesView.getAcceptDelivery_Btn().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							
							int ret = JOptionPane.showConfirmDialog(acceptDeliveriesView, "Are you sure you want to accept this order?", "Confirm Save", JOptionPane.YES_NO_OPTION);
							if (ret == 0 && acceptDeliveriesView.getOrders_JList().getSelectedIndex() != -1) {
								JOptionPane.showMessageDialog(acceptDeliveriesView, "The delivery was assigned to the Delivery Man!", "Confirm Save", JOptionPane.INFORMATION_MESSAGE);
						
						//Set new STATUS
								int i = acceptDeliveriesView.getOrders_JList().getSelectedIndex();
								orderList.get(i).setStatus("4");
					
						//Delete the selected index in the JList after button is pressed.
								int selectedIndex = acceptDeliveriesView.getOrders_JList().getSelectedIndex();
								acceptDeliveriesView.getListModel().remove(selectedIndex);
								
						//Set text fields to null
								acceptDeliveriesView.getOrderNumber_Label().setText("Order # :");
								acceptDeliveriesView.getRestaurantNumber_Label().setText("Restaurant # :");
								acceptDeliveriesView.getDeliveryPostal_Label().setText("Postal Code # :");
								
							}
						}
					});
				}
			});
			
	//--------------------------------------DONE-DELIVERIES
			JMenuItem deliveryDoneItem = (JMenuItem) menuBar.getDelivery().getMenuComponent(2);
			deliveryDoneItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					deliveryDoneView = new DeliveryDoneView();
					
					//Close active window
					Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow(); 
					activeWindow.dispose();
						
					//Overwrite MenuBar
					MenuBar deliveryDoneMenuBar = menuBar;
					
					//Retrieve and hide relevant menus
					deliveryDoneMenuBar.getDelivery().setVisible(true);
					deliveryDoneMenuBar.getDelivery().getItem(2).setEnabled(false);
					deliveryDoneMenuBar.getDelivery().getItem(0).setEnabled(true);
					deliveryDoneMenuBar.getDelivery().getItem(1).setEnabled(true);
					
					//Add MenuBar to the view
					deliveryDoneView.setJMenuBar(deliveryDoneMenuBar);
					deliveryDoneView.repaint();
					deliveryDoneView.revalidate();
					
					//Populate Orders JList
					ArrayList<OrderBean> orderList = orderModel.getAllOrders();
					ArrayList<OrderBean> statusList4 = new ArrayList<>();
					
					//Create new arraylist of order beans with just status 4
					for (OrderBean order : orderList) {
						if (order.getStatus().equals("4"))
							statusList4.add(order);
					}
					String[] stringList = new String[orderList.size()];
					
					for (int i = 0; i < statusList4.size(); i++) {
						String order = statusList4.get(i).getId() + " - " + statusList4.get(i).getDeliveryDate() + " - " + statusList4.get(i).getDeliveryTime();
						stringList[i] = order;
						((DefaultListModel)deliveryDoneView.getOrders_JList().getModel()).addElement(order);
						//System.out.println(order);
					}
					deliveryDoneView.repaint();
					deliveryDoneView.revalidate();
					
					//Creation of Orders JList SELECTION
					deliveryDoneView.getOrders_JList().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							
							int i = deliveryDoneView.getOrders_JList().getSelectedIndex();
							
							//Implement orderNumber into label
							String orderNumber = orderList.get(i).getId();
							deliveryDoneView.getOrderNumber_Label().setText("Order # : " + orderNumber);
							
							//Implement restaurantNumber into label
							String restaurantNumber = orderList.get(i).getRestaurant();
							deliveryDoneView.getRestaurantNumber_Label().setText("Restaurant # : " + restaurantNumber);
							
							//Implement Address into text field
							String deliveryAddress = orderList.get(i).getAddress();
							deliveryDoneView.getDeliveryAddress_Label().setText("Restaurant Address :" + deliveryAddress);
							
							//Implement postalCode into label
							String postalCode = orderList.get(i).getPostalCode();
							deliveryDoneView.getDeliveryPostal_Label().setText("Postal Code :" + postalCode);
							
							deliveryDoneView.repaint();
							deliveryDoneView.revalidate();
						}
					});

					//ActionListener for AcceptDoneButton
					deliveryDoneView.getDeliveryDone_Btn().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							//JOptionPane confirmation = new JOptionPane();
							
							int ret = JOptionPane.showConfirmDialog(deliveryDoneView, "Are you sure you have completed this order?", "Confirm Save", JOptionPane.YES_NO_OPTION);
							if (ret == 0 && deliveryDoneView.getOrders_JList().getSelectedIndex() != -1) {
								JOptionPane.showMessageDialog(deliveryDoneView, "The delivery has been marked as 'done'", "Confirm Save", JOptionPane.INFORMATION_MESSAGE);
						//Set new STATUS
								int i = deliveryDoneView.getOrders_JList().getSelectedIndex();
								orderList.get(i).setStatus("5");
					
						//Delete the selected index in the JList after button is pressed.
								int selectedIndex = deliveryDoneView.getOrders_JList().getSelectedIndex();
								deliveryDoneView.getListModel().remove(selectedIndex);
								
						//Set text fields to null
								deliveryDoneView.getOrderNumber_Label().setText("Order # :");
								deliveryDoneView.getRestaurantNumber_Label().setText("Restaurant # :");
								deliveryDoneView.getDeliveryPostal_Label().setText("Postal Code # :");
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

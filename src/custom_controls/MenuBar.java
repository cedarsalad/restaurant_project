package custom_controls;

import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	private JMenu file;
	private JMenu restaurant;
	private JMenu menu;
	private JMenu deliveryMan;
	private JMenu delivery;
	private JMenu account;
	private JMenu orderClient;
	private JMenu orderRestaurateur;
	private JMenu orderManager;
	

	public MenuBar() {
		//
		//Creating the MenuBar menu
		//
		
		///// File Menu
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		// Add Menu Items
		
		// MENU INDEX
		// 0 - File
		// 1 - Account
		// 2 - Restaurant
		// 3 - Menu
		// 4 - Delivery Man
		// 5 - Delivery
		// 6 - Order (client)
		// 7 - Order (restaurant)
		// 8 - Order (manager)
		
		file.add(new JMenuItem("Disconnect"));
		file.add(new JMenuItem("Quit"));
		
		this.add(file);

		///// Account Menu
		account = new JMenu("Account");
		account.setVisible(false);
		account.setMnemonic(KeyEvent.VK_A);
		// Add Menu Items
		account.add(new JMenuItem("Edit Account"));
		account.add(new JMenuItem("Close Account"));
		
		this.add(account);
		
		///// Restaurant Menu
		restaurant = new JMenu("Restaurant");
		restaurant.setVisible(false);
		restaurant.setMnemonic(KeyEvent.VK_R);
		// Add Menu Items
		restaurant.add(new JMenuItem("Create Restaurant"));
		restaurant.add(new JMenuItem("Edit Restaurant"));
		restaurant.add(new JMenuItem("Delete Restaurant"));
		
		this.add(restaurant);

		///// Menu Menu ;)
		menu = new JMenu("Menu");
		menu.setVisible(false);
		menu.setMnemonic(KeyEvent.VK_M);
		// Add Menu Items
		menu.add(new JMenuItem("Create Menu"));
		menu.add(new JMenuItem("Edit Menu"));
		menu.add(new JMenuItem("Delete Menu"));
		
		this.add(menu);

		///// Delivery Man Menu
		deliveryMan = new JMenu("Delivery Man");
		deliveryMan.setVisible(false);
		deliveryMan.setMnemonic(KeyEvent.VK_D);
		// Add Menu Items
		deliveryMan.add(new JMenuItem("Create Delivery Man"));
		deliveryMan.add(new JMenuItem("Edit Delivery Man"));
		deliveryMan.add(new JMenuItem("Delete Delivery Man"));
		
		this.add(deliveryMan);
		
		///// Delivery
		delivery = new JMenu("Delivery");
		delivery.setVisible(false);
		delivery.setMnemonic(KeyEvent.VK_D);
		// Add Menu Items
		delivery.add(new JMenuItem("View Deliveries"));
		delivery.add(new JMenuItem("Accept Delivery"));
		delivery.add(new JMenuItem("Delivery Made"));
		
		this.add(delivery);
		
		///// Order (Client) Menu
		
		orderClient = new JMenu("Order");
		orderClient.setVisible(false);
		orderClient.setMnemonic(KeyEvent.VK_O);
		// Add Menu Items
		orderClient.add(new JMenuItem("Order Food"));
		orderClient.add(new JMenuItem("Order History"));

		this.add(orderClient);

		///// Order (Restaurator) Menu
		orderRestaurateur = new JMenu("Order");
		orderRestaurateur.setVisible(false);
		orderRestaurateur.setMnemonic(KeyEvent.VK_O);
		// Add Menu Items
		orderRestaurateur.add(new JMenuItem("Accept Order"));
		orderRestaurateur.add(new JMenuItem("Order Ready"));

		this.add(orderRestaurateur);

		///// Order (Manager) Menu
		orderManager = new JMenu("Order");
		orderManager.setVisible(false);
		orderManager.setMnemonic(KeyEvent.VK_O);
		// Add Menu Items
		orderManager.add(new JMenuItem("View Orders"));

		this.add(orderManager);
		
		// Menu Bar end
		
		//this.setVisible(true);
	}

	///// getters setters

	public JMenu getFile() {
		return file;
	}
	
	public void setFile(JMenu file) {
		this.file = file;
	}

	public JMenu getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(JMenu restaurant) {
		this.restaurant = restaurant;
	}

	public JMenu getMenu() {
		return menu;
	}

	public void setMenu(JMenu menu) {
		this.menu = menu;
	}

	public JMenu getDeliveryMan() {
		return deliveryMan;
	}

	public void setDeliveryMan(JMenu deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public JMenu getDelivery() {
		return delivery;
	}

	public void setDelivery(JMenu delivery) {
		this.delivery = delivery;
	}

	public JMenu getAccount() {
		return account;
	}

	public void setAccount(JMenu account) {
		this.account = account;
	}

	public JMenu getOrderClient() {
		return orderClient;
	}

	public void setOrderClient(JMenu orderClient) {
		this.orderClient = orderClient;
	}

	public JMenu getOrderRestaurateur() {
		return orderRestaurateur;
	}

	public void setOrderRestaurateur(JMenu orderRestaurateur) {
		this.orderRestaurateur = orderRestaurateur;
	}

	public JMenu getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(JMenu orderManager) {
		this.orderManager = orderManager;
	}


}
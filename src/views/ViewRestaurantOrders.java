package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JList;

public class ViewRestaurantOrders extends JFrame {

	private JPanel contentPane;
	private JList<String> restaurant_JList;
	private JLabel restaurant_Label;
	private JButton select_Btn;
	private JList<String> meal_JList;
	private JFormattedTextField deliveryTime_Ftf;
	private JFormattedTextField hour_Ftf;
	private JFormattedTextField minute_Ftf;
	private JFormattedTextField postalCode_Ftf;
	private JList<String> restaurantOrders_JList;
	private JButton select2_Btn;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRestaurantOrders frame = new ViewRestaurantOrders();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewRestaurantOrders() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel mainNorth_Panel = new JPanel();
		mainNorth_Panel.setForeground(Color.BLACK);
		mainNorth_Panel.setPreferredSize(new Dimension(10, 25));
		contentPane.add(mainNorth_Panel, BorderLayout.NORTH);
		mainNorth_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel mainCenter_Panel = new JPanel();
		contentPane.add(mainCenter_Panel, BorderLayout.CENTER);
		mainCenter_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		meal_JList = new JList<String>();
		meal_JList.setEnabled(false);
		meal_JList.setBounds(263, 301, 363, 299);
		info_Panel.add(meal_JList);
		
		JLabel deliveryTime_Label = new JLabel("Delivery Time (yyyy/mm/dd) :");
		deliveryTime_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime_Label.setBounds(263, 153, 245, 23);
		info_Panel.add(deliveryTime_Label);
		
		JLabel deliveryTime2_Label = new JLabel("Delivery Time :");
		deliveryTime2_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime2_Label.setBounds(263, 187, 169, 22);
		info_Panel.add(deliveryTime2_Label);
		
		deliveryTime_Ftf = new JFormattedTextField();
		deliveryTime_Ftf.setEnabled(false);
		deliveryTime_Ftf.setBounds(495, 156, 131, 23);
		info_Panel.add(deliveryTime_Ftf);
		
		hour_Ftf = new JFormattedTextField();
		hour_Ftf.setEnabled(false);
		hour_Ftf.setBounds(495, 190, 42, 23);
		info_Panel.add(hour_Ftf);
		
		JLabel hour_Label = new JLabel("h");
		hour_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hour_Label.setBounds(542, 191, 17, 22);
		info_Panel.add(hour_Label);
		
		minute_Ftf = new JFormattedTextField();
		minute_Ftf.setEnabled(false);
		minute_Ftf.setBounds(557, 190, 42, 23);
		info_Panel.add(minute_Ftf);
		
		JLabel minute_Label = new JLabel("m\r\n");
		minute_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		minute_Label.setBounds(609, 191, 17, 22);
		info_Panel.add(minute_Label);
		
		JLabel postalCode_Label = new JLabel("Postal Code :");
		postalCode_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		postalCode_Label.setBounds(263, 220, 245, 23);
		info_Panel.add(postalCode_Label);
		
		postalCode_Ftf = new JFormattedTextField();
		postalCode_Ftf.setEnabled(false);
		postalCode_Ftf.setBounds(495, 223, 131, 23);
		info_Panel.add(postalCode_Ftf);
		
		JLabel meal_Label = new JLabel("Meal In Order");
		meal_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		meal_Label.setBounds(263, 278, 245, 23);
		info_Panel.add(meal_Label);
		
		JLabel viewOrder_Label = new JLabel("View Order");
		viewOrder_Label.setPreferredSize(new Dimension(600, 40));
		viewOrder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		viewOrder_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		viewOrder_Label.setBounds(354, 102, 205, 40);
		info_Panel.add(viewOrder_Label);
		
		JLabel restaurantOrders_Label = new JLabel("Restaurant Orders");
		restaurantOrders_Label.setPreferredSize(new Dimension(120, 20));
		restaurantOrders_Label.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantOrders_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		restaurantOrders_Label.setBounds(24, 11, 199, 28);
		info_Panel.add(restaurantOrders_Label);
		
		restaurantOrders_JList = new JList<String>();
		restaurantOrders_JList.setPreferredSize(new Dimension(199, 640));
		restaurantOrders_JList.setBounds(24, 50, 199, 620);
		info_Panel.add(restaurantOrders_JList);
		
		select2_Btn = new JButton("Select");
		select2_Btn.setPreferredSize(new Dimension(195, 23));
		select2_Btn.setBounds(26, 675, 195, 23);
		info_Panel.add(select2_Btn);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		mainWest_Panel.setLayout(null);
		
		restaurant_Label = new JLabel("Restaurant");
		restaurant_Label.setBounds(21, 11, 153, 28);
		restaurant_Label.setHorizontalAlignment(SwingConstants.CENTER);
		restaurant_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		restaurant_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(restaurant_Label);
		
		restaurant_JList = new JList<String>();
		restaurant_JList.setBounds(1, 50, 199, 620);
		restaurant_JList.setPreferredSize(new Dimension(199, 640));
		mainWest_Panel.add(restaurant_JList);
		
		select_Btn = new JButton("Select");
		select_Btn.setBounds(3, 675, 195, 23);
		select_Btn.setPreferredSize(new Dimension(195, 23));
		mainWest_Panel.add(select_Btn);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
	}

	public JList<String> getRestaurant_JList() {
		return restaurant_JList;
	}

	public void setRestaurant_JList(JList<String> restaurant_JList) {
		this.restaurant_JList = restaurant_JList;
	}

	public JButton getSelect_Btn() {
		return select_Btn;
	}

	public void setSelect_Btn(JButton select_Btn) {
		this.select_Btn = select_Btn;
	}

	public JList<String> getMeal_JList() {
		return meal_JList;
	}

	public void setMeal_JList(JList<String> meal_JList) {
		this.meal_JList = meal_JList;
	}

	public JFormattedTextField getDeliveryTime_Ftf() {
		return deliveryTime_Ftf;
	}

	public void setDeliveryTime_Ftf(JFormattedTextField deliveryTime_Ftf) {
		this.deliveryTime_Ftf = deliveryTime_Ftf;
	}

	public JFormattedTextField getHour_Ftf() {
		return hour_Ftf;
	}

	public void setHour_Ftf(JFormattedTextField hour_Ftf) {
		this.hour_Ftf = hour_Ftf;
	}

	public JFormattedTextField getMinute_Ftf() {
		return minute_Ftf;
	}

	public void setMinute_Ftf(JFormattedTextField minute_Ftf) {
		this.minute_Ftf = minute_Ftf;
	}

	public JFormattedTextField getPostalCode_Ftf() {
		return postalCode_Ftf;
	}

	public void setPostalCode_Ftf(JFormattedTextField postalCode_Ftf) {
		this.postalCode_Ftf = postalCode_Ftf;
	}

	public JList<String> getRestaurantOrders_JList() {
		return restaurantOrders_JList;
	}

	public void setRestaurantOrders_JList(JList<String> restaurantOrders_JList) {
		this.restaurantOrders_JList = restaurantOrders_JList;
	}

	public JButton getSelect2_Btn() {
		return select2_Btn;
	}

	public void setSelect2_Btn(JButton select2_Btn) {
		this.select2_Btn = select2_Btn;
	}
}

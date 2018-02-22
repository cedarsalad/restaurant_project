package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OrderHistoryView extends JFrame {

	private JPanel contentPane;
	private JLabel viewOrder_Label;
	private JList<String> restaurant_JList;
	private JLabel yourOrders_Label;
	private JList<String> meal_JList;
	private JFormattedTextField deliveryDate_Ftf;
	private JFormattedTextField postalCode_Ftf;
	private JFormattedTextField deliveryTime_Ftf;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHistoryView frame = new OrderHistoryView();
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
	public OrderHistoryView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel mainNorth_Panel = new JPanel();
		mainNorth_Panel.setForeground(Color.BLACK);
		mainNorth_Panel.setPreferredSize(new Dimension(10, 25));
		contentPane.add(mainNorth_Panel, BorderLayout.NORTH);
		mainNorth_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel mainCenter_Panel = new JPanel();
		contentPane.add(mainCenter_Panel, BorderLayout.CENTER);
		mainCenter_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerNorth_Panel = new JPanel();
		centerNorth_Panel.setPreferredSize(new Dimension(10, 50));
		mainCenter_Panel.add(centerNorth_Panel, BorderLayout.NORTH);
		
		viewOrder_Label = new JLabel("View Order");
		viewOrder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		viewOrder_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		viewOrder_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(viewOrder_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		DefaultListModel orderModel = new DefaultListModel();
		
		meal_JList = new JList<String>(orderModel);
		meal_JList.setEnabled(false);
		meal_JList.setBounds(123, 159, 363, 299);
		info_Panel.add(meal_JList);
		
		JLabel deliveryTime_Label = new JLabel("Delivery Time (yyyy/mm/dd) :");
		deliveryTime_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime_Label.setBounds(123, 11, 245, 23);
		info_Panel.add(deliveryTime_Label);
		
		JLabel deliveryTime2_Label = new JLabel("Delivery Time :");
		deliveryTime2_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime2_Label.setBounds(123, 45, 169, 22);
		info_Panel.add(deliveryTime2_Label);
		
		deliveryDate_Ftf = new JFormattedTextField();
		deliveryDate_Ftf.setEnabled(false);
		deliveryDate_Ftf.setBounds(355, 14, 131, 23);
		info_Panel.add(deliveryDate_Ftf);
		
		JLabel postalCode_Label = new JLabel("Postal Code :");
		postalCode_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		postalCode_Label.setBounds(123, 78, 245, 23);
		info_Panel.add(postalCode_Label);
		
		postalCode_Ftf = new JFormattedTextField();
		postalCode_Ftf.setEnabled(false);
		postalCode_Ftf.setBounds(355, 81, 131, 23);
		info_Panel.add(postalCode_Ftf);
		
		JLabel meal_Label = new JLabel("Meal In Order");
		meal_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		meal_Label.setBounds(123, 136, 245, 23);
		info_Panel.add(meal_Label);
		
		deliveryTime_Ftf = new JFormattedTextField();
		deliveryTime_Ftf.setEnabled(false);
		deliveryTime_Ftf.setBounds(355, 49, 131, 23);
		info_Panel.add(deliveryTime_Ftf);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		mainWest_Panel.setLayout(null);
		
		yourOrders_Label = new JLabel("Your Orders");
		yourOrders_Label.setBounds(21, 11, 153, 28);
		yourOrders_Label.setHorizontalAlignment(SwingConstants.CENTER);
		yourOrders_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		yourOrders_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(yourOrders_Label);
		
		DefaultListModel restaurantModel = new DefaultListModel();

		restaurant_JList = new JList<String>(restaurantModel);
		restaurant_JList.setBounds(1, 50, 199, 650);
		restaurant_JList.setPreferredSize(new Dimension(199, 640));
		mainWest_Panel.add(restaurant_JList);
		
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

	public JList<String> getMeal_JList() {
		return meal_JList;
	}

	public void setMeal_JList(JList<String> meal_JList) {
		this.meal_JList = meal_JList;
	}

	public JFormattedTextField getDeliveryDate_Ftf() {
		return deliveryDate_Ftf;
	}

	public void setDeliveryDate_Ftf(JFormattedTextField deliveryDate_Ftf) {
		this.deliveryDate_Ftf = deliveryDate_Ftf;
	}

	public JFormattedTextField getPostalCode_Ftf() {
		return postalCode_Ftf;
	}

	public void setPostalCode_Ftf(JFormattedTextField postalCode_Ftf) {
		this.postalCode_Ftf = postalCode_Ftf;
	}

	public JFormattedTextField getDeliveryTime_Ftf() {
		return deliveryTime_Ftf;
	}

	public void setDeliveryTime_Ftf(JFormattedTextField deliveryTime_Ftf) {
		this.deliveryTime_Ftf = deliveryTime_Ftf;
	}
}

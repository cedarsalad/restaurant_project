package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.DefaultListModel;
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

public class ReadyOrderView extends JFrame {

	private JPanel contentPane;
	private JLabel orderReady_Label;
	private JList<String> acceptedOrder_JList;
	private JLabel acceptedOrders_Label;
	private JList<String> meal_JList;
	private JButton orderReady_Btn;
	private JFormattedTextField deliveryTime_Ftf;
	private JFormattedTextField hour_Ftf;
	private JFormattedTextField postalCode_Ftf;
	private DefaultListModel listModel;
	private DefaultListModel listModel2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadyOrderView frame = new ReadyOrderView();
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
	public ReadyOrderView() {
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
		
		JPanel centerNorth_Panel = new JPanel();
		centerNorth_Panel.setPreferredSize(new Dimension(10, 50));
		mainCenter_Panel.add(centerNorth_Panel, BorderLayout.NORTH);
		
		orderReady_Label = new JLabel("Order Ready");
		orderReady_Label.setHorizontalAlignment(SwingConstants.CENTER);
		orderReady_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		orderReady_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(orderReady_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		listModel2 = new DefaultListModel();
		meal_JList = new JList<String>(listModel2);
		meal_JList.setEnabled(false);
		meal_JList.setBounds(123, 159, 363, 299);
		info_Panel.add(meal_JList);
		
		orderReady_Btn = new JButton("Order Ready");
		orderReady_Btn.setBounds(250, 469, 118, 23);
		info_Panel.add(orderReady_Btn);
		
		JLabel deliveryTime_Label = new JLabel("Delivery Time (yyyy/mm/dd) :");
		deliveryTime_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime_Label.setBounds(123, 11, 245, 23);
		info_Panel.add(deliveryTime_Label);
		
		JLabel deliveryTime2_Label = new JLabel("Delivery Time :");
		deliveryTime2_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime2_Label.setBounds(123, 45, 169, 22);
		info_Panel.add(deliveryTime2_Label);
		
		deliveryTime_Ftf = new JFormattedTextField();
		deliveryTime_Ftf.setEnabled(false);
		deliveryTime_Ftf.setBounds(355, 14, 131, 23);
		info_Panel.add(deliveryTime_Ftf);
		
		hour_Ftf = new JFormattedTextField();
		hour_Ftf.setEnabled(false);
		hour_Ftf.setBounds(355, 48, 131, 23);
		info_Panel.add(hour_Ftf);
		
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
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		mainWest_Panel.setLayout(null);
		
		acceptedOrders_Label = new JLabel("Accepted Orders");
		acceptedOrders_Label.setBounds(21, 11, 153, 28);
		acceptedOrders_Label.setHorizontalAlignment(SwingConstants.CENTER);
		acceptedOrders_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		acceptedOrders_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(acceptedOrders_Label);
		
		listModel = new DefaultListModel();
		acceptedOrder_JList = new JList<String>(listModel);
		acceptedOrder_JList.setBounds(1, 50, 199, 628);
		acceptedOrder_JList.setPreferredSize(new Dimension(199, 640));
		mainWest_Panel.add(acceptedOrder_JList);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
		
		this.setVisible(true);
	}

	public JList<String> getRestaurant_JList() {
		return acceptedOrder_JList;
	}

	public void setRestaurant_JList(JList<String> restaurant_JList) {
		this.acceptedOrder_JList = restaurant_JList;
	}

	public JList<String> getMeal_JList() {
		return meal_JList;
	}

	public void setMeal_JList(JList<String> meal_JList) {
		this.meal_JList = meal_JList;
	}

	public JButton getOrderReady_Btn() {
		return orderReady_Btn;
	}

	public void setOrderReady_Btn(JButton orderReady_Btn) {
		this.orderReady_Btn = orderReady_Btn;
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

	public JFormattedTextField getPostalCode_Ftf() {
		return postalCode_Ftf;
	}

	public void setPostalCode_Ftf(JFormattedTextField postalCode_Ftf) {
		this.postalCode_Ftf = postalCode_Ftf;
	}

	public JList<String> getAcceptedOrder_JList() {
		return acceptedOrder_JList;
	}

	public void setAcceptedOrder_JList(JList<String> acceptedOrder_JList) {
		this.acceptedOrder_JList = acceptedOrder_JList;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	public DefaultListModel getListModel2() {
		return listModel2;
	}

	public void setListModel2(DefaultListModel listModel2) {
		this.listModel2 = listModel2;
	}
}

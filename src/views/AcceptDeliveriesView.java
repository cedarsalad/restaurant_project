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

public class AcceptDeliveriesView extends JFrame {

	private JPanel contentPane;
	private JLabel orderNumber_Label;
	private JLabel acceptDelivery_Label;
	private JLabel restaurantNumber_Label;
	private JLabel deliveryAddress_Label;
	private JLabel deliveryPostal_Label;
	private JButton acceptDelivery_Btn;
	private JList<String> orders_JList;
	private JLabel orders_Label;
	private DefaultListModel listModel;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceptDeliveriesView frame = new AcceptDeliveriesView();
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
	public AcceptDeliveriesView() {
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
		
		acceptDelivery_Label = new JLabel("Accept A Delivery");
		acceptDelivery_Label.setHorizontalAlignment(SwingConstants.CENTER);
		acceptDelivery_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		acceptDelivery_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(acceptDelivery_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_1.setBounds(5, 5, 640, 10);
		rigidArea_1.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_1);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_6.setBounds(5, 27, 230, 10);
		rigidArea_6.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_6);
		
		orderNumber_Label = new JLabel("Order # :");
		orderNumber_Label.setBounds(240, 20, 275, 25);
		orderNumber_Label.setPreferredSize(new Dimension(275, 25));
		orderNumber_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(orderNumber_Label);
		
		Component rigidArea = Box.createRigidArea(new Dimension(100, 5));
		rigidArea.setBounds(5, 50, 640, 10);
		rigidArea.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_7.setBounds(5, 72, 230, 10);
		rigidArea_7.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_7);
		
		restaurantNumber_Label = new JLabel("Restaurant #  :");
		restaurantNumber_Label.setBounds(240, 65, 275, 25);
		restaurantNumber_Label.setPreferredSize(new Dimension(275, 25));
		restaurantNumber_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(restaurantNumber_Label);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_2.setBounds(5, 95, 640, 10);
		rigidArea_2.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_2);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_8.setBounds(5, 117, 230, 10);
		rigidArea_8.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_8);
		
		deliveryAddress_Label = new JLabel("Delivery Address :");
		deliveryAddress_Label.setBounds(240, 110, 405, 25);
		deliveryAddress_Label.setPreferredSize(new Dimension(275, 25));
		deliveryAddress_Label.setHorizontalAlignment(SwingConstants.LEFT);
		deliveryAddress_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(deliveryAddress_Label);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_3.setBounds(5, 140, 640, 10);
		rigidArea_3.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_3);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_9.setBounds(5, 162, 230, 10);
		rigidArea_9.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_9);
		
		deliveryPostal_Label = new JLabel("Delivery Postal Code : ");
		deliveryPostal_Label.setBounds(240, 155, 275, 25);
		deliveryPostal_Label.setPreferredSize(new Dimension(275, 25));
		deliveryPostal_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(deliveryPostal_Label);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_4.setBounds(5, 185, 640, 10);
		rigidArea_4.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_5.setBounds(5, 206, 230, 10);
		rigidArea_5.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_5);
		
		acceptDelivery_Btn = new JButton("Accept Delivery");
		acceptDelivery_Btn.setBounds(240, 200, 130, 23);
		acceptDelivery_Btn.setPreferredSize(new Dimension(130, 23));
		info_Panel.add(acceptDelivery_Btn);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		mainWest_Panel.setLayout(null);
		
		orders_Label = new JLabel("Orders");
		orders_Label.setBounds(40, 5, 120, 20);
		orders_Label.setHorizontalAlignment(SwingConstants.CENTER);
		orders_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		orders_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(orders_Label);
		
		listModel = new DefaultListModel();
		orders_JList = new JList<String>(listModel);
		orders_JList.setBounds(1, 30, 199, 655);
		orders_JList.setPreferredSize(new Dimension(199, 620));
		mainWest_Panel.add(orders_JList);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
		
		this.setVisible(true);
		
	}

	public JLabel getOrderNumber_Label() {
		return orderNumber_Label;
	}

	public JList<String> getOrders_JList() {
		return orders_JList;
	}

	public void setOrders_JList(JList<String> orders_JList) {
		this.orders_JList = orders_JList;
	}

	public void setOrderNumber_Label(JLabel orderNumber_Label) {
		this.orderNumber_Label = orderNumber_Label;
	}

	public JLabel getRestaurantNumber_Label() {
		return restaurantNumber_Label;
	}

	public void setRestaurantNumber_Label(JLabel restaurantNumber_Label) {
		this.restaurantNumber_Label = restaurantNumber_Label;
	}

	public JLabel getDeliveryAddress_Label() {
		return deliveryAddress_Label;
	}

	public void setDeliveryAddress_Label(JLabel deliveryAddress_Label) {
		this.deliveryAddress_Label = deliveryAddress_Label;
	}

	public JLabel getDeliveryPostal_Label() {
		return deliveryPostal_Label;
	}

	public void setDeliveryPostal_Label(JLabel deliveryPostal_Label) {
		this.deliveryPostal_Label = deliveryPostal_Label;
	}

	public JButton getAcceptDelivery_Btn() {
		return acceptDelivery_Btn;
	}

	public void setAcceptDelivery_Btn(JButton acceptDelivery_Btn) {
		this.acceptDelivery_Btn = acceptDelivery_Btn;
	}

	public JLabel getOrders_Label() {
		return orders_Label;
	}

	public void setOrders_Label(JLabel orders_Label) {
		this.orders_Label = orders_Label;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}


}

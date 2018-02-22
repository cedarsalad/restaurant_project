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

public class DeliveryDone extends JFrame {

	private JPanel contentPane;
	private JLabel orderNumber_Label;
	private JLabel deliveryMade_Label;
	private JLabel restaurantNumber_Label;
	private JLabel deliveryAddress_Label;
	private JLabel deliveryPostal_Label;
	private JButton deliveryDone_Btn;
	private JList<String> orders_JList;
	private JLabel orders_Label;
	private JButton select_Btn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryDone frame = new DeliveryDone();
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
	public DeliveryDone() {
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
		
		deliveryMade_Label = new JLabel("Delivery Made");
		deliveryMade_Label.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryMade_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		deliveryMade_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(deliveryMade_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_1.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_1);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_6.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_6);
		
		orderNumber_Label = new JLabel("Order # : 1");
		orderNumber_Label.setPreferredSize(new Dimension(275, 25));
		orderNumber_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(orderNumber_Label);
		
		Component rigidArea = Box.createRigidArea(new Dimension(100, 5));
		rigidArea.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_7.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_7);
		
		restaurantNumber_Label = new JLabel("Restaurant #  : 1");
		restaurantNumber_Label.setPreferredSize(new Dimension(275, 25));
		restaurantNumber_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(restaurantNumber_Label);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_2.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_2);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_8.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_8);
		
		deliveryAddress_Label = new JLabel("Delivery Address : 123 Fake Street\r\n");
		deliveryAddress_Label.setPreferredSize(new Dimension(275, 25));
		deliveryAddress_Label.setHorizontalAlignment(SwingConstants.LEFT);
		deliveryAddress_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(deliveryAddress_Label);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_3.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_3);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_9.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_9);
		
		deliveryPostal_Label = new JLabel("Delivery Postal Code : 1A2 J3D\r\n");
		deliveryPostal_Label.setPreferredSize(new Dimension(275, 25));
		deliveryPostal_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(deliveryPostal_Label);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_4.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_5.setPreferredSize(new Dimension(230, 10));
		info_Panel.add(rigidArea_5);
		
		deliveryDone_Btn = new JButton("Delivery Done");
		deliveryDone_Btn.setPreferredSize(new Dimension(130, 23));
		info_Panel.add(deliveryDone_Btn);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		
		orders_Label = new JLabel("Orders");
		orders_Label.setHorizontalAlignment(SwingConstants.CENTER);
		orders_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		orders_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(orders_Label);
		
		orders_JList = new JList<String>();
		orders_JList.setPreferredSize(new Dimension(199, 640));
		mainWest_Panel.add(orders_JList);
		
		select_Btn = new JButton("Select");
		select_Btn.setPreferredSize(new Dimension(195, 23));
		mainWest_Panel.add(select_Btn);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
	}

	public JLabel getOrderNumber_Label() {
		return orderNumber_Label;
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

	public JList<String> getOrders_JList() {
		return orders_JList;
	}

	public void setOrders_JList(JList<String> orders_JList) {
		this.orders_JList = orders_JList;
	}

	public JLabel getOrders_Label() {
		return orders_Label;
	}

	public void setOrders_Label(JLabel orders_Label) {
		this.orders_Label = orders_Label;
	}

	public JButton getSelect_Btn() {
		return select_Btn;
	}

	public void setSelect_Btn(JButton select_Btn) {
		this.select_Btn = select_Btn;
	}

}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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

public class AcceptOrderView extends JFrame {

	private JPanel contentPane;
	private JLabel acceptingOrder_Label;
	private JList<String> pendingOrder_JList;
	private JLabel pendingOrder_Label;
	private JList<String> meal_JList;
	private JButton acceptOrder_Btn;
	private JFormattedTextField deliveryTime_Ftf;
	private JFormattedTextField time_Ftf;
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
					AcceptOrderView frame = new AcceptOrderView();
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
	public AcceptOrderView() {
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
		
		acceptingOrder_Label = new JLabel("Accepting Order");
		acceptingOrder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		acceptingOrder_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		acceptingOrder_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(acceptingOrder_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		listModel2 = new DefaultListModel();
		
		meal_JList = new JList<String>(listModel2);
		meal_JList.setEnabled(false);
		meal_JList.setBounds(123, 159, 363, 299);
		info_Panel.add(meal_JList);
		
		acceptOrder_Btn = new JButton("Accept Order");
		acceptOrder_Btn.setBounds(250, 469, 118, 23);
		info_Panel.add(acceptOrder_Btn);
		
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
		
		time_Ftf = new JFormattedTextField();
		time_Ftf.setEnabled(false);
		time_Ftf.setBounds(355, 48, 131, 23);
		info_Panel.add(time_Ftf);
		
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
		
		pendingOrder_Label = new JLabel("Pending Order");
		pendingOrder_Label.setBounds(21, 11, 153, 28);
		pendingOrder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		pendingOrder_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		pendingOrder_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(pendingOrder_Label);
		
		listModel = new DefaultListModel();
		
		pendingOrder_JList = new JList<String>(listModel);
		pendingOrder_JList.setBounds(1, 50, 199, 635);
		pendingOrder_JList.setPreferredSize(new Dimension(199, 600));
		mainWest_Panel.add(pendingOrder_JList);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
		
		this.setVisible(true);
	}

	public JList<String> getRestaurant_JList() {
		return pendingOrder_JList;
	}

	public void setRestaurant_JList(JList<String> restaurant_JList) {
		this.pendingOrder_JList = restaurant_JList;
	}

	public JList<String> getMeal_JList() {
		return meal_JList;
	}

	public void setMeal_JList(JList<String> meal_JList) {
		this.meal_JList = meal_JList;
	}

	public JButton getAcceptOrder_Btn() {
		return acceptOrder_Btn;
	}

	public void setAcceptOrder_Btn(JButton acceptOrder_Btn) {
		this.acceptOrder_Btn = acceptOrder_Btn;
	}

	public JFormattedTextField getDeliveryTime_Ftf() {
		return deliveryTime_Ftf;
	}

	public void setDeliveryTime_Ftf(JFormattedTextField deliveryTime_Ftf) {
		this.deliveryTime_Ftf = deliveryTime_Ftf;
	}

	public JFormattedTextField getHour_Ftf() {
		return time_Ftf;
	}

	public void setHour_Ftf(JFormattedTextField hour_Ftf) {
		this.time_Ftf = hour_Ftf;
	}

	public JFormattedTextField getPostalCode_Ftf() {
		return postalCode_Ftf;
	}

	public void setPostalCode_Ftf(JFormattedTextField postalCode_Ftf) {
		this.postalCode_Ftf = postalCode_Ftf;
	}

	public JList<String> getPendingOrder_JList() {
		return pendingOrder_JList;
	}

	public void setPendingOrder_JList(JList<String> pendingOrder_JList) {
		this.pendingOrder_JList = pendingOrder_JList;
	}

	public JFormattedTextField getTime_Ftf() {
		return time_Ftf;
	}

	public void setTime_Ftf(JFormattedTextField time_Ftf) {
		this.time_Ftf = time_Ftf;
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

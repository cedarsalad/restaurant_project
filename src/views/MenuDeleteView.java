package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.RestaurantModel;

import java.awt.Dimension;
import javax.swing.JToolBar;
import javax.swing.ListModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JList;

public class MenuDeleteView extends JFrame implements Observer {
	
	static JFrame frame;
	static JPanel contentPane;
	static JLabel deleteMenu_Label;
	static JList<String> restaurant_JList;
	static JList menuList_JList;
	static JLabel restaurant_Label;
	static JButton select_Btn;
	static JButton deleteMenu_Btn;
	private RestaurantModel model;
	private DefaultListModel listModel;
	
	public MenuDeleteView(RestaurantModel model) {
		
		this.model = model;
		frame = this;
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 875, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		JPanel mainNorth_Panel = new JPanel();
		mainNorth_Panel.setForeground(Color.BLACK);
		mainNorth_Panel.setPreferredSize(new Dimension(10, 25));
		contentPane.add(mainNorth_Panel, BorderLayout.NORTH);
		mainNorth_Panel.setLayout(new BorderLayout(0, 0));
		
		/*JMenuBar MenuBar = new JMenuBar();
		MenuBar.setForeground(Color.BLACK);
		mainNorth_Panel.add(MenuBar, BorderLayout.NORTH);
		
		JMenu file_JMenu = new JMenu("File");
		MenuBar.add(file_JMenu);*/
		
		/*JMenu restaurant_JMenu = new JMenu("Restaurant");
		MenuBar.add(restaurant_JMenu);*/
		
		/*JMenu menu = new JMenu("File");
		MenuBar.add(menu);*/
		
		/*JMenu deliveryMan_JMenu = new JMenu("Delivery Man");
		MenuBar.add(deliveryMan_JMenu);*/
		
		JPanel mainCenter_Panel = new JPanel();
		contentPane.add(mainCenter_Panel, BorderLayout.CENTER);
		mainCenter_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerNorth_Panel = new JPanel();
		centerNorth_Panel.setPreferredSize(new Dimension(10, 50));
		mainCenter_Panel.add(centerNorth_Panel, BorderLayout.NORTH);
		
		deleteMenu_Label = new JLabel("Delete Menu");
		deleteMenu_Label.setHorizontalAlignment(SwingConstants.CENTER);
		deleteMenu_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		deleteMenu_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(deleteMenu_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		menuList_JList = new JList();
		menuList_JList.setEnabled(false);
		menuList_JList.setBounds(186, 0, 284, 515);
		info_Panel.add(menuList_JList);
		
		deleteMenu_Btn = new JButton("Delete Menu");
		deleteMenu_Btn.setBounds(271, 526, 124, 23);
		info_Panel.add(deleteMenu_Btn);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		mainWest_Panel.setLayout(null);
		
		restaurant_Label = new JLabel("Restaurant");
		restaurant_Label.setBounds(26, 11, 147, 28);
		restaurant_Label.setHorizontalAlignment(SwingConstants.CENTER);
		restaurant_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		restaurant_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(restaurant_Label);
		
		restaurant_JList = new JList();
		restaurant_JList.setBounds(1, 50, 197, 620);
		restaurant_JList.setPreferredSize(new Dimension(199, 640));
		mainWest_Panel.add(restaurant_JList);
		
		select_Btn = new JButton("Select");
		select_Btn.setBounds(3, 675, 195, 23);
		select_Btn.setPreferredSize(new Dimension(195, 23));
		mainWest_Panel.add(select_Btn);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
		
		frame.setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public JLabel getDeleteMenu_Label() {
		return deleteMenu_Label;
	}

	public void setDeleteMenu_Label(JLabel deleteMenu_Label) {
		this.deleteMenu_Label = deleteMenu_Label;
	}

	public JList<String> getRestaurant_JList() {
		return restaurant_JList;
	}

	public void setRestaurant_JList(JList<String> restaurant_JList) {
		this.restaurant_JList = restaurant_JList;
	}

	public JLabel getRestaurant_Label() {
		return restaurant_Label;
	}

	public void setRestaurant_Label(JLabel restaurant_Label) {
		this.restaurant_Label = restaurant_Label;
	}

	public JButton getSelect_Btn() {
		return select_Btn;
	}

	public void setSelect_Btn(JButton select_Btn) {
		this.select_Btn = select_Btn;
	}

	public static JButton getDeleteMenu_Btn() {
		return deleteMenu_Btn;
	}

	public static void setDeleteMenu_Btn(JButton deleteMenu_Btn) {
		MenuDeleteView.deleteMenu_Btn = deleteMenu_Btn;
	}

	public static JList getMenuList_JList() {
		return menuList_JList;
	}

	public static void setMenuList_JList(JList menuList_JList) {
		MenuDeleteView.menuList_JList = menuList_JList;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o == this.model) {
			this.listModel = new DefaultListModel();
			this.restaurant_JList.setModel(listModel);
			for (Object name : this.model.getRestaurantNames()) {
				listModel.addElement(name);

			}

		}
	}
	
	
}

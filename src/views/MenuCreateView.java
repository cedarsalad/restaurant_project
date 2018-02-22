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
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JList;

public class MenuCreateView extends JFrame implements Observer {

	private RestaurantModel model;
	static JFrame frame;
	static JPanel contentPane;
	static JLabel editMenu_Label;
	static JList<String> restaurant_JList;
	static JLabel restaurant_Label;
	static JButton select_Btn;
	static JButton addItem_Btn;
	static JButton editItem_Btn;
	static JButton deleteItem_Btn;
	static JButton editMenu_Btn;
	static JFormattedTextField item_Ftf;
	static JFormattedTextField price_Ftf;
	
	
	private DefaultListModel listModel;
	private JList menuList_JList;

	public MenuCreateView(RestaurantModel model) {

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

		/*
		 * JMenuBar MenuBar = new JMenuBar();
		 * MenuBar.setForeground(Color.BLACK); mainNorth_Panel.add(MenuBar,
		 * BorderLayout.NORTH);
		 * 
		 * JMenu file_JMenu = new JMenu("File"); MenuBar.add(file_JMenu);
		 */

		/*
		 * JMenu restaurant_JMenu = new JMenu("Restaurant");
		 * MenuBar.add(restaurant_JMenu);
		 */

		/*
		 * JMenu menu = new JMenu("File"); MenuBar.add(menu);
		 */

		/*
		 * JMenu deliveryMan_JMenu = new JMenu("Delivery Man");
		 * MenuBar.add(deliveryMan_JMenu);
		 */

		JPanel mainCenter_Panel = new JPanel();
		contentPane.add(mainCenter_Panel, BorderLayout.CENTER);
		mainCenter_Panel.setLayout(new BorderLayout(0, 0));

		JPanel centerNorth_Panel = new JPanel();
		centerNorth_Panel.setPreferredSize(new Dimension(10, 50));
		mainCenter_Panel.add(centerNorth_Panel, BorderLayout.NORTH);

		editMenu_Label = new JLabel("Edit Menu");
		editMenu_Label.setHorizontalAlignment(SwingConstants.CENTER);
		editMenu_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		editMenu_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(editMenu_Label);

		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);

		menuList_JList = new JList();
		menuList_JList.setBounds(186, 0, 284, 411);
		info_Panel.add(menuList_JList);

		editMenu_Btn = new JButton("Edit Menu");
		editMenu_Btn.setBounds(285, 422, 89, 23);
		info_Panel.add(editMenu_Btn);

		JLabel editItem_Label = new JLabel("Edit Item");
		editItem_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		editItem_Label.setHorizontalAlignment(SwingConstants.CENTER);
		editItem_Label.setBounds(285, 454, 89, 23);
		info_Panel.add(editItem_Label);

		JLabel item_Label = new JLabel("Item:");
		item_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		item_Label.setBounds(186, 484, 46, 14);
		info_Panel.add(item_Label);

		JLabel price_Label = new JLabel("Price:");
		price_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		price_Label.setBounds(186, 519, 46, 14);
		info_Panel.add(price_Label);

		item_Ftf = new JFormattedTextField();
		item_Ftf.setBounds(242, 484, 228, 23);
		info_Panel.add(item_Ftf);
		
		price_Ftf = new JFormattedTextField();
		price_Ftf.setBounds(242, 518, 228, 23);
		info_Panel.add(price_Ftf);

		addItem_Btn = new JButton("Add Item");
		addItem_Btn.setBounds(186, 552, 89, 23);
		info_Panel.add(addItem_Btn);

		editItem_Btn = new JButton("Edit Item");
		editItem_Btn.setBounds(285, 552, 89, 23);
		info_Panel.add(editItem_Btn);

		deleteItem_Btn = new JButton("Delete Item");
		deleteItem_Btn.setBounds(384, 552, 89, 23);
		info_Panel.add(deleteItem_Btn);

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

		restaurant_JList = new JList();
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

		frame.setVisible(true);
	}

	public RestaurantModel getModel() {
		return model;
	}

	public void setModel(RestaurantModel model) {
		this.model = model;
	}

	public DefaultListModel getTblmodel() {
		return listModel;
	}

	public void setTblmodel(DefaultListModel tblmodel) {
		this.listModel = tblmodel;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		MenuCreateView.frame = frame;
	}

	public static void setContentPane(JPanel contentPane) {
		MenuCreateView.contentPane = contentPane;
	}

	public static JLabel getEditMenu_Label() {
		return editMenu_Label;
	}

	public static void setEditMenu_Label(JLabel editMenu_Label) {
		MenuCreateView.editMenu_Label = editMenu_Label;
	}

	public static JList<String> getRestaurant_JList() {
		return restaurant_JList;
	}

	public static void setRestaurant_JList(JList<String> restaurant_JList) {
		MenuCreateView.restaurant_JList = restaurant_JList;
	}

	public static JLabel getRestaurant_Label() {
		return restaurant_Label;
	}

	public static void setRestaurant_Label(JLabel restaurant_Label) {
		MenuCreateView.restaurant_Label = restaurant_Label;
	}

	public static JButton getEditMenu_Btn() {
		return editMenu_Btn;
	}

	public static void setEditMenu_Btn(JButton editMenu_Btn) {
		MenuCreateView.editMenu_Btn = editMenu_Btn;
	}

	public static JButton getSelect_Btn() {
		return select_Btn;
	}

	public static void setSelect_Btn(JButton select_Btn) {
		MenuCreateView.select_Btn = select_Btn;
	}

	public static JButton getAddItem_Btn() {
		return addItem_Btn;
	}

	public static void setAddItem_Btn(JButton addItem_Btn) {
		MenuCreateView.addItem_Btn = addItem_Btn;
	}

	public static JButton getEditItem_Btn() {
		return editItem_Btn;
	}

	public static void setEditItem_Btn(JButton editItem_Btn) {
		MenuCreateView.editItem_Btn = editItem_Btn;
	}

	public static JButton getDeleteItem_Btn() {
		return deleteItem_Btn;
	}

	public static void setDeleteItem_Btn(JButton deleteItem_Btn) {
		MenuCreateView.deleteItem_Btn = deleteItem_Btn;
	}

	public static JFormattedTextField getItem_Ftf() {
		return item_Ftf;
	}

	public static void setItem_Ftf(JFormattedTextField item_Ftf) {
		MenuCreateView.item_Ftf = item_Ftf;
	}

	public static JFormattedTextField getPrice_Ftf() {
		return price_Ftf;
	}

	public static void setPrice_Ftf(JFormattedTextField price_Ftf) {
		MenuCreateView.price_Ftf = price_Ftf;
	}

	public JList getMenuList_JList() {
		return menuList_JList;
	}

	public void setMenuList_JList(JList menuList_JList) {
		this.menuList_JList = menuList_JList;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
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

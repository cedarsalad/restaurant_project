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

public class EditMenu extends JFrame {

	private JPanel contentPane;
	private JLabel editMenu_Label;
	private JList<String> restaurant_JList;
	private JLabel restaurant_Label;
	private JButton select_Btn;
	private JList<String> menuList_JList;
	private JButton editMenu_Btn;
	private JFormattedTextField item_Ftf;
	private JFormattedTextField price_Ftf;
	private JButton addItem_Btn;
	private JButton editItem_Btn;
	private JButton deleteItem_Btn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMenu frame = new EditMenu();
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
	public EditMenu() {
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
		
		editMenu_Label = new JLabel("Edit Menu");
		editMenu_Label.setHorizontalAlignment(SwingConstants.CENTER);
		editMenu_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		editMenu_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(editMenu_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		menuList_JList = new JList<String>();
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

	public JList<String> getMenuList_JList() {
		return menuList_JList;
	}

	public void setMenuList_JList(JList<String> menuList_JList) {
		this.menuList_JList = menuList_JList;
	}

	public JButton getEditMenu_Btn() {
		return editMenu_Btn;
	}

	public void setEditMenu_Btn(JButton editMenu_Btn) {
		this.editMenu_Btn = editMenu_Btn;
	}

	public JFormattedTextField getItem_Ftf() {
		return item_Ftf;
	}

	public void setItem_Ftf(JFormattedTextField item_Ftf) {
		this.item_Ftf = item_Ftf;
	}

	public JFormattedTextField getPrice_Ftf() {
		return price_Ftf;
	}

	public void setPrice_Ftf(JFormattedTextField price_Ftf) {
		this.price_Ftf = price_Ftf;
	}

	public JButton getAddItem_Btn() {
		return addItem_Btn;
	}

	public void setAddItem_Btn(JButton addItem_Btn) {
		this.addItem_Btn = addItem_Btn;
	}

	public JButton getEditItem_Btn() {
		return editItem_Btn;
	}

	public void setEditItem_Btn(JButton editItem_Btn) {
		this.editItem_Btn = editItem_Btn;
	}

	public JButton getDeleteItem_Btn() {
		return deleteItem_Btn;
	}

	public void setDeleteItem_Btn(JButton deleteItem_Btn) {
		this.deleteItem_Btn = deleteItem_Btn;
	}
}

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

public class DeleteMenu extends JFrame {

	private JPanel contentPane;
	private JLabel deleteMenu_Label;
	private JList<String> restaurant_JList;
	private JLabel restaurant_Label;
	private JButton select_Btn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteMenu frame = new DeleteMenu();
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
	public DeleteMenu() {
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
		
		JList menuList_JList = new JList();
		menuList_JList.setEnabled(false);
		menuList_JList.setBounds(186, 0, 284, 515);
		info_Panel.add(menuList_JList);
		
		JButton deleteMenu_Btn = new JButton("Delete Menu");
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
}

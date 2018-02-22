package views;

import models.RestaurantModel;
import custom_controls.MenuBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class RestaurantMainView extends JFrame implements Observer {

	private RestaurantModel model;
	private JFrame frame;
	private JTable table;
	
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnTemp;
	private JButton btnAddMenu;
	private JButton btnDeleteMenu;
	private JButton btnDeliveryMan;
	private JButton btnClients;
	private JButton btnOrder;
	
	private JMenuBar menuBar;
	
	private DefaultTableModel tblmodel;

	public RestaurantMainView(RestaurantModel model) {

		this.model = model;
		frame = this;
		frame.setBounds(100, 100, 875, 875);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 600));
		panel.add(scrollPane);

		btnAdd = new JButton("Add New Restaurant");
		panel.add(btnAdd);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDelete = new JButton("Delete Restaurant");
		panel.add(btnDelete);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Testing start
		btnTemp = new JButton("Generate Values *Testing");
		panel.add(btnTemp);
		btnTemp.setForeground(Color.WHITE);
		btnTemp.setBackground(Color.DARK_GRAY);
		btnTemp.setFont(new Font("Tahoma", Font.BOLD, 14));
		// Testing end
		
		// Testing start
		btnAddMenu = new JButton("temporary - create menu");
		panel.add(btnAddMenu);
		btnAddMenu.setForeground(Color.WHITE);
		btnAddMenu.setBackground(Color.DARK_GRAY);
		btnAddMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		// Testing end
		
		// Testing start
		btnDeleteMenu = new JButton("temporary - Delete menu");
		panel.add(btnDeleteMenu);
		btnDeleteMenu.setForeground(Color.WHITE);
		btnDeleteMenu.setBackground(Color.DARK_GRAY);
		btnDeleteMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		// Testing end

		// Testing start
		btnDeliveryMan = new JButton("Delivery man");
		panel.add(btnDeliveryMan);
		btnDeliveryMan.setForeground(Color.WHITE);
		btnDeliveryMan.setBackground(Color.DARK_GRAY);
		btnDeliveryMan.setFont(new Font("Tahoma", Font.BOLD, 14));
		// Testing en
		
		this.setVisible(true);

	}

	public RestaurantModel getModel() {
		return model;
	}

	public void setModel(RestaurantModel model) {
		this.model = model;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnTemp() {
		return btnTemp;
	}


	public void setBtnTemp(JButton btnTemp) {
		this.btnTemp = btnTemp;
	}


	public JButton getBtnAddMenu() {
		return btnAddMenu;
	}

	public void setBtnAddMenu(JButton btnAddMenu) {
		this.btnAddMenu = btnAddMenu;
	}

	public JButton getBtnDeleteMenu() {
		return btnDeleteMenu;
	}
	
	public void setBtnDeleteMenu(JButton btnDeleteMenu) {
		this.btnDeleteMenu = btnDeleteMenu;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public DefaultTableModel getTblmodel() {
		return tblmodel;
	}

	public void setTblmodel(DefaultTableModel tblmodel) {
		this.tblmodel = tblmodel;
	}

	public JButton getBtnDeliveryMan() {
		return btnDeliveryMan;
	}

	public void setBtnDeliveryMan(JButton btnDeliveryMan) {
		this.btnDeliveryMan = btnDeliveryMan;
	}

	public JButton getBtnClients() {
		return btnClients;
	}

	public void setBtnClients(JButton btnClients) {
		this.btnClients = btnClients;
	}

	public JButton getBtnOrder() {
		return btnOrder;
	}

	public void setBtnOrder(JButton btnOrder) {
		this.btnOrder = btnOrder;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == this.model) {
			this.tblmodel = new DefaultTableModel(this.model.getData(), this.model.getColumns());
			this.table.setModel(tblmodel);
		}
	}

}

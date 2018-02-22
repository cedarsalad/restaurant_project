package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import models.DeliveryManModel;
import models.RestaurantBean;
import models.RestaurantModel;

public class DeliveryManMainView  extends JFrame implements Observer {

	private DeliveryManModel model;
	private JFrame frame;
	private JTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnTemp;
	private JButton btnAddMenu;
	private JMenuBar menuBar;
	private JMenu menuMenu;
	
	private DefaultTableModel tblmodel;
	
	public DeliveryManMainView(DeliveryManModel model) {

		this.model = model;
		frame = this;
		frame.setBounds(100, 100, 875, 875);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

//		JMenuBar menuBar = new JmenuBar();
//		frame.revalidate();
//		frame.getContentPane().add(menuBar);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 600));
		panel.add(scrollPane);

		btnAdd = new JButton("Add New Delivery Man");
		panel.add(btnAdd);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnDelete = new JButton("Delete Delivery Man");
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
		btnAddMenu = new JButton("Back to Restaurants");
		panel.add(btnAddMenu);
		btnAddMenu.setForeground(Color.WHITE);
		btnAddMenu.setBackground(Color.DARK_GRAY);
		btnAddMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		// Testing end

		this.setVisible(true);

	}

	public DeliveryManModel getModel() {
		return model;
	}

	public void setModel(DeliveryManModel model) {
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

	
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMenuMenu() {
		return menuMenu;
	}

	public void setMenuMenu(JMenu menuMenu) {
		this.menuMenu = menuMenu;
	}

	public DefaultTableModel getTblmodel() {
		return tblmodel;
	}

	public void setTblmodel(DefaultTableModel tblmodel) {
		this.tblmodel = tblmodel;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o == this.model) {
			this.tblmodel = new DefaultTableModel(this.model.getData(), this.model.getColumns());
			this.table.setModel(tblmodel);
		}
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DeleteDeliveryManView extends JFrame {

	private JPanel contentPane;
	
	private JFormattedTextField name_ftf;
	private JFormattedTextField telephone_ftf;
	private JFormattedTextField area_ftf;
	private JFormattedTextField area2_ftf;
	private JButton addNewArea_Btn;
	private JButton deleteDeliveryArea_Btn;
	private JButton delete_Btn;
	private JList<String> deliveryManList_JList;
	private JButton select_Btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDeliveryManView frame = new DeleteDeliveryManView();
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
	public DeleteDeliveryManView() {
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
		
		JLabel deleteDeliveryMan_Label = new JLabel("Delete Delivery Man");
		deleteDeliveryMan_Label.setHorizontalAlignment(SwingConstants.CENTER);
		deleteDeliveryMan_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		deleteDeliveryMan_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(deleteDeliveryMan_Label);
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_1.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_1);
		
		JLabel name_Label = new JLabel("Name:");
		name_Label.setPreferredSize(new Dimension(275, 25));
		name_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(name_Label);
		
		name_ftf = new JFormattedTextField();
		name_ftf.setEditable(false);
		name_ftf.setPreferredSize(new Dimension(350, 20));
		info_Panel.add(name_ftf);
		
		Component rigidArea = Box.createRigidArea(new Dimension(100, 5));
		rigidArea.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea);
		
		JLabel telephone_Label = new JLabel("Telephone Number:");
		telephone_Label.setPreferredSize(new Dimension(275, 25));
		telephone_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(telephone_Label);
		
		telephone_ftf = new JFormattedTextField();
		telephone_ftf.setEditable(false);
		telephone_ftf.setPreferredSize(new Dimension(350, 20));
		info_Panel.add(telephone_ftf);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_2.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_2);
		
		JLabel deliveryArea_Label = new JLabel("Delivery Area");
		deliveryArea_Label.setPreferredSize(new Dimension(640, 40));
		deliveryArea_Label.setHorizontalAlignment(SwingConstants.CENTER);
		deliveryArea_Label.setFont(new Font("Tahoma", Font.BOLD, 20));
		info_Panel.add(deliveryArea_Label);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_3.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_3);
		
		area_ftf = new JFormattedTextField();
		area_ftf.setEditable(false);
		area_ftf.setPreferredSize(new Dimension(640, 100));
		info_Panel.add(area_ftf);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_4.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea_4);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_5.setPreferredSize(new Dimension(90, 10));
		info_Panel.add(rigidArea_5);
		
		JLabel deliveryArea2_Label = new JLabel("Delivery Area:");
		deliveryArea2_Label.setPreferredSize(new Dimension(115, 20));
		deliveryArea2_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(deliveryArea2_Label);
		
		area2_ftf = new JFormattedTextField();
		area2_ftf.setEditable(false);
		area2_ftf.setPreferredSize(new Dimension(75, 20));
		info_Panel.add(area2_ftf);
		
		addNewArea_Btn = new JButton("Add Delivery Area");
		addNewArea_Btn.setEnabled(false);
		addNewArea_Btn.setPreferredSize(new Dimension(250, 23));
		info_Panel.add(addNewArea_Btn);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_6.setPreferredSize(new Dimension(90, 10));
		info_Panel.add(rigidArea_6);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_7.setPreferredSize(new Dimension(190, 10));
		info_Panel.add(rigidArea_7);
		
		deleteDeliveryArea_Btn = new JButton("Delete Delivery Area");
		deleteDeliveryArea_Btn.setEnabled(false);
		deleteDeliveryArea_Btn.setPreferredSize(new Dimension(250, 23));
		info_Panel.add(deleteDeliveryArea_Btn);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_8.setPreferredSize(new Dimension(190, 10));
		info_Panel.add(rigidArea_8);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_9.setPreferredSize(new Dimension(268, 10));
		info_Panel.add(rigidArea_9);
		
		delete_Btn = new JButton("Delete");
		delete_Btn.setPreferredSize(new Dimension(100, 23));
		info_Panel.add(delete_Btn);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		
		JLabel deliveryMan_Label = new JLabel("Delivery Man");
		deliveryMan_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		deliveryMan_Label.setPreferredSize(new Dimension(120, 20));
		mainWest_Panel.add(deliveryMan_Label);
		
		deliveryManList_JList = new JList();
		deliveryManList_JList.setPreferredSize(new Dimension(199, 640));
		mainWest_Panel.add(deliveryManList_JList);
		
		select_Btn = new JButton("Select");
		select_Btn.setPreferredSize(new Dimension(195, 23));
		mainWest_Panel.add(select_Btn);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
	}
	
	public JFormattedTextField getName_ftf() {
		return name_ftf;
	}

	public void setName_ftf(JFormattedTextField name_ftf) {
		this.name_ftf = name_ftf;
	}

	public JFormattedTextField getTelephone_ftf() {
		return telephone_ftf;
	}

	public void setTelephone_ftf(JFormattedTextField telephone_ftf) {
		this.telephone_ftf = telephone_ftf;
	}

	public JFormattedTextField getArea_ftf() {
		return area_ftf;
	}

	public void setArea_ftf(JFormattedTextField area_ftf) {
		this.area_ftf = area_ftf;
	}

	public JFormattedTextField getArea2_ftf() {
		return area2_ftf;
	}

	public void setArea2_ftf(JFormattedTextField area2_ftf) {
		this.area2_ftf = area2_ftf;
	}

	public JButton getAddNewArea_Btn() {
		return addNewArea_Btn;
	}

	public void setAddNewArea_Btn(JButton addNewArea_Btn) {
		this.addNewArea_Btn = addNewArea_Btn;
	}

	public JButton getDeleteDeliveryArea_Btn() {
		return deleteDeliveryArea_Btn;
	}

	public void setDeleteDeliveryArea_Btn(JButton deleteDeliveryArea_Btn) {
		this.deleteDeliveryArea_Btn = deleteDeliveryArea_Btn;
	}

	public JButton getDelete_Btn() {
		return delete_Btn;
	}

	public void setDelete_Btn(JButton delete_Btn) {
		this.delete_Btn = delete_Btn;
	}

	public JList<String> getDeliveryManList_JList() {
		return deliveryManList_JList;
	}

	public void setDeliveryManList_JList(JList<String> deliveryManList_JList) {
		this.deliveryManList_JList = deliveryManList_JList;
	}

	public JButton getSelect_Btn() {
		return select_Btn;
	}

	public void setSelect_Btn(JButton select_Btn) {
		this.select_Btn = select_Btn;
	}



}

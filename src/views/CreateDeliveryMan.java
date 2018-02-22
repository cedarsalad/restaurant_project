package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
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

public class CreateDeliveryMan extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField name_ftf;
	private JFormattedTextField telephone_ftf;
	private	JFormattedTextField area_ftf;
	private JFormattedTextField area2_ftf;
	private JButton addNewArea_Btn;
	private JButton deleteDeliveryArea_Btn;
	private JButton save_Btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDeliveryMan frame = new CreateDeliveryMan();
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
	public CreateDeliveryMan() {
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
		
		JLabel createNewDeliveryMan_Label = new JLabel("Create New Delivery Man");
		createNewDeliveryMan_Label.setHorizontalAlignment(SwingConstants.CENTER);
		createNewDeliveryMan_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		createNewDeliveryMan_Label.setPreferredSize(new Dimension(600, 40));
		centerNorth_Panel.add(createNewDeliveryMan_Label);
		
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
		name_ftf.setPreferredSize(new Dimension(350, 20));
		info_Panel.add(name_ftf);
		
		Component rigidArea = Box.createRigidArea(new Dimension(100, 5));
		rigidArea.setPreferredSize(new Dimension(640, 10));
		info_Panel.add(rigidArea);
		
		JLabel telephone_Label = new JLabel("Telephone Number:");
		telephone_Label.setPreferredSize(new Dimension(275, 25));
		telephone_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		info_Panel.add(telephone_Label);
		
		//Telephone Field
		try {
			MaskFormatter phoneNumberMask = new MaskFormatter("(###) -###-####");
			telephone_ftf = new JFormattedTextField(phoneNumberMask);
		} catch (Exception e) {
			System.out.println("phoneNumberMask");
		}
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
		
		try {
			MaskFormatter areaMask = new MaskFormatter("?#?");
			area2_ftf = new JFormattedTextField(areaMask);
		} catch (Exception e) {
			System.out.println("areaMask");
		}
		area2_ftf.setPreferredSize(new Dimension(75, 20));
		info_Panel.add(area2_ftf);
		
		addNewArea_Btn = new JButton("Add Delivery Area");
		addNewArea_Btn.setPreferredSize(new Dimension(250, 23));
		info_Panel.add(addNewArea_Btn);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_6.setPreferredSize(new Dimension(90, 10));
		info_Panel.add(rigidArea_6);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_7.setPreferredSize(new Dimension(190, 10));
		info_Panel.add(rigidArea_7);
		
		deleteDeliveryArea_Btn = new JButton("Delete Delivery Area");
		deleteDeliveryArea_Btn.setPreferredSize(new Dimension(250, 23));
		info_Panel.add(deleteDeliveryArea_Btn);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_8.setPreferredSize(new Dimension(190, 10));
		info_Panel.add(rigidArea_8);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(100, 5));
		rigidArea_9.setPreferredSize(new Dimension(268, 10));
		info_Panel.add(rigidArea_9);
		
		save_Btn = new JButton("Save");
		save_Btn.setPreferredSize(new Dimension(100, 23));
		info_Panel.add(save_Btn);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(100, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(100, 10));
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

	public JButton getSave_Btn() {
		return save_Btn;
	}

	public void setSave_Btn(JButton save_Btn) {
		this.save_Btn = save_Btn;
	}

}

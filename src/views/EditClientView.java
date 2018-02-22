package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class EditClientView {

	private JFrame frame;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JPasswordField tfConfirm;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JFormattedTextField ftfPhone;
	private JTextField tfOldPassword;
	private JButton btnSave;
	private JButton btnReturn;
	private JButton btnQuit;
	
	/**
	 * Create the application.
	 */
	public EditClientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("Edit Account Info");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		frame.getContentPane().add(lblTitle, BorderLayout.NORTH);
		
		JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, BorderLayout.CENTER);
		panelLogin.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(235, 46, 86, 14);
		panelLogin.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(370, 43, 156, 27);
		panelLogin.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(370, 154, 156, 27);
		panelLogin.add(tfPassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewPassword.setBounds(198, 157, 123, 14);
		panelLogin.add(lblNewPassword);
		
		tfConfirm = new JPasswordField();
		tfConfirm.setColumns(10);
		tfConfirm.setBounds(370, 211, 156, 27);
		panelLogin.add(tfConfirm);
		
		JLabel lblConfirm = new JLabel("Confirm Password:");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirm.setBounds(168, 214, 153, 14);
		panelLogin.add(lblConfirm);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(370, 265, 156, 27);
		panelLogin.add(tfFirstName);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(370, 321, 156, 27);
		panelLogin.add(tfLastName);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(370, 376, 156, 27);
		panelLogin.add(tfAddress);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(370, 428, 156, 27);
		panelLogin.add(tfEmail);

		try {
			MaskFormatter phoneMask = new MaskFormatter("(###)-###-####");
			ftfPhone = new JFormattedTextField(phoneMask);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ftfPhone.setBounds(370, 481, 156, 27);
		panelLogin.add(ftfPhone);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(232, 324, 89, 14);
		panelLogin.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(231, 268, 90, 14);
		panelLogin.add(lblFirstName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(251, 379, 70, 14);
		panelLogin.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(273, 431, 48, 14);
		panelLogin.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(198, 484, 123, 14);
		panelLogin.add(lblPhoneNumber);
		
		tfOldPassword = new JTextField();
		tfOldPassword.setColumns(10);
		tfOldPassword.setBounds(370, 97, 156, 27);
		panelLogin.add(tfOldPassword);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOldPassword.setBounds(208, 100, 113, 14);
		panelLogin.add(lblOldPassword);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnSave = new JButton("Save");
		panel.add(btnSave);
		
		btnReturn = new JButton("Return");
		panel.add(btnReturn);
		
		btnQuit = new JButton("Quit");
		panel.add(btnQuit);
		
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(JPasswordField tfPassword) {
		this.tfPassword = tfPassword;
	}

	public JTextField getTfConfirm() {
		return tfConfirm;
	}

	public void setTfConfirm(JPasswordField tfConfirm) {
		this.tfConfirm = tfConfirm;
	}

	public JTextField getTfFirstName() {
		return tfFirstName;
	}

	public void setTfFirstName(JTextField tfFirstName) {
		this.tfFirstName = tfFirstName;
	}

	public JTextField getTfLastName() {
		return tfLastName;
	}

	public void setTfLastName(JTextField tfLastName) {
		this.tfLastName = tfLastName;
	}

	public JTextField getTfAddress() {
		return tfAddress;
	}

	public void setTfAddress(JTextField tfAddress) {
		this.tfAddress = tfAddress;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JFormattedTextField getFtfPhone() {
		return ftfPhone;
	}

	public void setFtfPhone(JFormattedTextField ftfPhone) {
		this.ftfPhone = ftfPhone;
	}

	public JTextField getTfOldPassword() {
		return tfOldPassword;
	}

	public void setTfOldPassword(JTextField tfOldPassword) {
		this.tfOldPassword = tfOldPassword;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnReturn() {
		return btnReturn;
	}

	public void setBtnReturn(JButton btnReturn) {
		this.btnReturn = btnReturn;
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}
}

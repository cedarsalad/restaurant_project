package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView {

	private JFrame frame;
	private JTextField tfUsername;
	private JPasswordField tfPassword;
	private JButton btnConnect;
	private JButton btnNewClient;
	private JButton btnQuit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 602, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblTitle = new JLabel("");
        ImageIcon image = new ImageIcon(getClass().getResource("logo_official.png"));
        lblTitle.setIcon(image);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		frame.getContentPane().add(lblTitle, BorderLayout.NORTH);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		frame.getContentPane().add(panelLogin, BorderLayout.CENTER);
		panelLogin.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(184, 100, 86, 14);
		panelLogin.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(304, 97, 156, 27);
		panelLogin.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(304, 154, 156, 27);
		panelLogin.add(tfPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(184, 157, 86, 14);
		panelLogin.add(lblPassword);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createLineBorder(Color.red));
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnConnect = new JButton("Connect");
		panel.add(btnConnect);
		
		btnNewClient = new JButton("New Client");
		panel.add(btnNewClient);
		
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

	public JButton getBtnConnect() {
		return btnConnect;
	}

	public void setBtnConnect(JButton btnConnect) {
		this.btnConnect = btnConnect;
	}

	public JButton getBtnNewClient() {
		return btnNewClient;
	}

	public void setBtnNewClient(JButton btnNewClient) {
		this.btnNewClient = btnNewClient;
	}

	public JButton getBtnQuit() {
		return btnQuit;
	}

	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}
}

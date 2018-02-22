package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class DeleteClientView {

	private JFrame frame;
	private JPasswordField tfPassword;
	private JTextField tfUsername;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteClientView window = new DeleteClientView();
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
	public DeleteClientView() {
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
		frame.setVisible(true);
		
		JLabel lblTitle = new JLabel("Delete Account");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 32));
		frame.getContentPane().add(lblTitle, BorderLayout.NORTH);
		
		JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, BorderLayout.CENTER);
		panelLogin.setLayout(null);

		try {
			MaskFormatter phoneMask = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(409, 234, 156, 27);
		panelLogin.add(tfPassword);
		
		JLabel lblConfirm = new JLabel("Password Confirmation:");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirm.setBounds(176, 237, 204, 14);
		panelLogin.add(lblConfirm);
		
		btnDelete = new JButton("Delete Account");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDelete.setBounds(298, 314, 131, 23);
		panelLogin.add(btnDelete);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(275, 180, 90, 14);
		panelLogin.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(409, 177, 156, 27);
		panelLogin.add(tfUsername);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(JPasswordField tfOldPassword) {
		this.tfPassword = tfOldPassword;
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
}

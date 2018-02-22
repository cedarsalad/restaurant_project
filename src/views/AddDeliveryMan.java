package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class AddDeliveryMan extends JFrame {
	private JFrame frame;
	private JTextField tfName;
	private JTextField tfPhone;
	private JPanel pAreas;
	private JFormattedTextField JtfArea;

	private JButton btnAddArea;
	private JButton btnDeleteArea;
	private JButton btnSave;
	private JButton btnCancel;

	public AddDeliveryMan() {
		frame = this;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		mainPanel.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblName = new JLabel("name : ");
		panel.add(lblName);

		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);

		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPhone = new JLabel("Phone Number : ");
		panel_1.add(lblPhone);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		panel_1.add(tfPhone);
		
		pAreas = new JPanel();
		mainPanel.add(pAreas);

		try {
			MaskFormatter mfArea = new MaskFormatter("U#U#U#");
			JtfArea = new JFormattedTextField(mfArea);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		JPanel pArea = new JPanel();
		mainPanel.add(pArea);
		pArea.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Delivery area : ");
		pArea.add(lblNewLabel);
		JtfArea.setColumns(6);

		pArea.add(JtfArea);

		btnAddArea = new JButton("Add Delivery Area");
		pArea.add(btnAddArea);

		btnDeleteArea = new JButton("Delete Delivery Area");
		pArea.add(btnDeleteArea);

		JPanel panel_3 = new JPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSave = new JButton("Save");
		panel_3.add(btnSave);

		btnCancel = new JButton("Cancel");
		panel_3.add(btnCancel);
		
		frame.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfPhone() {
		return tfPhone;
	}

	public void setTfPhone(JTextField tfPhone) {
		this.tfPhone = tfPhone;
	}

	public JPanel getpAreas() {
		return pAreas;
	}

	public void setpAreas(JPanel pAreas) {
		this.pAreas = pAreas;
	}
	
	public JFormattedTextField getJtfArea() {
		return JtfArea;
	}

	public void setJtfArea(JFormattedTextField jtfArea) {
		JtfArea = jtfArea;
	}

	public JButton getBtnAddArea() {
		return btnAddArea;
	}

	public void setBtnAddArea(JButton btnAddArea) {
		this.btnAddArea = btnAddArea;
	}

	public JButton getBtnDeleteArea() {
		return btnDeleteArea;
	}

	public void setBtnDeleteArea(JButton btnDeleteArea) {
		this.btnDeleteArea = btnDeleteArea;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	
}

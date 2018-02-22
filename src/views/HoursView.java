package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HoursView extends JFrame{
	
	static JFrame frame;
	static JLabel lblSelectedRestaurantName;
	static JPanel pHours;
	static JButton btnCancel; 
	static JButton btnSave; 
	
	public HoursView(){
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 326);
		
		// comboBox Content start
		String[] hours = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
				"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };

		String[] mins = new String[60];

		// populate minutes start
		for (int x = 0; x < mins.length; x++) {
			if (String.valueOf(x).length() < 2) {
				mins[x] = "0" + x;
			}else{
				mins[x] = x + "";
			}
		}
		// populate minutes end
		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		
		lblSelectedRestaurantName = new JLabel("Selected Restaurant Name");
		lblSelectedRestaurantName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_4.add(lblSelectedRestaurantName);

		pHours = new JPanel();
		pHours.setPreferredSize(new Dimension((int) (frame.getWidth() * 0.75), 200));
		frame.getContentPane().add(pHours);
		pHours.setLayout(new GridLayout(8, 3, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("Day");
		lblNewLabel_3.setName("column");
		lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(lblNewLabel_3);

		JLabel label_1 = new JLabel("Opening Time");
		label_1.setName("column");
		label_1.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_1);

		JLabel label_8 = new JLabel("Closing Time");
		label_8.setName("column");
		label_8.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_8);

		JLabel lblNewLabel_1 = new JLabel("Monday : ");
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		pHours.add(panel);

		JComboBox comboBox = new JComboBox(hours);
		panel.add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("h");
		panel.add(lblNewLabel_4);

		JComboBox comboBox_1 = new JComboBox(mins);
		panel.add(comboBox_1);

		JPanel panel_1 = new JPanel();
		pHours.add(panel_1);

		JComboBox comboBox_14 = new JComboBox(hours);
		panel_1.add(comboBox_14);

		JLabel label_15 = new JLabel("h");
		panel_1.add(label_15);

		JComboBox comboBox_15 = new JComboBox(mins);
		panel_1.add(comboBox_15);

		JLabel label = new JLabel("Tuesday : ");
		label.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label);

		JPanel panel_2 = new JPanel();
		pHours.add(panel_2);

		JComboBox comboBox_2 = new JComboBox(hours);
		panel_2.add(comboBox_2);

		JLabel label_9 = new JLabel("h");
		panel_2.add(label_9);

		JComboBox comboBox_3 = new JComboBox(mins);
		panel_2.add(comboBox_3);

		JPanel panel_3 = new JPanel();
		pHours.add(panel_3);

		JComboBox comboBox_16 = new JComboBox(hours);
		panel_3.add(comboBox_16);

		JLabel label_16 = new JLabel("h");
		panel_3.add(label_16);

		JComboBox comboBox_17 = new JComboBox(mins);
		panel_3.add(comboBox_17);

		JLabel label_3 = new JLabel("Wednesday : ");
		label_3.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_3);

		JPanel panel_6 = new JPanel();
		pHours.add(panel_6);

		JComboBox comboBox_4 = new JComboBox(hours);
		panel_6.add(comboBox_4);

		JLabel label_10 = new JLabel("h");
		panel_6.add(label_10);

		JComboBox comboBox_5 = new JComboBox(mins);
		panel_6.add(comboBox_5);

		JPanel panel_7 = new JPanel();
		pHours.add(panel_7);

		JComboBox comboBox_18 = new JComboBox(hours);
		panel_7.add(comboBox_18);

		JLabel label_17 = new JLabel("h");
		panel_7.add(label_17);

		JComboBox comboBox_19 = new JComboBox(mins);
		panel_7.add(comboBox_19);

		JLabel label_4 = new JLabel("Thursday : ");
		label_4.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_4);

		JPanel panel_8 = new JPanel();
		pHours.add(panel_8);

		JComboBox comboBox_6 = new JComboBox(hours);
		panel_8.add(comboBox_6);

		JLabel label_11 = new JLabel("h");
		panel_8.add(label_11);

		JComboBox comboBox_7 = new JComboBox(mins);
		panel_8.add(comboBox_7);

		JPanel panel_9 = new JPanel();
		pHours.add(panel_9);

		JComboBox comboBox_20 = new JComboBox(hours);
		panel_9.add(comboBox_20);

		JLabel label_18 = new JLabel("h");
		panel_9.add(label_18);

		JComboBox comboBox_21 = new JComboBox(mins);
		panel_9.add(comboBox_21);

		JLabel label_5 = new JLabel("Friday : ");
		label_5.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_5);

		JPanel panel_10 = new JPanel();
		pHours.add(panel_10);

		JComboBox comboBox_8 = new JComboBox(hours);
		panel_10.add(comboBox_8);

		JLabel label_12 = new JLabel("h");
		panel_10.add(label_12);

		JComboBox comboBox_9 = new JComboBox(mins);
		panel_10.add(comboBox_9);

		JPanel panel_11 = new JPanel();
		pHours.add(panel_11);

		JComboBox comboBox_22 = new JComboBox(hours);
		panel_11.add(comboBox_22);

		JLabel label_19 = new JLabel("h");
		panel_11.add(label_19);

		JComboBox comboBox_23 = new JComboBox(mins);
		panel_11.add(comboBox_23);

		JLabel label_6 = new JLabel("Saturday : ");
		label_6.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_6);

		JPanel panel_12 = new JPanel();
		pHours.add(panel_12);

		JComboBox comboBox_10 = new JComboBox(hours);
		panel_12.add(comboBox_10);

		JLabel label_13 = new JLabel("h");
		panel_12.add(label_13);

		JComboBox comboBox_11 = new JComboBox(mins);
		panel_12.add(comboBox_11);

		JPanel panel_13 = new JPanel();
		pHours.add(panel_13);

		JComboBox comboBox_24 = new JComboBox(hours);
		panel_13.add(comboBox_24);

		JLabel label_20 = new JLabel("h");
		panel_13.add(label_20);

		JComboBox comboBox_25 = new JComboBox(mins);
		panel_13.add(comboBox_25);

		JLabel label_7 = new JLabel("Sunday : ");
		label_7.setHorizontalAlignment(JLabel.CENTER);
		pHours.add(label_7);

		JPanel panel_14 = new JPanel();
		pHours.add(panel_14);

		JComboBox comboBox_12 = new JComboBox(hours);
		panel_14.add(comboBox_12);

		JLabel label_14 = new JLabel("h");
		panel_14.add(label_14);

		JComboBox comboBox_13 = new JComboBox(mins);
		panel_14.add(comboBox_13);

		JPanel panel_15 = new JPanel();
		pHours.add(panel_15);

		JComboBox comboBox_26 = new JComboBox(hours);
		panel_15.add(comboBox_26);

		JLabel label_21 = new JLabel("h");
		panel_15.add(label_21);

		JComboBox comboBox_27 = new JComboBox(mins);
		panel_15.add(comboBox_27);

		frame.getContentPane().add(pHours);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		
		btnSave = new JButton("Save");
		panel_5.add(btnSave);
		
		btnCancel = new JButton("cancel");
		panel_5.add(btnCancel);
		// hours end
		
		frame.setVisible(true);
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JPanel getpHours() {
		return pHours;
	}

	public static JLabel getLblSelectedRestaurantName() {
		return lblSelectedRestaurantName;
	}

	public static void setLblSelectedRestaurantName(JLabel lblSelectedRestaurantName) {
		HoursView.lblSelectedRestaurantName = lblSelectedRestaurantName;
	}

	public static JButton getBtnCancel() {
		return btnCancel;
	}

	public static void setBtnCancel(JButton btnCancel) {
		HoursView.btnCancel = btnCancel;
	}

	public static JButton getBtnSave() {
		return btnSave;
	}

	public static void setBtnSave(JButton btnSave) {
		HoursView.btnSave = btnSave;
	}
	
	

}

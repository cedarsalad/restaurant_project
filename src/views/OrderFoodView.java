package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderFoodView extends JFrame {

	private JPanel contentPane;
	private JList<String> restaurant_JList;
	private JList<String> menu_JList;
	private JList<String> order_JList;
	
	private JLabel restaurant_Label;
	private JFormattedTextField deliveryDate_Ftf;
	private JFormattedTextField hour_Ftf;
	private JFormattedTextField minute_Ftf;
	private JFormattedTextField postalCode_Ftf;
	private JFormattedTextField meal_Ftf;
	private JFormattedTextField price_Ftf;
	private JFormattedTextField quantity_Ftf;
	private JFormattedTextField total_Ftf;
	private JButton add_Btn;
	private JButton order_Btn;
	private JButton delete_Btn;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFoodView frame = new OrderFoodView();
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
	public OrderFoodView() {
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
		
		JPanel mainCenter_Panel = new JPanel();
		contentPane.add(mainCenter_Panel, BorderLayout.CENTER);
		mainCenter_Panel.setLayout(new BorderLayout(0, 0));
		
		JPanel info_Panel = new JPanel();
		mainCenter_Panel.add(info_Panel, BorderLayout.CENTER);
		info_Panel.setLayout(null);
		
		JLabel deliveryDate_Label = new JLabel("Delivery Date(yyyy/mm/dd) :");
		deliveryDate_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryDate_Label.setBounds(252, 62, 245, 23);
		info_Panel.add(deliveryDate_Label);
		
		JLabel deliveryTime_label = new JLabel("Delivery Time :");
		deliveryTime_label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		deliveryTime_label.setBounds(252, 96, 169, 22);
		info_Panel.add(deliveryTime_label);
		
		MaskFormatter dateMask = null;
		try {
		    dateMask = new MaskFormatter("####/##/##");
		    dateMask.setValidCharacters("0123456789");
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		deliveryDate_Ftf = new JFormattedTextField(dateMask);
		deliveryDate_Ftf.setBounds(484, 65, 131, 23);
		info_Panel.add(deliveryDate_Ftf);
		
		hour_Ftf = new JFormattedTextField();
		hour_Ftf.setBounds(484, 99, 42, 23);
		info_Panel.add(hour_Ftf);
		
		JLabel hour_Label = new JLabel("h");
		hour_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		hour_Label.setBounds(531, 100, 17, 22);
		info_Panel.add(hour_Label);
		
		minute_Ftf = new JFormattedTextField();
		minute_Ftf.setBounds(546, 99, 42, 23);
		info_Panel.add(minute_Ftf);
		
		JLabel minute_Label = new JLabel("m\r\n");
		minute_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		minute_Label.setBounds(598, 100, 17, 22);
		info_Panel.add(minute_Label);
		
		JLabel postalCode_Label = new JLabel("Postal Code :");
		postalCode_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		postalCode_Label.setBounds(252, 129, 245, 23);
		info_Panel.add(postalCode_Label);

		try {
			MaskFormatter postalMask = new MaskFormatter("?#?-#?#");
			postalCode_Ftf = new JFormattedTextField(postalMask);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		postalCode_Ftf.setBounds(484, 132, 131, 23);
		info_Panel.add(postalCode_Ftf);
		
		JLabel order_Label = new JLabel("Order");
		order_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		order_Label.setBounds(634, 197, 118, 23);
		info_Panel.add(order_Label);
		
		JLabel orderFood_Label = new JLabel("Order Food");
		orderFood_Label.setPreferredSize(new Dimension(600, 40));
		orderFood_Label.setHorizontalAlignment(SwingConstants.CENTER);
		orderFood_Label.setFont(new Font("Tahoma", Font.BOLD, 25));
		orderFood_Label.setBounds(343, 11, 205, 40);
		info_Panel.add(orderFood_Label);
		
		JLabel menu_Label = new JLabel("Menu");
		menu_Label.setPreferredSize(new Dimension(120, 20));
		menu_Label.setHorizontalAlignment(SwingConstants.CENTER);
		menu_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		menu_Label.setBounds(212, 194, 199, 28);
		info_Panel.add(menu_Label);
		
		DefaultListModel restaurantlList = new DefaultListModel();
		DefaultListModel menuList = new DefaultListModel();
		DefaultListModel orderList = new DefaultListModel();
		
		menu_JList = new JList<String>(menuList);
		menu_JList.setPreferredSize(new Dimension(199, 640));
		menu_JList.setBounds(212, 233, 199, 311);
		info_Panel.add(menu_JList);
		
		restaurant_Label = new JLabel("Restaurant");
		restaurant_Label.setBounds(39, 194, 153, 28);
		info_Panel.add(restaurant_Label);
		restaurant_Label.setHorizontalAlignment(SwingConstants.CENTER);
		restaurant_Label.setFont(new Font("Tahoma", Font.BOLD, 17));
		restaurant_Label.setPreferredSize(new Dimension(120, 20));
		
		restaurant_JList = new JList<String>(restaurantlList);
		restaurant_JList.setBounds(10, 233, 199, 311);
		info_Panel.add(restaurant_JList);
		restaurant_JList.setPreferredSize(new Dimension(199, 640));
		
		order_JList = new JList<String>(orderList);
		order_JList.setPreferredSize(new Dimension(199, 640));
		order_JList.setBounds(634, 233, 199, 311);
		info_Panel.add(order_JList);
		
		JLabel meal_Label = new JLabel("Meal:");
		meal_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		meal_Label.setBounds(421, 274, 86, 23);
		info_Panel.add(meal_Label);
		
		JLabel price_Label = new JLabel("Price:");
		price_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		price_Label.setBounds(421, 308, 86, 23);
		info_Panel.add(price_Label);
		
		JLabel quantity_Label = new JLabel("Quantity:");
		quantity_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		quantity_Label.setBounds(421, 342, 86, 23);
		info_Panel.add(quantity_Label);
		
		JLabel max_Label = new JLabel("(Maximum 10)");
		max_Label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		max_Label.setBounds(421, 368, 98, 23);
		info_Panel.add(max_Label);
		
		JLabel total_Label = new JLabel("Total (no taxes) :");
		total_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		total_Label.setBounds(274, 574, 137, 23);
		info_Panel.add(total_Label);
		
		JLabel $_Label = new JLabel("$");
		$_Label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		$_Label.setBounds(552, 574, 14, 23);
		info_Panel.add($_Label);
		
		meal_Ftf = new JFormattedTextField();
		meal_Ftf.setEnabled(false);
		meal_Ftf.setBounds(517, 274, 107, 23);
		info_Panel.add(meal_Ftf);
		
		price_Ftf = new JFormattedTextField();
		price_Ftf.setEnabled(false);
		price_Ftf.setBounds(517, 308, 107, 23);
		info_Panel.add(price_Ftf);
		
		quantity_Ftf = new JFormattedTextField();
		quantity_Ftf.setBounds(517, 342, 107, 23);
		info_Panel.add(quantity_Ftf);
		
		total_Ftf = new JFormattedTextField();
		total_Ftf.setEnabled(false);
		total_Ftf.setBounds(415, 574, 131, 23);
		info_Panel.add(total_Ftf);
		
		add_Btn = new JButton("Add");
		add_Btn.setPreferredSize(new Dimension(195, 23));
		add_Btn.setBounds(421, 456, 203, 23);
		info_Panel.add(add_Btn);
		
		order_Btn = new JButton("Order");
		order_Btn.setPreferredSize(new Dimension(195, 23));
		order_Btn.setBounds(388, 608, 98, 23);
		info_Panel.add(order_Btn);
		
		delete_Btn = new JButton("Delete");
		delete_Btn.setPreferredSize(new Dimension(195, 23));
		delete_Btn.setBounds(421, 490, 203, 23);
		info_Panel.add(delete_Btn);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
		
		setVisible(true);

	}

	public JList<String> getRestaurant_JList() {
		return restaurant_JList;
	}

	public void setRestaurant_JList(JList<String> restaurant_JList) {
		this.restaurant_JList = restaurant_JList;
	}

	public JFormattedTextField getDeliveryDate_Ftf() {
		return deliveryDate_Ftf;
	}

	public void setDeliveryDate_Ftf(JFormattedTextField deliveryTime_Ftf) {
		this.deliveryDate_Ftf = deliveryTime_Ftf;
	}

	public JFormattedTextField getHour_Ftf() {
		return hour_Ftf;
	}

	public void setHour_Ftf(JFormattedTextField hour_Ftf) {
		this.hour_Ftf = hour_Ftf;
	}

	public JFormattedTextField getMinute_Ftf() {
		return minute_Ftf;
	}

	public void setMinute_Ftf(JFormattedTextField minute_Ftf) {
		this.minute_Ftf = minute_Ftf;
	}

	public JFormattedTextField getPostalCode_Ftf() {
		return postalCode_Ftf;
	}

	public void setPostalCode_Ftf(JFormattedTextField postalCode_Ftf) {
		this.postalCode_Ftf = postalCode_Ftf;
	}

	public JList<String> getMenu_JList() {
		return menu_JList;
	}

	public void setMenu_JList(JList<String> menu_JList) {
		this.menu_JList = menu_JList;
	}

	public JList<String> getOrder_JList() {
		return order_JList;
	}

	public void setOrder_JList(JList<String> order_JList) {
		this.order_JList = order_JList;
	}

	public JFormattedTextField getMeal_Ftf() {
		return meal_Ftf;
	}

	public void setMeal_Ftf(JFormattedTextField meal_Ftf) {
		this.meal_Ftf = meal_Ftf;
	}

	public JFormattedTextField getPrice_Ftf() {
		return price_Ftf;
	}

	public void setPrice_Ftf(JFormattedTextField price_Ftf) {
		this.price_Ftf = price_Ftf;
	}

	public JFormattedTextField getQuantity_Ftf() {
		return quantity_Ftf;
	}

	public void setQuantity_Ftf(JFormattedTextField quantity_Ftf) {
		this.quantity_Ftf = quantity_Ftf;
	}

	public JFormattedTextField getTotal_Ftf() {
		return total_Ftf;
	}

	public void setTotal_Ftf(JFormattedTextField total_Ftf) {
		this.total_Ftf = total_Ftf;
	}

	public JButton getAdd_Btn() {
		return add_Btn;
	}

	public void setAdd_Btn(JButton add_Btn) {
		this.add_Btn = add_Btn;
	}

	public JButton getOrder_Btn() {
		return order_Btn;
	}

	public void setOrder_Btn(JButton order_Btn) {
		this.order_Btn = order_Btn;
	}

	public JButton getDelete_Btn() {
		return delete_Btn;
	}

	public void setDelete_Btn(JButton delete_Btn) {
		this.delete_Btn = delete_Btn;
	}
}

package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JList;

public class ManagerMain extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMain frame = new ManagerMain();
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
	public ManagerMain() {
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
		
		JPanel centerNorth_Panel = new JPanel();
		centerNorth_Panel.setPreferredSize(new Dimension(10, 50));
		mainCenter_Panel.add(centerNorth_Panel, BorderLayout.NORTH);
		
		JPanel mainWest_Panel = new JPanel();
		mainWest_Panel.setPreferredSize(new Dimension(200, 10));
		contentPane.add(mainWest_Panel, BorderLayout.WEST);
		mainWest_Panel.setLayout(null);
		
		JPanel mainEast_Panel = new JPanel();
		mainEast_Panel.setPreferredSize(new Dimension(0, 10));
		contentPane.add(mainEast_Panel, BorderLayout.EAST);
	}
}

package views;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import custom_controls.MenuBar;

public class MenuView extends JFrame {

    private ImageIcon image;
    private JLabel wIcon;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MenuView window = new MenuView();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MenuView() {
		initialize();
		this.setJMenuBar(new MenuBar());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		this.setResizable(false);
		this.setBounds(100, 100, 800, 775);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
        image = new ImageIcon(getClass().getResource("logo.png"));
		getContentPane().setLayout(null);
		wIcon = new JLabel("");
		wIcon.setIcon(image);
		wIcon.setBounds(80, 61, 608, 490);
		
		this.getContentPane().add(wIcon);
		this.getContentPane().setBackground(Color.white);
	}

//	public JFrame getFrame() {
//		return frame;
//	}
//
//	public void setFrame(JFrame frame) {
//		this.frame = frame;
//	}

}

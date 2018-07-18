package plantville;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.CardLayout;
import java.awt.Toolkit;

/**
 * The Frame class is a component of the GUI of the game 
 * which holds all other panels that were initialized.
 * @author James Buizon
 * @author Gabriel Santiago
 */

public class Frame extends JFrame {

	private JPanel mainPanel;

	/**
	 * Creates the frame of the game.
	 */
	public Frame() {
		setTitle("PlantVille");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setSize(1280, 720);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		CardLayout deck = new CardLayout(0, 0);
		mainPanel.setLayout(deck);
		
		JPanel titleScreenPanel = new TitleScreen();
		mainPanel.add(titleScreenPanel, "Title Screen");
	}
	
	public JPanel getMainPanel()
	{
		return mainPanel;
	}
}

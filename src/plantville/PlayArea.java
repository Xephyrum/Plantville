package plantville;

/**
 * The PlayArea class creates the game screen which
 * allows the player to perform the basic functionalities
 * of the game such as to shop, check storage, plant, harvest, etc.
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.0, 8/10/2016
 */
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PlayArea extends JPanel {
	private int i;
	private int j;
	/**
	 * Creates the game screen panel.
	 */
	public PlayArea() {
		setBackground(new Color(255, 200, 0));
		setLayout(null);
		setSize(new Dimension(1280, 720));
		
		JLabel playerLbl = new JLabel("<player.toString()>");
		playerLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		playerLbl.setBounds(10, 23, 456, 23);
		add(playerLbl);
		
		JLabel simLbl = new JLabel("<simulator.toString()>");
		simLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		simLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		simLbl.setBounds(585, 23, 227, 23);
		add(simLbl);
		
		JButton btnViewStorage = new JButton("View Storage");
		btnViewStorage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Driver.getFrame().getMainPanel().add(new StoragePanel(), "View Storage");
				((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "View Storage");
			}
		});
		btnViewStorage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewStorage.setBounds(939, 23, 117, 25);
		add(btnViewStorage);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Driver.getFrame().getMainPanel().add(new StorePanel(), "Store");
				((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Store");
			}
		});
		btnShop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShop.setBounds(1066, 23, 89, 25);
		add(btnShop);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(1165, 23, 89, 25);
		add(btnExit);
		
		playerLbl.setText(Driver.getGame().getPlayer().toString());
		simLbl.setText(Driver.getGame().getTimeSim().toString());
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Driver.getGame().nextDay();
				Driver.getFrame().getMainPanel().add(new PlayArea(), "Play area");
				((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Play area");
			}
		});
		btnSleep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSleep.setBounds(840, 23, 89, 25);
		add(btnSleep);
		
		JLabel lblTipClickOn = new JLabel("Click on a tile on the Field to do actions to the Soil!");
		lblTipClickOn.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTipClickOn.setBounds(39, 11, 328, 14);
		add(lblTipClickOn);
		
		JLabel lblTip = new JLabel("TIP:");
		lblTip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTip.setBounds(10, 11, 46, 14);
		add(lblTip);
		
		JLabel field[][] = new JLabel[10][20];
		int x = 10;
		int y = 52;
		
		for (i = 0; i < 10; i++) {
			for (j = 0; j < 20; j++) {
				field[i][j] = new Tile(i, j);
				field[i][j].setBounds(x, y, 52, 52);
				
				add(field[i][j]);
				x += 62;
			}
			y += 63;
			x = 10;
		}
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/gamebg.png")));
		label.setBounds(0, 0, 1280, 720);
		add(label);
	}
}

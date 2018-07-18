package plantville;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.ImageIcon;

/**
 * The TitleScreen class creates the title screen 
 * which allows the player to generate a new character. 
 * @author Gabriel Santiago
 * @author James Buizon
 */

public class TitleScreen extends JPanel {
	private JTextField textField;

	/**
	 * Creates the panel for the title screen.
	 */
	public TitleScreen() {
		setSize(1280, 720);
		setLayout(null);
		
		JLabel lblWelcomeToPlantville = new JLabel("Welcome to Plantville!");
		lblWelcomeToPlantville.setBounds(0, 390, 1280, 14);
		lblWelcomeToPlantville.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblWelcomeToPlantville);
		
		JLabel lblNewLabel = new JLabel("What's your name, young planter?");
		lblNewLabel.setBounds(0, 415, 1280, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(530, 448, 218, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Start planting!");
		btnNewButton.setBounds(556, 497, 168, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Driver.getGame().getPlayer().setName(textField.getText());
				Driver.getFrame().getMainPanel().add(new PlayArea(), "Play area");
				((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Play area");
				
			}
		});
		add(btnNewButton);
		
		JLabel lblPlantville = new JLabel("");
		lblPlantville.setVerticalAlignment(SwingConstants.TOP);
		lblPlantville.setIcon(new ImageIcon(TitleScreen.class.getResource("/plantville/plantville logo.png")));
		lblPlantville.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlantville.setFont(new Font("Tahoma", Font.PLAIN, 90));
		lblPlantville.setBounds(0, 109, 1280, 221);
		add(lblPlantville);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TitleScreen.class.getResource("/plantville/bg.png")));
		lblNewLabel_1.setBounds(0, 0, 1280, 720);
		add(lblNewLabel_1);
			
	}
}

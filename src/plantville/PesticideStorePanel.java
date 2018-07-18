package plantville;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

/**
 * The PestcideStorePanel class is a component of the GUI of the game 
 * which creates and displays the pesticides sold in the store.
 * @author Gabriel Santiago
 * @author James Buizon
 */

public class PesticideStorePanel extends JPanel {
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	/**
	 * Creates the panel for the pesticide section in the store.
	 */
	public PesticideStorePanel() {
		setBorder(new TitledBorder(null, "Buy Pesticide", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		setSize(1260, 662);
		
		JLabel lblSelectPesticidesTo = new JLabel("Select Pesticide(s) to buy:");
		lblSelectPesticidesTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectPesticidesTo.setBounds(10, 31, 213, 26);
		add(lblSelectPesticidesTo);
		
		JLabel lblNewLabel = new JLabel("<html><p>UNS (3 C/can)<br>Life span: 1 day<br>Pest effect: -1 rst.<br>Plant effect: ---<br>Soil pH effect: ---");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 68, 132, 124);
		add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt1.setText("0");
		txt1.setBounds(163, 70, 44, 38);
		add(txt1);
		txt1.setColumns(10);
		
		JLabel lblPesticide = new JLabel("<html><p>S5 (7 C/can)<br>Life span: 2 days<br>Pest effect: -2 rst.<br>Plant effect: -5 rst.<br>Soil pH effect: ---");
		lblPesticide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesticide.setVerticalAlignment(SwingConstants.TOP);
		lblPesticide.setBounds(291, 68, 132, 124);
		add(lblPesticide);
		
		JLabel lblPesticide_1 = new JLabel("<html><p>S7 (10 C/can)<br>Life span: 3 days<br>Pest effect: Death<br>Plant effect: -3 rst.<br>Soil pH effect: +1");
		lblPesticide_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPesticide_1.setVerticalAlignment(SwingConstants.TOP);
		lblPesticide_1.setBounds(560, 68, 132, 124);
		add(lblPesticide_1);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt2.setText("0");
		txt2.setColumns(10);
		txt2.setBounds(444, 70, 44, 38);
		add(txt2);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt3.setText("0");
		txt3.setBounds(712, 70, 44, 38);
		add(txt3);
		txt3.setColumns(10);
		
		JButton btnProceed = new JButton("Purchase!");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i < Integer.parseInt(txt1.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPesticides(Driver.getGame().getStore().getPesticide(0));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPesticide(0).getPrice());
					}	
					
					for (int i = 0; i < Integer.parseInt(txt2.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPesticides(Driver.getGame().getStore().getPesticide(1));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPesticide(1).getPrice());
					}
					
					for (int i = 0; i < Integer.parseInt(txt3.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPesticides(Driver.getGame().getStore().getPesticide(2));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPesticide(2).getPrice());
					}
					
					if (Driver.getGame().getPlayer().getWallet().getMoney() == 0) {
						JOptionPane.showMessageDialog(null, "No more money! GAME OVER!");
						System.exit(0);
					}
					
					JOptionPane.showMessageDialog(null, "Purchase successfull!");
					
					Driver.getFrame().getMainPanel().add(new StorePanel(), "Store");
					((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Store");
						
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Invalid input! Please make sure you put numbers as input.");
				} catch (Throwable ex) {
					JOptionPane.showMessageDialog(null, "Exception: " + ex);
				}
			}
		});
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProceed.setBounds(878, 89, 132, 61);
		add(btnProceed);

	}

}

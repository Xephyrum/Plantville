package plantville;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

/**
 * The FertilizerStorePanel class is a component of the GUI of the game 
 * which creates and displays the fertilizers sold in the store.
 * @author James Buizon
 * @author Gabriel Santiago
 */

public class FertilizerStorePanel extends JPanel {
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	/**
	 * Creates the panel for the fertilizer section in the store.
	 */
	public FertilizerStorePanel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buy Fertilizer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setSize(1260, 662);
		
		JLabel lblNewLabel = new JLabel("<html><p>Kitchen scraps (3 C/piece)<br>Life span: 1 day<br>Soil pH effect: +0.01");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 66, 188, 151);
		add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt1.setText("0");
		txt1.setBounds(220, 68, 46, 39);
		add(txt1);
		txt1.setColumns(10);
		
		JLabel lblFertilizer = new JLabel("<html><p>Field scraps (6 C/piece)<br>Life span: 3 days<br>Soil pH effect: +0.05");
		lblFertilizer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFertilizer.setVerticalAlignment(SwingConstants.TOP);
		lblFertilizer.setBounds(311, 66, 165, 136);
		add(lblFertilizer);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt2.setText("0");
		txt2.setColumns(10);
		txt2.setBounds(500, 68, 46, 39);
		add(txt2);
		
		JLabel lblFertilizer_1 = new JLabel("<html><p>Manure (10 C/piece)<br>Life span: 5 days<br>Soil pH effect: +1");
		lblFertilizer_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFertilizer_1.setVerticalAlignment(SwingConstants.TOP);
		lblFertilizer_1.setBounds(594, 66, 175, 136);
		add(lblFertilizer_1);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt3.setText("0");
		txt3.setColumns(10);
		txt3.setBounds(761, 68, 46, 39);
		add(txt3);
		
		JButton btnProceed = new JButton("Proceed!");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i < Integer.parseInt(txt1.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addFertilizers(Driver.getGame().getStore().getFertilizer(0));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getFertilizer(0).getPrice());
					}	
					
					for (int i = 0; i < Integer.parseInt(txt2.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addFertilizers(Driver.getGame().getStore().getFertilizer(1));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getFertilizer(1).getPrice());
					}
					
					for (int i = 0; i < Integer.parseInt(txt3.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addFertilizers(Driver.getGame().getStore().getFertilizer(2));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getFertilizer(2).getPrice());
					}
					
					if (Driver.getGame().getPlayer().getWallet().getMoney() == 0) {
						JOptionPane.showMessageDialog(null, "No more money! GAME OVER!");
						System.exit(0);
					}
					
					JOptionPane.showMessageDialog(null, "Purchase successful    !");
					
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
		btnProceed.setBounds(928, 74, 145, 59);
		add(btnProceed);
		
		JLabel lblSelectFertilizersTo = new JLabel("Select Fertilizer(s) to buy:");
		lblSelectFertilizersTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectFertilizersTo.setBounds(10, 30, 213, 25);
		add(lblSelectFertilizersTo);

	}

}

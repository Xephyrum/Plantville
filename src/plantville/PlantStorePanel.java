package plantville;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

/**
 * The PlantStorePanel class is a component of the GUI of the game 
 * which creates and displays the plants sold in the store.
 * @author Gabriel Santiago
 * @author James Buizon
 */

public class PlantStorePanel extends JPanel {
	private JTextField txt2;
	private JTextField txt1;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;

	/**
	 * Creates the panel for the plant section in the store.
	 */
	public PlantStorePanel() {
		setBorder(new TitledBorder(null, "Buy Plant seed", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		setSize(1260, 662);
		
		JLabel lblSelectPlantSeeds = new JLabel("Select Plant seed(s) to buy:");
		lblSelectPlantSeeds.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectPlantSeeds.setBounds(10, 25, 252, 35);
		add(lblSelectPlantSeeds);
		
		JLabel lblPlant = new JLabel("<html><p>Sitaw (10 C/seed)<br>Days to grow: 4<br>Harvest price: 15 C<br>Effect on soil pH: +0.05<br>Pest resistance: 5");
		lblPlant.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlant.setVerticalAlignment(SwingConstants.TOP);
		lblPlant.setBounds(10, 106, 150, 143);
		add(lblPlant);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt2.setText("0");
		txt2.setBounds(170, 283, 46, 32);
		add(txt2);
		txt2.setColumns(10);
		
		JLabel lblPlant_1 = new JLabel("<html><p>Patola (15 C/seed)<br>Days to grow: 6<br>Harvest price: 25 C<br>Effect on soil pH: -0.05<br>Pest resistance: 10");
		lblPlant_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlant_1.setVerticalAlignment(SwingConstants.TOP);
		lblPlant_1.setBounds(10, 282, 150, 132);
		add(lblPlant_1);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt1.setText("0");
		txt1.setColumns(10);
		txt1.setBounds(170, 107, 46, 32);
		add(txt1);
		
		JLabel lblPlant_2 = new JLabel("<html><p>Kalabasa (20 C/seed)<br>Days to grow: 7<br>Days to re-bear: 3<br>No. of harvests: 3<br>Harvest price: 20 C<br>Effect on soil pH: -0.1<br>Pest resistance: 10");
		lblPlant_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlant_2.setVerticalAlignment(SwingConstants.TOP);
		lblPlant_2.setBounds(324, 106, 160, 143);
		add(lblPlant_2);
		
		JLabel lblSingeharvestPlants = new JLabel("Singe-Harvest Plants");
		lblSingeharvestPlants.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSingeharvestPlants.setBounds(10, 71, 186, 23);
		add(lblSingeharvestPlants);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(9, 97, 207, 2);
		add(separator);
		
		JLabel lblMultipleharvestPlants = new JLabel("Multiple-Harvest Plants");
		lblMultipleharvestPlants.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMultipleharvestPlants.setBounds(324, 60, 200, 35);
		add(lblMultipleharvestPlants);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(324, 93, 216, 2);
		add(separator_1);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt3.setText("0");
		txt3.setColumns(10);
		txt3.setBounds(494, 107, 46, 32);
		add(txt3);
		
		JLabel lblPlant_3 = new JLabel("<html><p>Kamatis (10 C/seed)<br>Days to grow: 6<br>Days to re-bear: 3<br>No. of harvests: 2<br>Harvest price: 15 C<br>Effect on soil pH: +0.1<br>Pest resistance: 5");
		lblPlant_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlant_3.setVerticalAlignment(SwingConstants.TOP);
		lblPlant_3.setBounds(324, 283, 162, 152);
		add(lblPlant_3);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt4.setText("0");
		txt4.setColumns(10);
		txt4.setBounds(494, 283, 46, 32);
		add(txt4);
		
		JLabel lblNonbearingPlants = new JLabel("Non-Bearing Plants");
		lblNonbearingPlants.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNonbearingPlants.setBounds(674, 61, 160, 32);
		add(lblNonbearingPlants);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(674, 92, 207, 2);
		add(separator_2);
		
		JLabel lblPlant_4 = new JLabel("<html><p>Gumamela (70 C/seed)<br>Days to grow: 8<br>Effect on soil pH: +0.05<br>Pest resistance: 30");
		lblPlant_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlant_4.setVerticalAlignment(SwingConstants.TOP);
		lblPlant_4.setBounds(674, 106, 160, 143);
		add(lblPlant_4);
		
		txt5 = new JTextField();
		txt5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt5.setText("0");
		txt5.setColumns(10);
		txt5.setBounds(835, 108, 46, 31);
		add(txt5);
		
		JLabel lblPlant_5 = new JLabel("<html><p>Santan (60 C/seed)<br>Days to grow: 5<br>Effect on soil pH: -0.05<br>Pest resistance: 20");
		lblPlant_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlant_5.setVerticalAlignment(SwingConstants.TOP);
		lblPlant_5.setBounds(674, 260, 144, 133);
		add(lblPlant_5);
		
		txt6 = new JTextField();
		txt6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt6.setText("0");
		txt6.setColumns(10);
		txt6.setBounds(835, 261, 46, 35);
		add(txt6);
		
		JButton btnProceedWithPurchase = new JButton("Purchase!");
		btnProceedWithPurchase.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProceedWithPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (int i = 0; i < Integer.parseInt(txt1.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPlants(Driver.getGame().getStore().getPlant(0));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPlant(0).getSeedPrice());
					}	
					
					for (int i = 0; i < Integer.parseInt(txt2.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPlants(Driver.getGame().getStore().getPlant(1));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPlant(1).getSeedPrice());
					}
					
					for (int i = 0; i < Integer.parseInt(txt3.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPlants(Driver.getGame().getStore().getPlant(2));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPlant(2).getSeedPrice());
					}
					
					for (int i = 0; i < Integer.parseInt(txt4.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPlants(Driver.getGame().getStore().getPlant(3));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPlant(3).getSeedPrice());
					}
						
					for (int i = 0; i < Integer.parseInt(txt5.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPlants(Driver.getGame().getStore().getPlant(4));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPlant(4).getSeedPrice());
					}
					
					for (int i = 0; i < Integer.parseInt(txt6.getText()); i++) {
						Driver.getGame().getPlayer().getStorage().addPlants(Driver.getGame().getStore().getPlant(5));
						Driver.getGame().getPlayer().getWallet().subtractMoney(Driver.getGame().getStore().getPlant(5).getSeedPrice());
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
		btnProceedWithPurchase.setBounds(1018, 178, 160, 71);
		add(btnProceedWithPurchase);
		
		JLabel label = new JLabel("<sitaw>");
		label.setIcon(new ImageIcon(PlantStorePanel.class.getResource("/plantville/Soil_With_Sitaw.png")));
		label.setBounds(170, 173, 52, 52);
		add(label);
		
		JLabel label_1 = new JLabel("<sitaw>");
		label_1.setIcon(new ImageIcon(PlantStorePanel.class.getResource("/plantville/Soil_With_Patola.png")));
		label_1.setBounds(170, 349, 52, 52);
		add(label_1);
		
		JLabel label_2 = new JLabel("<sitaw>");
		label_2.setIcon(new ImageIcon(PlantStorePanel.class.getResource("/plantville/Soil_With_Kalabasa.png")));
		label_2.setBounds(494, 192, 52, 52);
		add(label_2);
		
		JLabel label_3 = new JLabel("<sitaw>");
		label_3.setIcon(new ImageIcon(PlantStorePanel.class.getResource("/plantville/Soil_With_Kamatis.png")));
		label_3.setBounds(494, 368, 52, 52);
		add(label_3);
		
		JLabel label_4 = new JLabel("<sitaw>");
		label_4.setIcon(new ImageIcon(PlantStorePanel.class.getResource("/plantville/Soil_With_Gumamela.png")));
		label_4.setBounds(835, 178, 52, 52);
		add(label_4);
		
		JLabel label_5 = new JLabel("<sitaw>");
		label_5.setIcon(new ImageIcon(PlantStorePanel.class.getResource("/plantville/Soil_With_Santan.png")));
		label_5.setBounds(835, 307, 52, 52);
		add(label_5);

	}
}

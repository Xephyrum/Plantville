package plantville;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The StorePanel class creates the container panel of the 
 * PlantStorePanel, FertilizerStorePanel, and PesticideStorePanel classes.
 * @author James Buizon 
 * @author Gabriel Santiago
 */

public class StorePanel extends JPanel {

	/**
	 * Creates the panel that holds the fertilizer, pesticide, and plant section in the store.
	 */
	public StorePanel() {
		setBorder(new TitledBorder(null, "Store", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		setSize(1280, 720);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tabbedPane.setBounds(10, 47, 1260, 662);
		add(tabbedPane);
		
		JButton button = new JButton("<<   Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Driver.getFrame().getMainPanel().add(new PlayArea(), "Play area");
				((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Play area");
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(10, 15, 129, 27);
		add(button);
		
		JLabel lblPlayer = new JLabel(Driver.getGame().getPlayer().toString());
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer.setBounds(159, 15, 313, 27);
		add(lblPlayer);
		JPanel fertilizer = new FertilizerStorePanel();
		JPanel pesticide = new PesticideStorePanel();
		
				JPanel plant = new PlantStorePanel();
				
				tabbedPane.add("Plant", plant);
		tabbedPane.add("Fertilizer", fertilizer);
		tabbedPane.add("Pesticide", pesticide);
		
		JLabel lblTime = new JLabel(Driver.getGame().getTimeSim().toString());
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(514, 15, 313, 27);
		add(lblTime);
	}
}

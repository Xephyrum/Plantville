package plantville;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * The StoragePanel class creates the panel that 
 * displays the current inventory of the player.
 * @author James Buizon
 * @author Gabriel Santiago
 */

public class StoragePanel extends JPanel {

	/**
	 * Creates the panel for the inventory.
	 */
	public StoragePanel() {
		setBorder(new TitledBorder(null, "Storage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		setSize(1280, 720);
		
		JButton button = new JButton("<< Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Driver.getFrame().getMainPanel().add(new PlayArea(), "Play area");
				((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Play area");
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(10, 21, 131, 27);
		add(button);
		
		JLabel lblPlayer = new JLabel(Driver.getGame().getPlayer().toString());
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayer.setBounds(151, 21, 336, 27);
		add(lblPlayer);
		
		JLabel lblTime = new JLabel(Driver.getGame().getTimeSim().toString());
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(517, 21, 336, 27);
		add(lblTime);
		
		JLabel lblPlants = new JLabel("Plants:");
		lblPlants.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlants.setBounds(44, 59, 202, 27);
		add(lblPlants);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 97, 316, 533);
		add(scrollPane);
		
		JLabel lblPlantSeeds = new JLabel("<html><p>");
		lblPlantSeeds.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(lblPlantSeeds);
		
		JLabel lblFertilizers = new JLabel("Fertilizers:");
		lblFertilizers.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFertilizers.setBounds(480, 59, 202, 27);
		add(lblFertilizers);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(480, 97, 316, 533);
		add(scrollPane_1);
		
		JLabel lblFert = new JLabel("<html><p>");
		lblFert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(lblFert);
		
		JLabel lblPesticides = new JLabel("Pesticides");
		lblPesticides.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPesticides.setBounds(922, 59, 202, 27);
		add(lblPesticides);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(922, 97, 316, 533);
		add(scrollPane_2);
		
		JLabel lblPesti = new JLabel("<html><p>");
		lblPesti.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_2.setViewportView(lblPesti);
		
		if (Driver.getGame().getPlayer().getStorage().getPesticides().size() > 0) {
			for (Pesticide p : Driver.getGame().getPlayer().getStorage().getPesticides())
				lblPesti.setText(lblPesti.getText() + p.toString() + "<br><br>");
		} else
			lblPesti.setText("No Pesticides in inventory.");
		
		if (Driver.getGame().getPlayer().getStorage().getFertilizers().size() > 0) {
			for (Fertilizer f : Driver.getGame().getPlayer().getStorage().getFertilizers())
				lblFert.setText(lblFert.getText() + f.toString() + "<br><br>");
		} else
			lblFert.setText("No Fertilizers in inventory.");
		
		if (Driver.getGame().getPlayer().getStorage().getPlants().size() > 0) {
			for (Plant p : Driver.getGame().getPlayer().getStorage().getPlants())
				lblPlantSeeds.setText(lblPlantSeeds.getText() + p.toString() + "<br><br>");
		} else
			lblPlantSeeds.setText("No Plants in inventory.");
	}

}

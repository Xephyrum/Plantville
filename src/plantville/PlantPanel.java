package plantville;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;

/**
 * The PlantPanel class is a component of the GUI of the game
 * which creates and displays the panel that will be used for
 * planting seeds into the field. 
 * @author James Buizon
 * @author Gabriel Santiago
 */

public class PlantPanel extends JPanel {
	private JTextField txtEnterPlantName;
	private int r;
	private int c;
	/**
	 * Creates the panel for planting seeds into the field.
	 */
	public PlantPanel(int r, int c) {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Plant seed", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		setSize(1280, 720);
		this.r = r;
		this.c = c;
		
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
	
		JLabel lblTime = new JLabel(Driver.getGame().getTimeSim().toString());
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(514, 15, 313, 27);
		add(lblTime);
		
		JLabel lblSelectPlantTo = new JLabel("Select Plant to use:");
		lblSelectPlantTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectPlantTo.setBounds(10, 53, 267, 20);
		add(lblSelectPlantTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 347, 557);
		add(scrollPane);
		
		JLabel label = new JLabel("<html><p>");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(label);
		
		JLabel lblEnterNameOf = new JLabel("Enter name of Plant seed to use:");
		lblEnterNameOf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterNameOf.setBounds(438, 118, 231, 42);
		add(lblEnterNameOf);
		
		txtEnterPlantName = new JTextField();
		txtEnterPlantName.setText("Enter plant name here");
		txtEnterPlantName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterPlantName.setBounds(438, 169, 231, 42);
		add(txtEnterPlantName);
		txtEnterPlantName.setColumns(10);
		
		for (Plant p : Driver.getGame().getPlayer().getStorage().getPlants())
			label.setText(label.getText() + p.toString() + "<br><br>");
		
		JButton btnProceed = new JButton("Proceed!");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int n = Driver.getGame().getPlayer().getStorage().searchPlant(txtEnterPlantName.getText());
					
					if (n > -1) {
						Driver.getGame().getField().getSoil(r, c).plant(Driver.getGame().getPlayer().getStorage().getPlant(n));
						Driver.getGame().getPlayer().getStorage().discardPlant(n);
						JOptionPane.showMessageDialog(null, "<html><p>" + Driver.getGame().getField().getSoil(r, c).getPlant().toString() + "<br><br> planted successfully!");
						Driver.getFrame().getMainPanel().add(new PlayArea(), "Play area");
						Driver.getGame().getTimeSim().updateTime(60);
						((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Play area");
					} else
						JOptionPane.showMessageDialog(null, "Plant not found. Please try another Plant name.");
			}
		});
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProceed.setBounds(790, 138, 139, 73);
		add(btnProceed);
		
		JLabel lblPlantingSoil = new JLabel("Planting @ Soil (" + r + ", " + c +").");
		lblPlantingSoil.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPlantingSoil.setBounds(438, 236, 231, 27);
		add(lblPlantingSoil);
	}
}

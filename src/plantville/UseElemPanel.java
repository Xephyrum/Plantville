package plantville;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

/**
 * The UseElemPanel class is a component of the GUI of the game 
 * which creates and displays the panel that will be used when 
 * applying pesticides and fertilizers to the soil.
 * @author James Buizon
 * @author Gab Santiago
 */

public class UseElemPanel extends JPanel {
	private int r;
	private int c;
	private JTextField txtEnterPesticideName;
	/**
	 * Creates the panel for using both pesticides and fertilizers.
	 */
	public UseElemPanel(int r, int c) {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add additives", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JLabel lblSelectPlantTo = new JLabel("Select Fertilizer to use:");
		lblSelectPlantTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectPlantTo.setBounds(10, 53, 267, 20);
		add(lblSelectPlantTo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 347, 557);
		add(scrollPane);
		
		JLabel lblFertilizer = new JLabel("<html><p>");
		lblFertilizer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(lblFertilizer);
		
		JLabel lblEnterNameOf = new JLabel("Enter name of Fertilizer to use:");
		lblEnterNameOf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterNameOf.setBounds(367, 116, 231, 42);
		add(lblEnterNameOf);
		
		JTextField txtEnterFertName = new JTextField();
		txtEnterFertName.setText("Enter Fertilizer name here");
		txtEnterFertName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterFertName.setBounds(367, 169, 231, 42);
		add(txtEnterFertName);
		txtEnterFertName.setColumns(10);
		
		if (Driver.getGame().getPlayer().getStorage().getFertilizers().size() > 0) {
			for (Fertilizer f : Driver.getGame().getPlayer().getStorage().getFertilizers())
				lblFertilizer.setText(lblFertilizer.getText() + f.toString() + "<br><br>");
		} else
			lblFertilizer.setText("No Fertilizers in inventory.");
		
		JButton btnUseFert = new JButton("Use Fertilizer!");
		btnUseFert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int n = Driver.getGame().getPlayer().getStorage().searchFertilizer(txtEnterFertName.getText());
					
					if (n > -1) {
						Driver.getGame().getField().getSoil(r, c).addElement(Driver.getGame().getPlayer().getStorage().getFertilizer(n));
						Driver.getGame().getPlayer().getStorage().discardFertilizer(n);
						JOptionPane.showMessageDialog(null, "<html><p>" + Driver.getGame().getField().getSoil(r, c).getElements().get(Driver.getGame().getField().getSoil(r, c).getElements().size() - 1) + "<br><br> added successfully!");
						Driver.getFrame().getMainPanel().add(new UseElemPanel(r, c), "Add additives");
						((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Add additives");
					} else
						JOptionPane.showMessageDialog(null, "Fertilizer not found. Please try another Fertiizer name.");
			}
		});
		btnUseFert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUseFert.setBounds(403, 270, 155, 75);
		add(btnUseFert);
		
		JLabel lblPlantingSoil = new JLabel("Using @ Soil (" + r + ", " + c + ").");
		lblPlantingSoil.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblPlantingSoil.setBounds(367, 232, 231, 27);
		add(lblPlantingSoil);
		
		JLabel lblSelectPesticideTo = new JLabel("Select Pesticide to use:");
		lblSelectPesticideTo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectPesticideTo.setBounds(646, 53, 267, 20);
		add(lblSelectPesticideTo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(646, 84, 347, 557);
		add(scrollPane_1);
		
		JLabel lblPesticide = new JLabel("<html><p>");
		lblPesticide.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_1.setViewportView(lblPesticide);
		
		if (Driver.getGame().getPlayer().getStorage().getPesticides().size() > 0) {
			for (Pesticide p : Driver.getGame().getPlayer().getStorage().getPesticides())
				lblPesticide.setText(lblPesticide.getText() + p.toString() + "<br><br>");
		} else
			lblPesticide.setText("No Pesticides in inventory.");
		
		JLabel lblEnterNameOf_1 = new JLabel("Enter name of Pesticide to use:");
		lblEnterNameOf_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterNameOf_1.setBounds(1003, 132, 231, 42);
		add(lblEnterNameOf_1);
		
		txtEnterPesticideName = new JTextField();
		txtEnterPesticideName.setText("Enter Pesticide name here");
		txtEnterPesticideName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterPesticideName.setColumns(10);
		txtEnterPesticideName.setBounds(1003, 181, 231, 42);
		add(txtEnterPesticideName);
		
		JLabel label_2 = new JLabel("Using @ Soil (" + r + ", " + c + ").");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		label_2.setBounds(1003, 240, 231, 27);
		add(label_2);
		
		JButton btnUsePesticide = new JButton("Use Pesticide!");
		btnUsePesticide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Driver.getGame().getPlayer().getStorage().searchPesticide(txtEnterPesticideName.getText());
				
				if (n > -1) {
					Driver.getGame().getField().getSoil(r, c).addElement(Driver.getGame().getPlayer().getStorage().getPesticide(n));
					Driver.getGame().getPlayer().getStorage().discardPesticide(n);
					JOptionPane.showMessageDialog(null, "<html><p>" + Driver.getGame().getField().getSoil(r, c).getElements().get(Driver.getGame().getField().getSoil(r, c).getElements().size() - 1) + "<br><br> added successfully!");
					Driver.getFrame().getMainPanel().add(new UseElemPanel(r, c), "Add additives");
					((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Add additives");
				} else
					JOptionPane.showMessageDialog(null, "Pesticide not found. Please try another Pesticide name.");
			}
		});
		btnUsePesticide.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUsePesticide.setBounds(1037, 278, 170, 75);
		add(btnUsePesticide);
	}

}

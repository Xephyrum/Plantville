package plantville;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The Tile class creates and displays the necessary icon or picture
 * to represent the state of each soil in the field.
 * @author James Buizon
 * @author Gabriel Santiago
 */

public class Tile extends JLabel {
	private int r;
	private int c;
	
        /**
         * Initializes each soil in the field with the corresponding icon depending on the state of the soil.
         * @param r Contains the row of the soil 
         * @param c Contains the column of the soil
         */
	public Tile(int r, int c)
	{
		this.r = r;
		this.c = c;
		
		if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "") {
			if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/soil.png")));
			else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga")
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Rat.png")));
			else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol")
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Snail.png")));
			else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod")
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Worm.png")));
		} else if (Driver.getGame().getField().getSoil(r, c).getPlant().getDaysToGrow() != 0){
			if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Plant_NoPest.png")));
			else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Plant_With_Rat.png")));
			else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Plant_With_Snail.png")));
			else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
				setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Plant_With_Worm.png")));
		} else {
			if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "Sitaw") {
				if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Sitaw.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Sitaw_With_Rat.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Sitaw_With_Snail.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Sitaw_With_Worm.png")));
			} else if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "Patola") {
				if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Patola.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Patola_With_Rat.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Patola_With_Snail.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Patola_With_Worm.png")));
			} else if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "Kamatis") {
				if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kamatis.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kamatis_With_Rat.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kamatis_With_Snail.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kamatis_With_Worm.png")));
			} else if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "Kalabasa") {
				if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kalabasa.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kalabasa_With_Rat.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kalabasa_With_Snail.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Kalabasa_With_Worm.png")));
			} else if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "Gumamela") {
				if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Gumamela.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Gumamela_With_Rat.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Gumamela_With_Snail.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Gumamela_With_Worm.png")));
			} else if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "Santan") {
				if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Santan.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Daga") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Santan_With_Rat.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Kohol") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Santan_With_Snail.png")));
				else if (Driver.getGame().getField().getSoil(r, c).getPest().getName() == "Uod") 
					setIcon(new ImageIcon(PlayArea.class.getResource("/plantville/Soil_With_Santan_With_Worm.png")));
			}
		}

		if (Driver.getGame().getField().getSoil(r, c).isFertile())
			setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.green));
		else
			setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.gray));
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				Object[] options = {"Plant seed", "Harvest", "Apply additives"};
				int n = JOptionPane.showOptionDialog(null, Driver.getGame().getField().getSoil(r, c).toString() + "<br><br>What would you like to do?", "Soil", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				if (n == 0) { //planting
					if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() == "") {
						if (Driver.getGame().getField().getSoil(r, c).isFertile()) {
							if (Driver.getGame().getPlayer().getStorage().getPlants().size() > 0) {
								Driver.getFrame().getMainPanel().add(new PlantPanel(r, c), "Plant seed");
								((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Plant seed");
							} else 
								JOptionPane.showMessageDialog(null, "Cannot plant, no Plant seeds in inventory.");
						} else
							JOptionPane.showMessageDialog(null, "Cannot plant on infertile Soil.");
					} else
						JOptionPane.showMessageDialog(null, "Cannot plant on Soil, Plant already available.");
				} else if (n == 1) { //harvesting
					if (Driver.getGame().getField().getSoil(r, c).getPlant().getName() != "")
						if (Driver.getGame().getField().getSoil(r, c).getPlant().getDaysToGrow() == 0) {
							JOptionPane.showMessageDialog(null, "Harvest successful! You gained " + Driver.getGame().getField().getSoil(r, c).getPlant().getHarvestPrice() + " C!");
							Driver.getGame().getPlayer().getWallet().addMoney(Driver.getGame().getField().getSoil(r, c).getPlant().getHarvestPrice());
							Driver.getGame().getField().getSoil(r, c).harvestCrops();
							Driver.getGame().getTimeSim().updateTime(65);
							Driver.getFrame().getMainPanel().add(new PlayArea(), "Play area");
							((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Play area");
						} else
							JOptionPane.showMessageDialog(null, "Cannot harvest, Plant not fully grown.");
					else
						JOptionPane.showMessageDialog(null, "Cannot harvest without a Plant.");
				} else if (n == 2) {
					if (Driver.getGame().getPlayer().getStorage().getFertilizers().size() > 0 || Driver.getGame().getPlayer().getStorage().getPesticides().size() > 0) {
						Driver.getFrame().getMainPanel().add(new UseElemPanel(r, c), "Add additives");
						((CardLayout)Driver.getFrame().getMainPanel().getLayout()).show(Driver.getFrame().getMainPanel(), "Add additives");
					} else
						JOptionPane.showMessageDialog(null, "No Fertilizers andPesticides in inventory.");
				}
			}
		});
	}
}


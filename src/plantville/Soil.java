package plantville;

import java.util.ArrayList;
import java.util.Random;

/**
* The Soil class allows the initialization of the in-game soil
* which fills up each slot in the field.
* @author James Buizon
* @author Gabriel Santiago
* @version 1.1, 7/3/2016
*/

public class Soil {
	private float fertility;
	private Plant plant;
	private Pest pest;
	private ArrayList<GameElement> elem;
	
        /**
         * Initializes the soil, randomizes its fertility, and randomizes the infestation of pests.
         */
	public Soil ()
	{
		Random rand = new Random ();
		float min = 4.0f;
		float max = 8.0f;
		float f = rand.nextFloat() * (max - min) + min;
		this.fertility = f;
		plant = new Plant();
		elem = new ArrayList<GameElement>();
		
		int m = 1;
		int mx = 20;
		int p = rand.nextInt(mx - m) + m;
		
		switch (p) {
		case 1: 
		case 2:
		case 3:
		case 4: 	
		case 5: 
		case 6: 
		case 7: 
		case 8: 
		case 9:  
		case 10: 
		case 11:
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17: pest = new Pest();
		break;
		case 18: pest = new Pest ("Kohol", 10, -1, -1);
		break;
		case 19: pest = new Pest ("Daga", 5, -5, 0);
		break;
		case 20: pest = new Pest ("Uod", 3, -3, 1);
		break;
		}
	}
	
        /**
         * Return soil's fertility.
         * @return the fertility of the soil
         */
	public float getFertility ()
	{
		return fertility;
	}
	
        /**
         * Allows to access the seed planted on the soil.
         * @return the plant that the soil contains
         * @see Plant
         */
	public Plant getPlant ()
	{
		return plant;
	}
	
        /**
         * Allows to access the pest infecting the soil.
         * @return the pest infecting the soil
         * @see Pest
         */
	public Pest getPest()
	{
		return pest;
	}
	
        /**
         * Allows the player to plant a seed in the soil
         * @param p Contains the seed that will be planted on the soil
         */
	public void plant(Plant p)
	{
		plant = p;
	}
	
        /**
         * Puts game elements into the soil
         * @param g Contains the game element that will be added to the soil
         */
	public void addElement(GameElement g)
	{
		this.elem.add(g);
	}
	
        /**
         * Checks whether the soil is fertile or not.
         * @return <code>true</code> if the soil is fertile; <code>false</code> otherwise.
         */
	public boolean isFertile ()
	{
		if (fertility >= 5.5 && fertility <= 7.0)
			return true;
		else 
			return false;
	}
	
        /**
         * Updates the soil's fertility
         * @param f Contains the value to modify the fertility of the soil
         */
	public void updateFertility (float f)
	{
		this.fertility += f;
	}
	
        /**
         * Removes the plant from the soil.
         */
	public void harvestCrops ()
	{
		this.plant.updateNumberOfHarvests();
		this.plant.setDaysToGrowToReBear();
		
		if (this.plant.getNumberOfHarvests() == 0 && this.plant.getDaysToGrow() == 0 && this.plant.getName() != "Gumamela" && this.plant.getName() != "Santan") 
			plant = new Plant();
	}
	
        /**
         * Randomizes the infestation of the pests.
         */
	public void randomizePest()
	{
		int m = 1;
		int mx = 20;
		Random rand = new Random ();
		int p = rand.nextInt(mx - m) + m;
		
		switch (p) {
		case 1: pest = new Pest();
		break;
		case 2: pest = new Pest ("Kohol", 10, -1, -1);
		break;
		case 3: pest = new Pest ("Daga", 5, -5, 0);
		break;
		case 4: pest = new Pest ("Uod", 3, -3, 1);
		break;
                case 5: 	
		case 6: 
		case 7: 
		case 8: 
		case 9: 
		case 10:  
		case 11: 
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
		case 17:
                case 18:
                case 19:
                case 20:
		}
	}
	
        /**
         * Removes dead pests from the soil.
         */
	public void checkDeadPest() 
	{
		if (this.pest.getLifeSpan() <= 0)
			this.pest = new Pest();
	}
	
        /**
         * Removes dead plants from the soil.
         */
	public void checkDeadPlant() 
	{
		if (this.plant.getName() != "" && this.plant.getPestResistance() <= 0)
			this.plant = new Plant();
	}
	
	public void checkElements()
	{
		ArrayList<GameElement> toRemove = new ArrayList<GameElement>();
		
		for (GameElement s : elem)
			if (s.getClass() == Fertilizer.class) {
				if (((Fertilizer)s).getLifeSpan() <= 0)
					toRemove.add(s);
			} else if (s.getClass() == Pesticide.class) {
				if (((Pesticide)s).getLifeSpan() <= 0)
					toRemove.add(s);
			}
		
		elem.removeAll(toRemove);
	}
	/**
         * Allows to access the game elements in the soil
         * @return the game elements in the soil
         */
	public ArrayList<GameElement> getElements()
	{
		return elem;
	}
	
	/**
         * Displays all the necessary information about the game elements in the soil
         * @return Returns the string format of all the information about the game elements in the soil
         */
        public String toString()
	{
		String s;
		s = "<html><p>" + "Fertility: " + this.fertility + "<br><br>Plant:<br>";
		
		if (plant.getName() != "")
			s += this.plant.toString();
		else
			s += "None.";
		
		s +=  "<br><br>Pest:<br>";
		
		if (pest.getName() != "")
			s += this.pest.toString();
		else
			s += "None.";
				
		s += "<br><br>Current active additives:<br>";
		
		if (elem.size() == 0)
			s += "None.";
		else {
			for (GameElement g : elem)
				s += g.toString() + "<br><br>";
		}
		
		return s;
	}
}

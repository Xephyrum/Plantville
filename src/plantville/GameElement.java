package plantville;

/**
 * The GameElement class serves as the super class for 
 * pests, pesticides, fertilizers, and plants.
 * @author Gabriel Santiago
 * @author James Buizon
 */

public abstract class GameElement {
	private String name;
	private float soilFertilityEffect;
	
	/**
         * Initializes the common attributes of pests, pesticides, fertilizers, and plants.
         */
        public GameElement()
	{
		this.name = "";
		this.soilFertilityEffect = 0.00f;
	}
	/**
         * Initializes the game elements with their specific name and effect on soil. 
         * @param name Contains the name of the game element
         * @param soilFertilityEffect Contains the fertility effect of the game element on the soil
         */
	public GameElement(String name, float soilFertilityEffect)
	{
		this.name = name;
		this.soilFertilityEffect = soilFertilityEffect;
	}
	/**
         * Allows to access the name of the game element.
         * @return the name of the game element
         */
	public String getName()
	{
		return name;
	}
	/**
         * Allows to access the fertility effect of the game element on the soil. 
         * @return the soil fertility effect of the game element
         */
	public float getSoilFertilityEffect()
	{
		return soilFertilityEffect;
	}
	
	public abstract void nextDay();
	
	public abstract String toString();
}

package plantville;

/**
 * The Pest class creates the in-game pests(kohol, daga, uod)
 * which are harmful to both the plants and the soil. 
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.0, 7/2/2016
 */

public class Pest extends GameElement {
	private int lifeSpan;
	private int plantResistanceEffect;
	
	/**
         * Initializes the pests.
         */
	public Pest()
	{
		super();
		this.lifeSpan = 0;
		this.plantResistanceEffect = 0;
	}
	
        /**
         * Initializes the pests.
         * @param name Contains the pest name
         * @param lifeSpan Contains the life span of the pest
         * @param soilFertilityEffect Contains the fertility effect of the pest towards the soil
         * @param plantResistanceEffect Contains the resistance effect of the pest towards the plant 
         */
	public Pest (String name, int lifeSpan, float soilFertilityEffect, int plantResistanceEffect)
	{
		super(name, soilFertilityEffect);
		this.lifeSpan = lifeSpan;
		this.plantResistanceEffect = plantResistanceEffect;
	}
	
        /**
         * Returns pest's life span.
         * @return the life span of the pest
         */
	public int getLifeSpan () 
	{
		return this.lifeSpan;
	}

	
        /**
         * Returns how much will be deducted from plant's pest resistance
         * @return 
         */
	public int getResistanceEffect () 
	{
		return plantResistanceEffect;
	}
	
        /**
         * Allows the manipulation pest's life span
         * @param ls Contains the value to be added to modify the life span of the pest
         */
	public void updateLifeSpan (int ls)  
	{
		this.lifeSpan += ls;
	}
	
        /**
         * Reduces the life span of the pest for every succeeding day.
         */
	public void nextDay()
	{
		this.updateLifeSpan(-1);
	}
	
        /**
         * Converts and returns the necessary information about the pest into string
         * @return the string format of the information about the pest
         */
	public String toString()
	{
		String s;
		s = "<html><p>" + super.getName() + "<br>Life span: " + this.lifeSpan + "<br>Soil pH effect: " + super.getSoilFertilityEffect() + "<br>Plant rst. effect: " + this.plantResistanceEffect;
		return s;
	}
}

    package plantville;

/**
 * The Pesticide class allows the initialization of the
 * in-game pesticides(UNS, S5, S7) which can be used 
 * to improve soil fertility and to affect pest resistance of plants.
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.0, 7/2/2016
 */

public class Pesticide extends GameElement {
    private int lifeSpan;
    private int price;
    private int pestEffect;
    private int plantResistanceEffect;
    
    /**
     * Initializes the pesticides.
     */
    public Pesticide() 
    {
        super();
        this.lifeSpan = 0;
        this.price = 0;
        this.pestEffect = 0;
        this.plantResistanceEffect = 0;
    }
    /**
     * Additional constructor to initialize pesticides with the desired values
     * @param name Contains the pesticide name
     * @param lifeSpan Contains the life span of the pesticide
     * @param price Contains the selling price of the pesticide
     * @param pestEffect Contains the pest effect of the pesticide
     * @param plantResistanceEffect Contains resistance effect of the pesticide towards the plant
     * @param soilFertilityEffect Contains the fertility effect of the pesticide towards the soil
     */
    public Pesticide(String name, int lifeSpan, int price, int pestEffect, int plantResistanceEffect, float soilFertilityEffect) 
    {
        super(name, soilFertilityEffect);
        this.lifeSpan = lifeSpan;
        this.price = price;
        this.pestEffect = pestEffect;
        this.plantResistanceEffect = plantResistanceEffect;
    }
    
    /**
     * Returns the duration of the pesticide's effect on soil
     * @return the life span of the pesticide
     */
    public int getLifeSpan() 
    {
        return lifeSpan;
    }
    
    /**
     * Returns the amount to be deducted from the player's wallet when pesticides are bought
     * @return the selling price of the pesticide
     */
    public int getPrice() 
    {
        return price;
    }
    
    /**
     * Returns how much life span will be deducted from the pest
     * @return the pest effect of the pesticide
     */
    public int getPestEffect()   
    {
        return pestEffect;
    }
    
    /**
     * Returns how much will be deducted from the plant's pest resistance
     * @return the plant resistance effect of the pesticide
     */
    public int getResistanceEffect() 
    {
        return plantResistanceEffect;
    }
    
    /**
     * Modifies how long will the effects of the pesticide last.
     */
    public void updateLifeSpan() 
    {
    	this.lifeSpan--;
    }
    
    /**
     * Reduces the days of the pesticide's effectiveness in the soil for every succeeding day.
     */
    public void nextDay()
    {
    	this.updateLifeSpan();
    }
    /**
     * Converts and returns the necessary information about the pesticide into string
     * @return the string format of the information about the pesticide
     */
    public String toString()
    {
    	String s;
    	s = "<html><p>" + super.getName() + "<br>Life span: " + lifeSpan + "<br>Pest effect: " + pestEffect + "<br>Plant rst. effect: " + plantResistanceEffect + "<br>Soil pH effect: " + super.getSoilFertilityEffect();
    	return s;
    }
}

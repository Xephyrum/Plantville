package plantville;

/**
 * The Fertilizer class allows the production of the
 * in-game fertilizers(kitchen scraps, field scraps, manure)
 * to help make the soil fertile. 
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.1, 7/3/2016
 */

public class Fertilizer extends GameElement {
	private int price;
	private int lifeSpan;
	
        /**
         * Initializes the fertilizers
         * @param name Contains the fertilizer name
         * @param price Contains the selling price of the fertilizer
         * @param lifeSpan Contains the days of effectivity of the fertilizer
         * @param fertilityEffect Contains the fertility effect of the fertilizer towards the soil
         */
	public Fertilizer (String name, int price, int lifeSpan, float fertilityEffect) 
	{
		super(name, fertilityEffect);
		this.price = price;
		this.lifeSpan = lifeSpan;
	}
	
        /**
         * Returns fertilizer's price.
         * @return the selling price of the fertilizer
         */
	public int getPrice () 
	{
		return price;
	}
	
        /**
         * Returns fertilizer's life span.
         * @return the life span of the fertilizer
         */
	public int getLifeSpan ()
	{
		return lifeSpan;
	}

        /**
         * Reduces fertilizer's life span.
         */
    public void updateLifeSpan () //new
	{
		this.lifeSpan--;
	}
	
    /**
     *  Reduces the days of the fertilizer's effectiveness in the soil for every succeeding day.
     */
    public void nextDay()
    {
    	this.updateLifeSpan();
    }
    /**
     * Converts and returns the necessary information about the fertilizer into string
     * @return the string format of the information about the fertilizer
     */
    public String toString()
    {
    	String s;
    	s = "<html><p>" + super.getName() + "<br>Life span: " + lifeSpan + "<br>Soil pH effect: " + super.getSoilFertilityEffect();
    	return s;
    }
}

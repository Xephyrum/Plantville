package plantville;

/**
 * The Plant class allows the initialization of the 
 * in-game plants which can be harvested to earn money
 * and to prevent from losing in the game.
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.1, 7/3/2016
 */

public class Plant extends GameElement {
	private int daysToGrow;
	private int daysToBear;
	private int numberOfHarvests;
	private int harvestPrice;
	private int seedPrice;
	private int pestResistance;
	
        /**
         * Initializes the plants
         */
	public Plant () 
	{
		super();
		this.daysToGrow = 0;
		this.daysToBear = 0;
		this.numberOfHarvests = 0;
		this.harvestPrice = 0;
		this.seedPrice = 0;
		this.pestResistance = 0;
	}
	
        /**
         * Additional constructor to initialize plants with their specific stats
         * @param name Contains the plant name
         * @param daysToGrow Contains the days needed for the plant to grow
         * @param daysToBear Contains the days needed for the plant to bear 
         * @param numberOfHarvests Contains the number of times the plant can be harvested
         * @param seedPrice Contains the seed price
         * @param harvestPrice Contains the harvest price of the plant
         * @param soilEffect Contains the effect on the soil fertility 
         * @param pestResistance Contains the resistance of the plant against pests
         */
	public Plant (String name, int daysToGrow, int daysToBear, int numberOfHarvests, int seedPrice, int harvestPrice, float soilEffect, int pestResistance)
	{
		super(name, soilEffect);
		this.daysToGrow = daysToGrow;
		this.daysToBear = daysToBear;
		this.numberOfHarvests = numberOfHarvests;
		this.harvestPrice = harvestPrice;
		this.seedPrice = seedPrice;
		this.pestResistance = pestResistance;
	}
	
        /**
         * Returns the days needed for the plant to grow.
         * @return the days before the plant grows
         */
	public int getDaysToGrow () 
	{
		return daysToGrow;
	}
	
        /**
         * Returns the days needed for the plant to bear.
         * @return the days before the plant bears
         */
	public int getDaysToBear () 
	{
		return daysToBear;
	}
	
        /**
         * Returns the number of times a plant can be harvested
         * @return the number of harvests of the plant
         */
	public int getNumberOfHarvests () //
	{
		return numberOfHarvests;
	}
	
        /**
         * Returns the amount to be added to the player's wallet during harvest.
         * @return the harvest price of the plant
         */
	public int getHarvestPrice () 
	{
		return harvestPrice;
	}
	
        /**
         * Returns the amount to be deducted from the player's wallet when seeds are bought.
         * @return the seed price
         */
	public int getSeedPrice () 
	{
		return seedPrice;
	}
 
        /**
         * Returns plant's resistance against pests.
         * @return the pest resistance of the plant
         */       
	public int getPestResistance () 
	{
		return pestResistance;
	}
	
        /**
         * Manipulates plant's resistance against pests.
         * @param ps Contains the plant resistance effect from pests or pesticides
         */
	public void updatePestResistance (int ps) 
	{
		pestResistance += ps;
	}
        
        /**
         * Makes the plant available for harvest by reducing it's days to grow.
         */
    public void updateDaysToGrow () 
	{
		daysToGrow--;
		
		if (daysToGrow < 0)
			daysToGrow = 0;
	}
	
        /**
         * Reduces the number of harvests.
         */
	public void updateNumberOfHarvests () 
	{
		numberOfHarvests--;
	}
	
        /**
         * Resets the days needed for multi-bearing plants to grow. 
         */
	public void setDaysToGrowToReBear()
	{
		daysToGrow = daysToBear;
	}
	
	/**
         * Reduces the days needed for plants to grow for each succeeding day.
         */
	public void nextDay()
	{
		this.updateDaysToGrow();
	}
	
        /**
         * Converts and returns the necessary information about the plant into string
         * @return the string format of the information about the plant
         */
	public String toString()
	{
		String s;
		s = "<html><p>" + super.getName() + "<br>Days to grow: " + daysToGrow + "<br>Days to re-bear: " + daysToBear + "<br>Number of harvests: " + numberOfHarvests + "<br>Harvest price: " + harvestPrice + "<br>Soil pH effect: " + super.getSoilFertilityEffect() + "<br>Pest resistance: " + pestResistance;
		return s;
	}
}

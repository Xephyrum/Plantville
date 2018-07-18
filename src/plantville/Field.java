package plantville;

/**
* The Field class initializes a two-dimensional grid
* that represents the planting area. 
* @author James Buizon
* @author Gabriel Santiago
* @version 1.1, 7/3/2016
*/

public class Field {
	private Soil[][] soil;
	
        /**
         * Initializes the in-game field.
         */
	public Field ()
	{
		soil = new Soil[10][20];
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
				soil[i][j] = new Soil ();
	}
	/**
         * Allows to access a certain soil in the field.
         * @param x Contains the row of the soil to be accessed
         * @param y Contains the column of the soil to be accessed
         * @return the soil to be accessed
         * @see Soil
         */
	public Soil getSoil (int x, int y)
	{
		return soil[x][y];
	}
	
        /**
         * Checks the fertility of the soil to determine if the game is already over.
         * @return <code> false</code> if the game is already over; <code>true</code> otherwise.
         */
	public boolean isPlayable ()
	{
		boolean result = false;
		
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
				if (soil[i][j].isFertile())
					result = true;
		
		return result;
	}
	
        /**
        * Allows the plants to grow.
        */
	public void growPlants () 
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
				if (soil[i][j].getPlant().getName() != "") {
					soil[i][j].getPlant().updateDaysToGrow();
					soil[i][j].updateFertility(soil[i][j].getPlant().getSoilFertilityEffect());
				}
	}
	/**
         * Applies pest effects both to the plant and to the soil.
         */
	public void pestEffect () 
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
				if (soil[i][j].getPest().getName() != "") {
					soil[i][j].getPest().updateLifeSpan(1);
					if (soil[i][j].getPlant().getName() != "") {
						soil[i][j].getPlant().updatePestResistance(soil[i][j].getPest().getResistanceEffect());
						soil[i][j].checkDeadPlant();
					}
					soil[i][j].updateFertility(soil[i][j].getPest().getSoilFertilityEffect());
					soil[i][j].checkDeadPest();
					
				}
	}
	/**
         * Applies the effects of pesticides or fertilizers.
         */
	public void elementsEffect()
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++) 
				if (soil[i][j].getElements().size() > 0) {
					for (GameElement g : soil[i][j].getElements()) {
						if (g.getClass() == Pesticide.class) {
							if (soil[i][j].getPest().getName() != "")
								soil[i][j].getPest().updateLifeSpan(((Pesticide)g).getPestEffect());
								soil[i][j].updateFertility(g.getSoilFertilityEffect());
						} else
							if (g.getClass() == Fertilizer.class) {
								soil[i][j].updateFertility(g.getSoilFertilityEffect());
							}
						g.nextDay();
					}
				}
				
	}
	/**
         * Removes all the unnecessary game elements from the field.
         */
	public void checkElements()
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++) {
				soil[i][j].checkElements();
				soil[i][j].checkDeadPest();
				soil[i][j].checkDeadPlant();
			}
	}
	
        /**
         * Randomizes the infestation of the pests in the field.
         * Calls the method in for randomizing pests in the soil class.
         */
	public void randomizePest () 
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
				if (soil[i][j].getPest().getName() == "") 
					soil[i][j].randomizePest();
	}
}

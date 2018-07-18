package plantville;

import java.util.ArrayList;

/**
 * The Storage class allows the player to store
 * and to keep track of all valuable items obtained 
 * thus far for later use. 
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.0, 7/2/2016
 */

public class Storage {
    
    private ArrayList<Plant> plants;
    private ArrayList<Fertilizer> fertilizers;
    private ArrayList<Pesticide> pesticides;
    
    /**
     * Initializes the storage system.
     */
    public Storage() 
    {
        this.plants = new ArrayList<Plant>();
        this.fertilizers = new ArrayList<Fertilizer>();
        this.pesticides = new ArrayList<Pesticide>();
    }
    
    /**
     * The method is used to access the specified plant in the storage.
     * @param i Contains the index of the plant the player wants to access
     * @return the plant based on the item number specified by the player
     * @see Plant
     */
    public Plant getPlant (int i) 
    {
    	return plants.get(i);
    }
    
    /**
     * The method is used to access the specified fertilizer in the storage.
     * @param i Contains the index of the fertilizer the player wants to access
     * @return the fertilizer based on the item number specified by the player
     * @see Fertilizer
     */
    public Fertilizer getFertilizer (int i) 
    {
    	return fertilizers.get(i);
    }
    
    /**
     * The method is used to access the specified pesticide in the storage.
     * @param i Contains the index of the pesticide the player wants to access
     * @return the pesticide based on the item number specified by the player
     * @see Pesticide
     */
    public Pesticide getPesticide (int i) 
    {
    	return pesticides.get(i);
    }
    
    
    /**
     * Stores the specified seed/plant to the storage.
     * @param p Accepts an object of type Plant to be stored in the storage
     */
    public void addPlants(Plant p) 
    {
        plants.add(p);
    }
    
    /**
     * Stores the specified fertilizer to the storage.
     * @param f Accepts an object of type Fertilizer to be stored in the storage
     */
    public void addFertilizers(Fertilizer f) 
    {
        fertilizers.add(f);
    }
    
    /**
     * Stores the specified pesticide to the storage.
     * @param p Accepts an object of type Pesticide to be stored in the storage
     */
    public void addPesticides(Pesticide p) 
    {
        pesticides.add(p);
    }
    
    /**
     * Removes a certain seed from the storage.
     * @param i Contains the index of the seed/plant that should be removed from the storage.
     */
    public void discardPlant(int i) 
    {
        plants.remove(i);
    }
    
    /**
     * Removes a certain fertilizer from the storage.
     * @param i Contains the index of the fertilizer that should be removed from the storage.
     */
    public void discardFertilizer(int i) 
    {
        fertilizers.remove(i);
    }
    
    /**
     * Removes a certain pesticide from the storage.
     * @param i Contains the index of the pesticide that should be removed from the storage.
     */
    public void discardPesticide(int i) 
    {
        pesticides.remove(i);
    }
    /**
     * Allows access to the ArrayList of seeds in the storage.
     * @return the ArrayList of seeds in the storage
     */
    public ArrayList<Plant> getPlants()
    {
    	return plants;
    }
    /**
     * Allows access to the ArrayList of fertilizers in the storage.
     * @return the ArrayList of fertilizers in the storage
     */
    public ArrayList<Fertilizer> getFertilizers()
    {
    	return fertilizers;
    }
    /**
     * Allows access to the ArrayList of pesticides in the storage
     * @return the ArrayList of pesticides in the storage
     */
    public ArrayList<Pesticide> getPesticides()
    {
    	return pesticides;
    }
    
    /**
     * Searches for the plant in the storage. 
     * @param s The name of the plant to be searched.
     * @return The index of the plant in the ArrayList if it exists, otherwise, it returns -1.
     */
    public int searchPlant(String s)
    {
    	for (int i = 0; i < plants.size(); i++)
    		if (s.equalsIgnoreCase(plants.get(i).getName()))
    			return i;
    	
    	return -1;
    }
    /**
     * Searches for the fertilizer in the storage.
     * @param s The name of the fertilizer to be searched. 
     * @return The index of the fertilizer in the ArrayList if it exists, otherwise, it returns -1.
     */
    public int searchFertilizer(String s)
    {
    	for (int i = 0; i < fertilizers.size(); i++)
    		if (s.equalsIgnoreCase(fertilizers.get(i).getName()))
    			return i;
    	
    	return -1;
    }
    /**
     * Searches for the pesticide in the storage.
     * @param s The name of the pesticide to be searched.
     * @return The index of the pesticide in the ArrayList if it exists, otherwise, it returns -1.
     */
    public int searchPesticide(String s)
    {
    	for (int i = 0; i < pesticides.size(); i++)
    		if (s.equalsIgnoreCase(pesticides.get(i).getName()))
    			return i;
    	
    	return -1;
    }
}

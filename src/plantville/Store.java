package plantville;

import java.util.ArrayList;

/**
 * The Store class initializes the in-game shop
 * where the player can buy seeds, fertilizers, and
 * pesticides for the field. 
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.0, 7/2/2016
 */

public class Store {
    
    private ArrayList<Plant> plants;
    private ArrayList<Fertilizer> fertilizers;
    private ArrayList<Pesticide> pesticides;
     
    /**
     * Initializes the store and all the items sold in it.
     */
    public Store() 
    {
        this.plants = new ArrayList<Plant>();
        this.fertilizers = new ArrayList<Fertilizer>();
        this.pesticides = new ArrayList<Pesticide>();
        
        Plant sitaw = new Plant("Sitaw", 4, 0, 1, 10, 15, 0.05f, 5);
        Plant patola = new Plant("Patola", 1, 0, 1, 15, 25, -0.05f, 10);
        Plant kalabasa = new Plant("Kalabasa", 7, 3, 3, 20, 20, -0.10f, 10);
        Plant kamatis = new Plant("Kamatis", 6, 3, 2, 10, 15, 0.10f, 5);
        Plant gumamela = new Plant("Gumamela", 8, 0, 0, 70, 0, 0.05f, 30);
        Plant santan = new Plant("Santan", 5, 0, 0, 60, 0, -0.05f, 20);
        
        plants.add(sitaw);
        plants.add(patola);
        plants.add(kalabasa);
        plants.add(kamatis);
        plants.add(gumamela);
        plants.add(santan);
        
        Fertilizer ks = new Fertilizer ("Kitchen Scraps", 3, 1, 0.01f);
        Fertilizer fs = new Fertilizer ("Field Scraps", 6, 3, 0.05f);
        Fertilizer m = new Fertilizer ("Manure", 10, 5, 1.00f);
        
        fertilizers.add(ks);
        fertilizers.add(fs);
        fertilizers.add(m);
        
        Pesticide uns = new Pesticide ("UNS", 1, 3, -1, 0, 0);
        Pesticide s5 = new Pesticide ("S5", 2, 7, -2, -5, 0);
        Pesticide s7 = new Pesticide ("S7", 3, 10, -9999, -3, 1.00f);
        
        pesticides.add(uns);
        pesticides.add(s5);
        pesticides.add(s7);
        
    }
    
    /**
     * The method is used to access the specified plant sold in the store.
     * @param i Contains the index of the seed the player wants to buy from the store
     * @return the selected seed the player wants to buy
     */
    public Plant getPlant(int i) 
    {
    	return plants.get(i);
    }
    
    /**
     * The method is used to access the specified fertilizer sold in the store.
     * @param i Contains the index of the fertilizer the player wants to buy from the store
     * @return the selected fertilizer the player wants to buy
     */
    public Fertilizer getFertilizer(int i)
    {
    	return fertilizers.get(i);
    }
    
    /**
     * The method is used to access the specified pesticide sold in the store
     * @param i Contains the index of the pesticide the player wants to buy from the store
     * @return the selected pesticide the player wants to buy
     */
    public Pesticide getPesticide(int i)
    {
    	return pesticides.get(i);
    }
}

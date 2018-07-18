package plantville;

/**
 * The God class is in charge of all the operations
 * regarding the in-game time. 
 * @author James Buizon
 * @author Gabriel Santiago
 * @version 1.1, 7/3/2016
 */

public class God {
	private int min;
	private int hrs;
	private int day;

        /**
         * Initializes the in-game time.
         */		
	public God ()
	{
		this.min = 0;
		this.hrs = 0;
		this.day = 1;
	}

        /**
         * Updates the in-game time for every action made.
         * @param m Contains the corresponding minutes/hours to update the current time
         * @return <code>true</code> if time has been completely reset for the next day; <code>false</code> otherwise.
         */	
	public boolean updateTime (int m)
	{
		min += m;
		
		while (min >= 60) {
			hrs++;
			min -= 60;
		}
		
		if (hrs >= 24) {
			day++;
			hrs -= 24;
			return true;
		}
		
		return false;
	}
	
        /**
         * Gives the player the option to end the day
         */
	public void endDay () //new
	{
		day++;
	}
	
	/**
         * Displays the current time in the game.
         */
	public void display ()
	{
		System.out.printf("Day %02d  -  %02d:%02d", day, hrs, min);
		System.out.println();
	}
	
        /**
         * Converts and returns the necessary information about the in-game time
         * @return the string format of the information about the in-game time
         */
	public String toString()
	{
		String s = String.format("Day %02d  -  %02d:%02d", day, hrs, min);
		return s;
	}
}

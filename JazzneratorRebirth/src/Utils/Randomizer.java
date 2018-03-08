package Utils;

import java.util.Random;

public abstract class Randomizer {
	public static int run(int min, int max){		
		Random rand = new Random();
	    int randomNum = (rand.nextInt((max - min) + 1)) + min;

	    return randomNum;			
	}
}

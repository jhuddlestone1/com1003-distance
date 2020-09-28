// COM1003 Java Programming
// Autumn Semester 2018-19
// Programming Assignment 1

// Jamie Huddlestone
// 170164274

import sheffield.*;

public class Distance {
	public static void main(String[] args) {
		
		EasyReader in = new EasyReader();
		EasyWriter out = new EasyWriter();
		
		final double MILES_PER_KILOMETER = 0.62137;
		final double YARDS_PER_MILE = 1760;
		
		double distanceInKilometers = in.readDouble("What distance in kilometers shall I convert? ");
		double distanceInMiles = distanceInKilometers * MILES_PER_KILOMETER;
		double distanceInYards = distanceInMiles * YARDS_PER_MILE;
		
		int distanceWholeMiles = (int) Math.floor(distanceInMiles);
		int distanceRemainingYards = (int) Math.round(distanceInYards - distanceWholeMiles * YARDS_PER_MILE);
		
		out.print("In miles that is ");
		out.println(distanceInMiles, 3);
		out.println("Or "+ distanceWholeMiles +" miles and about "+ distanceRemainingYards +" yards");
	}
}
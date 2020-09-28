// COM1003 Java Programming
// Autumn Semester 2018-19
// Programming Assignment 1

// Jamie Huddlestone
// 170164274


// class EasyReader, EasyWriter, EasyGraphics
import sheffield.*;

public class Distance {
    public static void main(String[] args) {
        
        // Set up console read/write
        EasyReader in = new EasyReader();
        EasyWriter out = new EasyWriter();
        
        // Constants for distance conversion
        final double MILES_PER_KILOMETER = 0.62137;
        final double YARDS_PER_MILE = 1760;
        
        // Get distance in km from user prompt and convert to miles and yards
        double distanceInKilometers = in.readDouble("What distance in kilometers shall I convert? ");
        double distanceInMiles = distanceInKilometers * MILES_PER_KILOMETER;
        int distanceWholeMiles = (int) Math.floor(distanceInMiles);
        double distanceRemainderMiles = distanceInMiles - distanceWholeMiles;
        int distanceRemainingYards = (int) Math.round(distanceRemainderMiles * YARDS_PER_MILE);
        
        // Output distance in miles and yards
        out.print("In miles that is ");
        out.println(distanceInMiles, 3);
        
        out.print("Or "+ distanceWholeMiles +" miles and about ");
        out.print(distanceRemainingYards, 4);
        out.println(" yards");
        
        
        /*** Stretch goal: allow the user to make the units file as long as they like! ***/
        
        EasyReader unitsFile = new EasyReader("units.txt");
        String unitsFileString = "";
        
        // Read 'units.txt' file as a String and process it into an array for easy looping
        while (!unitsFile.eof()) {
            unitsFileString += "\n"+ unitsFile.readString();
        }
        String[] unitsFileProcessed = unitsFileString.
            replace("One mile is", "").
            replace("\n", " ").
            split(" ");
        
        // Loop through the processed file data and output in the same format as with miles and yards
        for (String data : unitsFileProcessed) {
            
            // Ignore blank lines
            if (data.length() > 0) {
                
                try {
                    // Attempt to extract a double representing a number of units per mile...
                    double unitsPerMile = Double.valueOf(data);
                    int distanceRemainderUnits = (int) Math.round(distanceRemainderMiles * unitsPerMile);
                    out.print("Or "+ distanceWholeMiles +" miles and about ");
                    out.print(distanceRemainderUnits, 4);
                }
                catch (NumberFormatException err) {
                    // ...else assume that this line represents the unit name for the previous numeric value.
                    out.println(" "+ data);
                }
            }
        }
    }
}
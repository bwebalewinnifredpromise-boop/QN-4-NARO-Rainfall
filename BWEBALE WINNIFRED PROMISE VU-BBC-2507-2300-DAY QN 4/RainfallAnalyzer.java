import java.util.Random;

public class RainfallAnalyzer {
    public static void main(String[] args) {
        double[] rainfallReadings = new double[30];
        Random random = new Random();
        
        double totalRainfall = 0;
        int wetDaysCount = 0;

        // 1. Generate 30 daily rainfall readings between 0 and 60 mm
        System.out.println("--- NARO Daily Rainfall Readings (Namulonge Farm) ---");
        for (int i = 0; i < rainfallReadings.length; i++) {
            // Generates value from 0.0 to 60.0
            rainfallReadings[i] = random.nextDouble() * 60.0;
            System.out.printf("Day %02d: %.2f mm\n", (i + 1), rainfallReadings[i]);
            
            // 2. Accumulate total
            totalRainfall += rainfallReadings[i];
            
            // 3. Count wet days (> 30 mm)
            if (rainfallReadings[i] > 30.0) {
                wetDaysCount++;
            }
        }

        double averageRainfall = totalRainfall / rainfallReadings.length;
        
        // 4. Classify month using if-else-if structure
        String climateClassification;
        if (totalRainfall <= 300.0) {
            climateClassification = "Dry";
        } else if (totalRainfall < 600.0) {
            climateClassification = "Normal";
        } else {
            climateClassification = "Flood-risk";
        }

        // Display Summary Reports
        System.out.println("\n--- Monthly Climate Analytical Summary ---");
        System.out.printf("Total Monthly Rainfall   : %.2f mm\n", totalRainfall);
        System.out.printf("Average Daily Rainfall   : %.2f mm\n", averageRainfall);
        System.out.println("Number of Wet Days (>30mm): " + wetDaysCount + " days");
        System.out.println("Seasonal Classification   : " + climateClassification);
    }
}
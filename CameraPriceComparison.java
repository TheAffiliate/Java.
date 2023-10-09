package camerapricecomparison;


public class CameraPriceComparison {

    
    public static void main(String[] args) {
        
        // Defining the camera manufacturers and their prices for DSLR and Mirrorless cameras
        String[] manufacturers = {"CANON", "SONY", "NIKON"};
        int[][] cameraPrices = {
            {10500, 8500}, // CANON
            {9500, 7200},  // SONY
            {12000, 8000}  // NIKON
        };
        
        // Calculate the price difference and find the manufacturer with the greatest difference
        int maxDifference = 0;
        String maxDiffManufacturer = "";

        // Display a header
        System.out.println("===========================");
        System.out.println("Camera Technology Report");
        System.out.println("===========================\n");

        // Display the table header
        System.out.println("====================================================");
        System.out.printf("%-10s %-12s %-12s %-10s\n", "Manufacturer", "Mirrorless", "DSLR", "Difference");
        System.out.println("====================================================");

        for (int i = 0; i < manufacturers.length; i++) {
            String manufacturer = manufacturers[i];
            int mirrorlessPrice = cameraPrices[i][0];
            int dslrPrice = cameraPrices[i][1];
            int difference = mirrorlessPrice - dslrPrice;

            // Display the manufacturer, mirrorless price, DSLR price, and difference
            System.out.printf("%-10s R%-10d R%-10d R%-8d", manufacturer, mirrorlessPrice, dslrPrice, difference);

            // Check if the difference is greater than or equal to R2,500 and display stars accordingly
            if (difference >= 2500) {
                System.out.print(" ***");
            }
            
             System.out.println();

            // Update the manufacturer with the greatest difference
            if (difference > maxDifference) {
                maxDifference = difference;
                maxDiffManufacturer = manufacturer;
            }
        }

        // Display the manufacturer with the greatest difference
        System.out.println("\nManufacturer with the greatest price difference: " + maxDiffManufacturer); 
        System.out.println("=========================================================");
        
        System.out.println("Built By: Katlego Sebona/ST10239864");
        
    }    
}

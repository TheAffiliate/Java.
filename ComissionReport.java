
package comissionreport;

// Define the iEstateAgent interface
interface iEstateAgent {
    String getAgentName();
    double getPropertyPrice();
    double getAgentCommission();
}

// Define the abstract EstateAgent class
abstract class EstateAgent implements iEstateAgent {
    private final String agentName;
    private final double propertyPrice;

    public EstateAgent(String agentName, double propertyPrice) {
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
    }
    
     @Override
    public String getAgentName() {
        return agentName;
    }

    @Override
    public double getPropertyPrice() {
        return propertyPrice;
    }

    @Override
    public double getAgentCommission() {
        return 0.20 * propertyPrice; // 20% commission
    }
}

// Define the EstateAgentSales subclass
class EstateAgentSales extends EstateAgent {
    public EstateAgentSales(String agentName, double propertyPrice) {
        super(agentName, propertyPrice);
    }

    public void printPropertyReport() {
        System.out.println("           ESTATE AGENT REPORT:");
        System.out.println("--------------------------------------------");
        System.out.println("Estate Agent: " + getAgentName());
        System.out.println("Property Sale Price: R" + getPropertyPrice());
        System.out.println("Estate Agent Commission: R" + getAgentCommission());
        System.out.println("--------------------------------------------");
    }
}

public class ComissionReport { 
    public static void main(String[] args) {
      // Instantiate the EstateAgentSales class
        EstateAgentSales estateAgent1 = new EstateAgentSales("Katlego Sebona", 1500000.0);
        EstateAgentSales estateAgent2 = new EstateAgentSales("Tshepo Williams", 800000.0);

        // Print property reports for estate agents
        estateAgent1.printPropertyReport();
        estateAgent2.printPropertyReport();   
    }
    
}

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Simulation simulation;
        ArrayList<Item> item;
        ArrayList<Rocket> u1ArrayList;

        simulation = new Simulation("Phase-1.txt");
        item = simulation.loadItems();
        u1ArrayList = simulation.loadU1(item);

        System.out.println("Result for Phase-1 : \n");
        System.out.println("Total budget for U1 rocket is $" + simulation.runSimulation(u1ArrayList) + " Million.");

        u1ArrayList = simulation.loadU2(item);
        System.out.println("Total budget for U2 rocket is $" + simulation.runSimulation(u1ArrayList) + " Million.");

        simulation = new Simulation("Phase-2.txt");
        item = simulation.loadItems();
        u1ArrayList = simulation.loadU1(item);

        System.out.println("\nResult for Phase-2 : \n");
        System.out.println("Total budget for U1 rocket is $ " + simulation.runSimulation(u1ArrayList) + " Million.");

        u1ArrayList = simulation.loadU2(item);
        System.out.println("Total budget for U2 rocket is $ " + simulation.runSimulation(u1ArrayList) + " Million.");
    }
}

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {

    private Scanner scanner;
    private File file;

    public Simulation(String fileName) {
        try {
            file = new File(fileName);
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Error in loading file. " + e);
            System.exit(0);
        }
    }

    public ArrayList<Item> loadItems() {

        /**
         * Method used to load items from a text file in the ArrayList of items.
         *
         * @return ArrayList<Items> It returns an ArrayList of Items.
         */
        ArrayList<Item> items = new ArrayList<>();
        Item item;
        String[] temp;

        while (scanner.hasNextLine()) {
            temp = scanner.nextLine().split("=");
            item = new Item();
            item.setName(temp[0]);
            item.setWeight(Integer.parseInt(temp[1]));
            items.add(item);
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemArrayList) {

        /**
         * Method used to create U1 rockets.
         *
         * @param itemArrayList This takes the ArrayList of Item object.
         *
         * @return ArrayList<U1> It returns the ArrayList of those U1 rockets that are fully loaded.
         */

        ArrayList<Rocket> u1ArrayList = new ArrayList<>();
        U1 u1 = new U1();

        for (Item item : itemArrayList) {
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                u1ArrayList.add(u1);
                u1 = new U1();
            }
        }
        return u1ArrayList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemArrayList) {

        /**
         * Method used to create U2 rockets.
         *
         * @param itemArrayList This takes the ArrayList of Item object.
         *
         * @return ArrayList<U2> It returns the ArrayList of those U2 rockets that are fully loaded.
         */

        ArrayList<Rocket> u2ArrayList = new ArrayList<>();
        U2 u2 = new U2();

        for (Item item : itemArrayList) {
            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                u2ArrayList.add(u2);
                u2 = new U2();
            }
        }
        return u2ArrayList;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {

        /**
         * Method used to run the simulation for U1 rockets.
         *
         * @param rockets This takes the ArrayList of U1/U2 type Rockets.
         *
         * @return int It returns the total budget required to send all U1 rockets.
         */

        int totalBudget = 0;
        boolean hasNotLaunchLand;
        Iterator<Rocket> iterator = rockets.iterator();

        while (iterator.hasNext()) {
                Rocket rocket = iterator.next();
                hasNotLaunchLand = true;

                while (hasNotLaunchLand) {
                    if (rocket.launch()) {
                        if (rocket.land()) {
                            totalBudget += rocket.getCost();
                            hasNotLaunchLand = false;
                        } else {
                            totalBudget += rocket.getCost();
                        }
                    } else {
                        totalBudget += rocket.getCost();
                    }
                }
            }


//        if (rockets.get(0) instanceof U1) {
//
//            while (iterator.hasNext()) {
//
//                U1 u1 = (U1) iterator.next();
//                hasNotLaunchLand = true;
//
//                while (hasNotLaunchLand) {
//                    if (u1.launch()) {
//                        if (u1.land()) {
//                            totalBudget += u1.getCost();
//                            hasNotLaunchLand = false;
//                        } else {
//                            totalBudget += u1.getCost();
//                        }
//                    } else {
//                        totalBudget += u1.getCost();
//                    }
//                }
//            }
//        } else if (rockets.get(0) instanceof U2) {
//
//            while (iterator.hasNext()) {
//
//                U2 u2 = (U2) iterator.next();
//                hasNotLaunchLand = true;
//
//                while (hasNotLaunchLand) {
//                    if (u2.launch()) {
//                        if (u2.land()) {
//                            totalBudget += u2.getCost();
//                            hasNotLaunchLand = false;
//                        } else {
//                            totalBudget = totalBudget + u2.getCost();
//                        }
//                    } else {
//                        totalBudget += u2.getCost();
//                    }
//                }
//            }
//        }
        return totalBudget;
    }
}

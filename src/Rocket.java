public class Rocket implements SpaceShip {

    private final int initialWeight;
    private int currentWeight;
    private final int maxWeight;
    private final int cost;

    public Rocket(int initialWeight, int maxWeight, int cost) {
        this.initialWeight = initialWeight;
        this.currentWeight = initialWeight;
        this.maxWeight = maxWeight;
        this.cost = cost;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getInitialWeight() {
        return initialWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {

        /**
         * Method used to check if the rocket can carry the item or not.
         *
         * @param item It is parameter of type Item.
         *
         * @return boolean It returns either true or false.
         */

        if ((item.getWeight() + this.currentWeight) < this.maxWeight) {
            return true;
        }
        return false;
    }

    @Override
    public void carry(Item item) {

        /**
         * Method used to update the current weight of the rocket.
         *
         * @param item It is parameter of type Item.
         *
         */

        this.currentWeight += item.getWeight();
    }
}

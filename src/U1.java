public class U1 extends Rocket {

    public U1() {
        super(10000, 18000, 100);
    }

    @Override
    public boolean launch() {

        /**
         * Method used to check if the rocket can successfully launch or not.
         *
         * @return It returns the value true if the rocket can launch successfully otherwise it will return false.
         */

        double launchExplosion = (5 * ((this.getCurrentWeight() - this.getInitialWeight()) / (double) (this.getMaxWeight() - this.getInitialWeight()))) / 100.0;
        if (randomNumberGenerator() >= launchExplosion) {
            return true;
        }
        return false;
    }

    @Override
    public boolean land() {

        /**
         * Method used to check if the rocket can successfully land or not.
         *
         * @return It returns the value true if the rocket can land successfully otherwise it will return false.
         */

        double landingCrash = (1 * ((this.getCurrentWeight() - this.getInitialWeight()) / (double) (this.getMaxWeight() - this.getInitialWeight()))) / 100.0;
        if (randomNumberGenerator() >= landingCrash) {
            return true;
        }
        return false;
    }

    private double randomNumberGenerator() {

        /**
         * Method used to create random number.
         */

        return Math.random();
    }
}

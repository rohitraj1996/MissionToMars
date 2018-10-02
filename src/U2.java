public class U2 extends Rocket {

    public U2() {
        super(18000, 29000, 120);
    }

    @Override
    public boolean launch() {

        /**
         * Method used to check if the rocket can successfully launch or not.
         *
         * @return It returns the value true if the rocket can launch successfully otherwise it will return false.
         */

        double launchExplosion = (4 * ((this.getCurrentWeight() - this.getInitialWeight()) / (double) (this.getMaxWeight() - this.getInitialWeight()))) / 100.0;
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

        double landingCrash = (8 * ((this.getCurrentWeight() - this.getInitialWeight()) / (double) (this.getMaxWeight() - this.getInitialWeight()))) / 100.0;
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

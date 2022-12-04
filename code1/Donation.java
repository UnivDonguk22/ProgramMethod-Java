public class Donation {
	
    Purse purse;

    public Donation(Purse p) {
        purse = p;
    }

    public boolean donate(int amount) {
        boolean success = false;
        if (purse.contents() >= amount) {
            purse.extract(amount);
            success = true;
        }
        return success;
    }
}
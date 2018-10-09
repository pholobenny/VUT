package vut.data;

/**
 * This class compute the cost of comforter based on the user selection And
 * delivery options
 *
 * @author 210124385 BL Pholo
 */
public class HalesComforters {

    public enum Comforters {
        TWIN, FULL, QUEEN, KING
    }

    private final double TWIN_PRICE = 400;
    private final double FULL_PRICE = 500;
    private final double QUEEN_PRICE = 600;
    private final double KING_PRICE = 700;

    private double cost;
    private Comforters comforterSize;

    //default constructor
    public HalesComforters() {
        this.comforterSize = Comforters.TWIN;
        this.cost = 0.0;
    }

    //paramiterized constractor
    public HalesComforters(double cost, Comforters comforterSize) {
        this.setComforterSize(comforterSize);
        this.setCost(cost);
    }

    /**
     * Set the cost
     *
     * @param cost
     */
    public void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Inavalid cost, cost should be positive:" + cost);
        } else {
            this.cost = cost;
        }
    }

    /**
     * Set the Comfort Size
     *
     * @param comforterSize
     */
    public void setComforterSize(Comforters comforterSize) {
        this.comforterSize = comforterSize;
    }

    /**
     * Get the cost
     *
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Get the comforter size
     *
     * @return comforterSize
     */
    public Comforters getComforterSize() {
        return comforterSize;
    }

    /**
     * display cost and comfort size
     *
     * @return cost and comfortSize
     */
    @Override
    public String toString() {
        return "[cost: " + cost + "comforterSize=" + comforterSize + "]";
    }

    /**
     * Calculate the cost of the comfort
     *
     * @param comforterSize the comfortSize
     * @param pickUp the pick or delivery
     * @return the cost
     */
    public double calculateCost(Comforters comforterSize, String pickUp) {
        if (pickUp.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("Pickup/Delevery is empty");
        }
        if (pickUp.equalsIgnoreCase("no")) {
            cost = cost + 50;
        }

        switch (comforterSize) {
            case TWIN:
                return cost = cost + TWIN_PRICE;
            case FULL:
                return cost = cost + FULL_PRICE;
            case QUEEN:
                return cost = cost + QUEEN_PRICE;
            case KING:
                return cost = cost + KING_PRICE;
        }
        return cost;
    }

}

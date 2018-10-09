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
    private final double DELIVERY_FEE = 50;

    private double cost;
    private Comforters comforterSize;
    private String customerName;
    private String cellNumber;

    //default constructor
    public HalesComforters() {
        this.comforterSize = Comforters.TWIN;
        this.cost = 0.0;
        this.customerName = "";
        this.cellNumber = "";
    }

    //paramiterized constractor
    public HalesComforters(double cost, Comforters comforterSize, String customerName, String cellNumber) {
        this.setCost(cost);
        this.setComforterSize(comforterSize);
        this.setCustomerName(customerName);
        this.setCellNumber(cellNumber);
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
     * Set customer name
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        if (customerName.equalsIgnoreCase("") || customerName.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Name:" + customerName);
        } else {
            this.customerName = customerName;
        }
    }

    /**
     * set cell number
     *
     * @param cellNumber
     */
    public void setCellNumber(String cellNumber) {
        if (cellNumber.startsWith("0") && cellNumber.matches("\\d{10}")) {
            this.cellNumber = cellNumber;
        } else {
            throw new IllegalArgumentException("Cell Number should start with 0 and have 10 digits\n invalid cell number:" + cellNumber);
        }
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
     * Get the Customer name
     *
     * @return customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Get the cell number
     *
     * @return cell number
     */
    public String getCellNumber() {
        return cellNumber;
    }

    /**
     * Display cost,comfort size, customer name, and cell number
     *
     * @return cost and comfortSize
     */
    @Override
    public String toString() {
        return "[cost: " + cost + "comforterSize:" + comforterSize + " Customer Name:" + customerName + "Cell Number:" + cellNumber + "]";
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
            cost = cost + DELIVERY_FEE;
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

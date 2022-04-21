package activities;

/**
 * Enumeration representing common currency denominations.
 */
public enum Currency {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25),
    DOLLAR(100);

    /**
     * The value (in dollars) if the denomination.
     */
    private final double value;

    /**
     * Creates a denomination with the specified value.
     * 
     * @param value The value for this denomination.
     */
    private Currency(double value) {
        this.value = value;
    }

    /**
     * returns the value of the denomination.
     * 
     * @return The value of the denomination.
     */
    public double getValue() {
        return value;
    }
    public static void main(String[] args) {
        Currency change = PENNY;
        System.out.println(change.getValue());
    }
}

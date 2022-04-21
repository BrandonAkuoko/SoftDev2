package assignment2;

public enum CheckedOut {
    CHECKEDOUT("Checked Out"),
    AVAILABLE("Available");

    private String status;

    private CheckedOut (String theStatus) {
        this.status = theStatus;
    }
    
    @Override
    public String toString() {
        return status;
    }

}


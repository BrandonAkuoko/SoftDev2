package backtracker;

public class Queen {
    private final int row;
    private final int col;

    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean canAttack(Queen enemy) {
        // difference
        int rDiff = this.row - enemy.row;
        int cDiff = this.col - enemy.col;

        return rDiff == 0 || cDiff == 0 || rDiff == -cDiff;
    }

    @Override
    public String toString() {
        return "Queen{"
            + "row=" + this.row
            + ", col=" + this.col
            + "}";
    }
    
}


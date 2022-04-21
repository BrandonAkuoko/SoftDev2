package code.reversi.model;

/**
 * Represents a piece in Reversi.
 */
public enum Color {
    EMPTY(" "),
    WHITE("W"),
    BLACK("B");

    /**
     * A 1-character string representing the piece.
     */
    private final String symbol;

    private Color(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the opposing color. Useful when changing turns or flipping
     * pieces.
     *
     * @return The opposing color.
     */
    public Color flip() {
        return this == BLACK ? WHITE : BLACK;
    }
}

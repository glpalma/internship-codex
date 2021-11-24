public class Rectangle {
    private int xRight, xLeft; // coordinates of the vertical sides
    private int yLower, yUpper; // coordinates of the horizontal sides

    public Rectangle(int xLowerLeft, int yLowerLeft, int xUpperRight, int yUpperRight) {
        this.xRight = xUpperRight;
        this.xLeft = xLowerLeft;
        this.yLower = yLowerLeft;
        this.yUpper = yUpperRight;
    }
    
    /**
     * Checks if the rectangle object intersects with another rectangle.
     * For two rectangles to be considered intersected, they need to have a portion of their areas overlapping.
     * If they have opposite vertical sides (e.g. one's upper and the other one's lower) on the same coordinate
     * and the same for the horizontal sides, the intersection is considered.
     * @throws NullPointerException if the other rectangle is a null pointer
     * @param other represents the other rectangle to be tested
     * @return true if they intersect; false otherwise
     */
    public boolean intersects(Rectangle other) {
        checkNullity(other);
        return (this.containsVerticalSideOf(other) && this.containsHorizontalSideOf(other)) ||
               (other.containsVerticalSideOf(this) && other.containsHorizontalSideOf(this));
    }

    /**
     * Checks if the rectangle object contains at least one vertical side from the other rectangle between its own vertical sides.
     * @throws NullPointerException if the other rectangle is a null pointer
     * @param other represents the other rectangle to be tested
     * @return true if the current rectangle object contains the other rectangle's left or right sides between its own left and right sides.
     */
    private boolean containsVerticalSideOf(Rectangle other) {
        checkNullity(other);
        boolean containsLeftSide = (xLeft <= other.xLeft) && (other.xLeft <= xRight);
        boolean containsRightSide = (xLeft <= other.xRight) && (other.xRight <= xRight);

        return containsLeftSide || containsRightSide;
    }

    /**
     * Checks if the rectangle object contains at least one horizontal side from the other rectangle between its own horizontal sides.
     * @throws NullPointerException if the other rectangle is a null pointer
     * @param other represents the other rectangle to be tested
     * @return true if the current rectangle object contains the other rectangle's lower or upper sides between its own lower and upper sides.
     */
    private boolean containsHorizontalSideOf(Rectangle other) {
        checkNullity(other);
        boolean containsLowerSide = (yLower <= other.yLower) && (other.yLower <= yUpper);
        boolean containsUpperSide = (yLower <= other.yUpper) && (other.yUpper <= yUpper);

        return containsLowerSide || containsUpperSide;
    }

    /**
     * Checks if the given rectangle t is null
     * @throws NullPointerException if the given rectangle is a null pointer
     * @param r represents the rectangle to be checked
     */
    private void checkNullity(Rectangle r) {
        if (r == null) {
            throw new NullPointerException("The other rectangle can't be null!");
        }
    }
}

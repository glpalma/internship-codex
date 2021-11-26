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

    /**
     * Calculates the intersection area of two intersecting rectangles. If the rectangles don't intersect, the return value is 0.
     * @throws NullPointerException if the other rectangle is a null pointer
     * @param other represents the other rectangle to be tested
     * @return an integer representing the area of the intersection
     */
    public int intersectionArea(Rectangle other) {
        int[] intCoord = intersectionCoordinates(other);
        int area = 0;
        if (intCoord[0] != -1) {
            area = (intCoord[2] - intCoord[0] + 1) * (intCoord[3] - intCoord[1] + 1);
        }
        return area;
    }

    /**
     * Calculates the coordinates of the intersection between the current rectangle object and the given one.
     * @throws NullPointerException if the other rectangle is a null pointer
     * @param other represents the other rectangle to be tested
     * @return {-1, -1, -1, -1} if the rectangles don't intersect; {newLeft, newLower, newRight, newUpper} otherwise.
     */
    public int[] intersectionCoordinates(Rectangle other) {
        checkNullity(other);
        int[] coordinates = {-1, -1, -1, -1};
        int newRight, newLeft;
        int newLower, newUpper;

        if (this.intersects(other)) {
            if (this.contains(other)) {
                coordinates = new int[]{other.xLeft, other.yLower, other.xRight, other.yUpper};
            } else if (other.contains(this)) {
                coordinates = new int[]{this.xLeft, this.yLower, this.xRight, this.yUpper};
            } else {
                // calculates horizontal bounds of the new intersection
                if (this.yLower <= other.yUpper && other.yUpper <= this.yUpper) {
                    newUpper = other.yUpper;
                    newLower = this.yLower;
                } else {
                    // (this.yLower <= other.yLower && other.yLower <= this.yUpper)
                    newUpper = this.yUpper;
                    newLower = other.yLower;
                }

                // calculates vertical bounds of the new intersection
                if (this.xLeft <= other.xLeft && other.xLeft <= this.xRight) { // left in
                    newRight = this.xRight;
                    newLeft = other.xLeft;
                } else { // right in
                    // (this.xLeft <= other.xRight && other.xRight <= this.xRight)
                    newRight = other.xRight;
                    newLeft = this.xLeft;
                }
                coordinates = new int[]{newLeft, newLower, newRight, newUpper};
            }
        }
        return coordinates;
    }

    /**
     * Checks if the current rectangle object contains another given rectangle.
     * @param other represents the other rectangle to be tested
     * @return true if the current rectangle object contains the other rectangle.
     */
    public boolean contains(Rectangle other) {
        return (this.xLeft <= other.xLeft && other.xRight <= this.xRight) &&
                (this.yLower <= other.yLower && other.yUpper <= this.yUpper);
    }
}

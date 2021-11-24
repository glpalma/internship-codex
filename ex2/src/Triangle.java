public class Triangle {
    private int xRight, xLeft; // coordinates of the vertical sides
    private int yLower, yUpper; // coordinates of the horizontal sides

    public Triangle(int xLowerLeft, int yLowerLeft, int xUpperRight, int yUpperRight) {
        this.xRight = xUpperRight;
        this.xLeft = xLowerLeft;
        this.yLower = yLowerLeft;
        this.yUpper = yUpperRight;
    }

    public boolean intersects(Triangle other) {
        checkNullity(other);
        return (this.containsVerticalSideOf(other) && this.containsHorizontalSideOf(other)) ||
               (other.containsVerticalSideOf(this) && other.containsHorizontalSideOf(this));
    }

    private boolean containsVerticalSideOf(Triangle other) {
        checkNullity(other);
        boolean containsLeftSide = (xLeft <= other.xLeft) && (other.xLeft <= xRight);
        boolean containsRightSide = (xLeft <= other.xRight) && (other.xRight <= xRight);

        return containsLeftSide || containsRightSide;
    }

    private boolean containsHorizontalSideOf(Triangle other) {
        checkNullity(other);
        boolean containsLowerSide = (yLower <= other.yLower) && (other.yLower <= yUpper);
        boolean containsUpperSide = (yLower <= other.yUpper) && (other.yUpper <= yUpper);

        return containsLowerSide || containsUpperSide;
    }

    private void checkNullity(Triangle t) {
        if (t == null) {
            throw new NullPointerException("The other triangle can't be null!");
        }
    }
}

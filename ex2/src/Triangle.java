public class Triangle {
    private int xRight, xLeft; // coordinates of the vertical sides
    private int yDown, yUp; // coordinates of the horizontal sides

    public Triangle(int xLowerLeft, int yLowerLeft, int xUpperRight, int yUpperRight) {
        this.xRight = xUpperRight;
        this.xLeft = xLowerLeft;
        this.yDown = yLowerLeft;
        this.yUp = yUpperRight;
    }
}

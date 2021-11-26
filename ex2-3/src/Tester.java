public class Tester {
    public static void main(String[] args) {
        Rectangle A = new Rectangle(3, 5, 11, 11);
        Rectangle B = new Rectangle(7, 2, 13, 7);
        Rectangle C = new Rectangle(11, 11, 15, 13);

        Rectangle D = new Rectangle(10, 10, 16, 14);
        Rectangle E = new Rectangle(7, 0, 13, 2);

        // 2
        System.out.println(A.intersects(B));
        System.out.println(A.intersects(C));
        System.out.println(B.intersects(C));

        // 3
        System.out.println(A.intersectionArea(B));
        System.out.println(A.intersectionArea(C));

        System.out.println(B.intersectionArea(E)); // extra tests with extra rectangles
        System.out.println(C.intersectionArea(D));
        System.out.println(D.intersectionArea(C));

    }
}

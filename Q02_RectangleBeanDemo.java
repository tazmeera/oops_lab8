public class Q02_RectangleBeanDemo {
    public static void main(String[] args) {
        RectangleBean r = new RectangleBean();
        r.setLength(12.5);
        r.setWidth(4);
        System.out.println("Length    : " + r.getLength());
        System.out.println("Width     : " + r.getWidth());
        System.out.println("Area      : " + r.calculateArea());
        System.out.println("Perimeter : " + r.calculatePerimeter());
    }
}

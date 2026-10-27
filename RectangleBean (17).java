import java.io.Serializable;

/** Q2. RectangleBean with length and width, plus methods to calculate area and perimeter. */
public class RectangleBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private double length;
    private double width;

    public RectangleBean() {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }

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

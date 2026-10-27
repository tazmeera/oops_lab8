import java.io.Serializable;

/**
 * Q10. CircleBean: radius is a read/write property; area and circumference are READ-ONLY properties
 * (getters only) calculated from the radius every time they are read.
 */
public class CircleBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private double radius;

    public CircleBean() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("radius cannot be negative");
        }
        this.radius = radius;
    }

    // read-only (no setter)
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // read-only (no setter)
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        CircleBean c = new CircleBean();
        c.setRadius(7);
        System.out.printf("Radius        : %.2f%n", c.getRadius());
        System.out.printf("Area          : %.4f%n", c.getArea());
        System.out.printf("Circumference : %.4f%n", c.getCircumference());

        c.setRadius(10);
        System.out.println("After changing radius to 10 the read-only properties update automatically:");
        System.out.printf("Area          : %.4f%n", c.getArea());
        System.out.printf("Circumference : %.4f%n", c.getCircumference());
    }
}

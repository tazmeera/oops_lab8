/** Q10: radius is read/write; area and circumference are read-only (getter only, derived from radius). */
public class CircleBean {
    private double radius;

    public CircleBean() { }
    public double getRadius() { return radius; }
    public void setRadius(double radius) {
        if (radius < 0) throw new IllegalArgumentException("radius cannot be negative");
        this.radius = radius;
    }
    public double getArea() { return Math.PI * radius * radius; }
    public double getCircumference() { return 2 * Math.PI * radius; }
}

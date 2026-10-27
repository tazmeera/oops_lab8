/** Q2: Bean with length and width plus methods to calculate area and perimeter. */
public class RectangleBean {
    private double length;
    private double width;

    public RectangleBean() { }
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }

    public double calculateArea() { return length * width; }
    public double calculatePerimeter() { return 2 * (length + width); }
}

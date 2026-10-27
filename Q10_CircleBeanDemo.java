import java.beans.*;

public class Q10_CircleBeanDemo {
    public static void main(String[] args) throws Exception {
        CircleBean c = new CircleBean();
        for (double r : new double[] {1, 2.5, 10}) {
            c.setRadius(r);
            System.out.printf("radius=%.1f  area=%.4f  circumference=%.4f%n", c.getRadius(), c.getArea(), c.getCircumference());
        }
        for (PropertyDescriptor pd : Introspector.getBeanInfo(CircleBean.class, Object.class).getPropertyDescriptors()) {
            System.out.println("property " + pd.getName() + " -> readable=" + (pd.getReadMethod() != null)
                    + ", writable=" + (pd.getWriteMethod() != null));
        }
        try { c.setRadius(-1); } catch (IllegalArgumentException e) { System.out.println("setRadius(-1) rejected: " + e.getMessage()); }
    }
}

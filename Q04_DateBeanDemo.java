import java.beans.*;

public class Q04_DateBeanDemo {
    public static void main(String[] args) throws Exception {
        DateBean b = new DateBean();
        System.out.println("currentDate = " + b.getCurrentDate());

        // Prove the property is read-only using the Introspector
        for (PropertyDescriptor pd : Introspector.getBeanInfo(DateBean.class, Object.class).getPropertyDescriptors()) {
            System.out.println("property " + pd.getName() + " -> readable=" + (pd.getReadMethod() != null)
                    + ", writable=" + (pd.getWriteMethod() != null));
        }
    }
}

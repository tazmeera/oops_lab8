import java.beans.*;
import java.lang.reflect.Method;

/** Q8: use Introspector to list all properties and methods of StudentBean. */
public class Q08_IntrospectorDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(StudentBean.class);   // includes Object's members

        System.out.println("=== Properties of StudentBean ===");
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.printf("%-8s type=%-18s getter=%-10s setter=%s%n", pd.getName(),
                    pd.getPropertyType() == null ? "-" : pd.getPropertyType().getSimpleName(),
                    pd.getReadMethod() == null ? "-" : pd.getReadMethod().getName(),
                    pd.getWriteMethod() == null ? "-" : pd.getWriteMethod().getName());
        }

        System.out.println("\n=== Methods of StudentBean ===");
        for (MethodDescriptor md : info.getMethodDescriptors()) {
            Method m = md.getMethod();
            if (m.getDeclaringClass() == StudentBean.class) {            // methods declared by the bean itself
                System.out.println(m.toGenericString());
            }
        }
        System.out.println("\n(Total methods incl. inherited from Object: " + info.getMethodDescriptors().length + ")");
    }
}

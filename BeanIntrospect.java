import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/** Q8. Uses java.beans.Introspector to list all properties and methods of StudentBean. */
public class BeanIntrospect {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo info = Introspector.getBeanInfo(StudentBean.class);

        System.out.println("=== Properties of StudentBean ===");
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            Method getter = pd.getReadMethod();
            Method setter = pd.getWriteMethod();
            System.out.printf("%-8s type=%-8s getter=%-10s setter=%s%n",
                    pd.getName(),
                    pd.getPropertyType() == null ? "-" : pd.getPropertyType().getSimpleName(),
                    getter == null ? "none" : getter.getName(),
                    setter == null ? "none" : setter.getName());
        }
        System.out.println("(the 'class' property is inherited from java.lang.Object)");

        System.out.println();
        System.out.println("=== Methods of StudentBean (including inherited) ===");
        for (MethodDescriptor md : info.getMethodDescriptors()) {
            System.out.println(md.getMethod().toGenericString());
        }
    }
}

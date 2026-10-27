import java.beans.*;

public class Q05_UserBeanDemo {
    public static void main(String[] args) throws Exception {
        UserBean u = new UserBean();
        u.setPassword("s3cret");
        System.out.println("Password set. checkPassword(\"s3cret\") = " + u.checkPassword("s3cret"));
        System.out.println("checkPassword(\"wrong\")  = " + u.checkPassword("wrong"));

        for (PropertyDescriptor pd : Introspector.getBeanInfo(UserBean.class, Object.class).getPropertyDescriptors()) {
            System.out.println("property " + pd.getName() + " -> readable=" + (pd.getReadMethod() != null)
                    + ", writable=" + (pd.getWriteMethod() != null));
        }
    }
}

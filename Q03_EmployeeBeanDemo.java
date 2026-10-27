import java.io.*;

/** Saves the bean to a file (serialization) and reads it back (deserialization). */
public class Q03_EmployeeBeanDemo {
    public static void main(String[] args) throws Exception {
        EmployeeBean e = new EmployeeBean();
        e.setEmpId(7);
        e.setEmpName("Rohan Mehta");
        e.setSalary(55000);
        System.out.println("Original     : " + e);

        File f = new File("employee.ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f))) {
            out.writeObject(e);
        }
        System.out.println("Serialized to " + f.getName() + " (" + f.length() + " bytes)");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {
            EmployeeBean copy = (EmployeeBean) in.readObject();
            System.out.println("Deserialized : " + copy);
        }
        f.delete();
    }
}

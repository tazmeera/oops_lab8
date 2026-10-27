import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Q3. EmployeeBean implements Serializable with properties empId, empName, salary.
 * main() serializes the bean to bytes and reads it back to prove that it is serializable.
 */
public class EmployeeBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int empId;
    private String empName;
    private double salary;

    public EmployeeBean() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeBean[empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        EmployeeBean original = new EmployeeBean();
        original.setEmpId(7);
        original.setEmpName("Neha Verma");
        original.setSalary(55000.50);
        System.out.println("Before serialization : " + original);

        // write the object to a byte array (could be a file: new FileOutputStream("emp.ser"))
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bytes)) {
            out.writeObject(original);
        }
        System.out.println("Serialized size      : " + bytes.size() + " bytes");

        // read it back
        EmployeeBean copy;
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
            copy = (EmployeeBean) in.readObject();
        }
        System.out.println("After deserialization: " + copy);
        System.out.println("Same object?         : " + (original == copy) + " (a new, equal copy)");
    }
}

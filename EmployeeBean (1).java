import java.io.Serializable;

/** Q3: Serializable bean with empId, empName, salary. */
public class EmployeeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int empId;
    private String empName;
    private double salary;

    public EmployeeBean() { }
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override public String toString() {
        return "EmployeeBean[empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
    }
}

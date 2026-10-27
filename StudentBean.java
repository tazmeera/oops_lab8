/** Q1: JavaBean with private properties id, name, grade and getters/setters. */
public class StudentBean implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double grade;

    public StudentBean() { }                       // beans need a public no-arg constructor

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
}

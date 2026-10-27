import java.io.Serializable;

/**
 * Q1. Java Bean with private properties id, name and grade.
 * A bean needs: public no-argument constructor, private fields, public getX()/setX() methods.
 */
public class StudentBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private double grade;

    public StudentBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public static void main(String[] args) {
        StudentBean s = new StudentBean();
        s.setId(101);
        s.setName("Aarav Sharma");
        s.setGrade(8.7);
        System.out.println("Student id    : " + s.getId());
        System.out.println("Student name  : " + s.getName());
        System.out.println("Student grade : " + s.getGrade());
    }
}

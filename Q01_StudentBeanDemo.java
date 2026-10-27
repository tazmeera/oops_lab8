public class Q01_StudentBeanDemo {
    public static void main(String[] args) {
        StudentBean s = new StudentBean();
        s.setId(101);
        s.setName("Asha Verma");
        s.setGrade(8.7);
        System.out.println("Id    : " + s.getId());
        System.out.println("Name  : " + s.getName());
        System.out.println("Grade : " + s.getGrade());
    }
}

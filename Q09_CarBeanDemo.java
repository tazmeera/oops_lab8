public class Q09_CarBeanDemo {
    public static void main(String[] args) {
        CarBean car = new CarBean();
        car.setMake("Maruti Suzuki");
        car.setModel("Swift");
        car.setYear(2024);
        System.out.println("Make  : " + car.getMake());
        System.out.println("Model : " + car.getModel());
        System.out.println("Year  : " + car.getYear());

        car.setYear(2026);                       // properties can be changed again
        System.out.println("Updated year: " + car.getYear());
    }
}

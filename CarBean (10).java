import java.io.Serializable;

/** Q9. CarBean with properties make, model and year; main() sets and gets them through the bean. */
public class CarBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String make;
    private String model;
    private int year;

    public CarBean() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static void main(String[] args) {
        CarBean car = new CarBean();

        // set properties
        car.setMake("Maruti Suzuki");
        car.setModel("Swift");
        car.setYear(2024);

        // get properties
        System.out.println("Make  : " + car.getMake());
        System.out.println("Model : " + car.getModel());
        System.out.println("Year  : " + car.getYear());
    }
}

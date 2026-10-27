import java.time.LocalDate;

/**
 * Q4. Read-only property currentDate: only a getter, no setter, so the value cannot be changed from
 * outside. It is computed on every call, so it always returns today's date.
 */
public class DateBean {

    public DateBean() {
    }

    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static void main(String[] args) {
        DateBean bean = new DateBean();
        System.out.println("Today's date (currentDate) : " + bean.getCurrentDate());
        // bean.setCurrentDate(...) does not exist -> the property is read-only
    }
}

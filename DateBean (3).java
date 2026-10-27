import java.time.LocalDate;

/** Q4: read-only property "currentDate": only a getter, no setter, always returns today's date. */
public class DateBean {
    public LocalDate getCurrentDate() { return LocalDate.now(); }
}

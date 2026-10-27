import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Q06_Q07_AccountBeanDemo {
    public static void main(String[] args) {
        AccountBean acc = new AccountBean();

        // Q6: listener that prints a message whenever balance changes
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("  [event] " + evt.getPropertyName() + " changed from "
                        + evt.getOldValue() + " to " + evt.getNewValue());
            }
        };
        acc.addPropertyChangeListener(listener);

        // Q7: update the balance and watch the events fire
        System.out.println("Deposit -> balance 5000");  acc.setBalance(5000);
        System.out.println("Withdraw -> balance 3200"); acc.setBalance(3200);
        System.out.println("Set same value 3200 (no event expected)"); acc.setBalance(3200);

        acc.removePropertyChangeListener(listener);
        System.out.println("Listener removed, set 100 (no event expected)"); acc.setBalance(100);
        System.out.println("Final balance = " + acc.getBalance());
    }
}

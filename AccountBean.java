import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Q6. AccountBean with a bound property "balance". PropertyChangeSupport keeps the listener list and
 * fires an event whenever the balance really changes. main() registers a PropertyChangeListener that
 * prints a message on every change.
 * (Q7 uses this same bean - see AccountDemo.java.)
 */
public class AccountBean {
    private double balance;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public AccountBean() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        double oldBalance = this.balance;
        this.balance = newBalance;
        // fires an event only if oldBalance != newBalance
        support.firePropertyChange("balance", oldBalance, newBalance);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public static void main(String[] args) {
        AccountBean account = new AccountBean();

        account.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("Balance changed from " + evt.getOldValue() + " to " + evt.getNewValue());
            }
        });

        account.setBalance(1000);
        account.setBalance(1500);
    }
}

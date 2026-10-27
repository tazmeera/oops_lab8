import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/** Q6/Q7: bound property "balance" - registered listeners are notified whenever it changes. */
public class AccountBean {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private double balance;

    public double getBalance() { return balance; }

    public void setBalance(double newBalance) {
        double old = this.balance;
        this.balance = newBalance;
        support.firePropertyChange("balance", old, newBalance);   // fires only if old != new
    }

    public void addPropertyChangeListener(PropertyChangeListener l) { support.addPropertyChangeListener(l); }
    public void removePropertyChangeListener(PropertyChangeListener l) { support.removePropertyChangeListener(l); }
}

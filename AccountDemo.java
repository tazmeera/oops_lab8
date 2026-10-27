import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Q7. Updates the balance property of AccountBean and demonstrates the property change event:
 * deposit, withdraw, setting the same value (no event), and removing the listener (no event).
 */
public class AccountDemo {

    public static void main(String[] args) {
        AccountBean account = new AccountBean();

        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("  [EVENT] property '" + evt.getPropertyName() + "': "
                        + evt.getOldValue() + " -> " + evt.getNewValue());
            }
        };
        account.addPropertyChangeListener(listener);

        System.out.println("1) Opening deposit of 5000");
        account.setBalance(5000);

        System.out.println("2) Deposit 2500 (balance becomes 7500)");
        account.setBalance(account.getBalance() + 2500);

        System.out.println("3) Withdraw 1200 (balance becomes 6300)");
        account.setBalance(account.getBalance() - 1200);

        System.out.println("4) Set the same value 6300 again -> no change, so no event is fired");
        account.setBalance(6300);

        System.out.println("5) Remove the listener, then change the balance -> no event");
        account.removePropertyChangeListener(listener);
        account.setBalance(100);

        System.out.println("Final balance: " + account.getBalance());
    }
}

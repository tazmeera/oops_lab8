/** Q5: write-only property "password": a setter but NO getter, so it cannot be read back from outside. */
public class UserBean {
    private String password;

    public void setPassword(String password) { this.password = password; }

    /** Not a getter: lets the bean check a password without exposing it. */
    public boolean checkPassword(String attempt) { return password != null && password.equals(attempt); }
}

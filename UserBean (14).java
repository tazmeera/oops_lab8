/**
 * Q5. Write-only property password: there is a setter but NO getter, so the password can be set but
 * never read back directly. A verify method is provided so the bean is still useful.
 */
public class UserBean {
    private String password;

    public UserBean() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /** Checks a guess without ever exposing the stored password. */
    public boolean checkPassword(String guess) {
        return password != null && password.equals(guess);
    }

    public static void main(String[] args) {
        UserBean user = new UserBean();
        user.setPassword("Secret@123");
        System.out.println("Password set (cannot be read back).");
        System.out.println("checkPassword(\"wrong\")      : " + user.checkPassword("wrong"));
        System.out.println("checkPassword(\"Secret@123\") : " + user.checkPassword("Secret@123"));
    }
}

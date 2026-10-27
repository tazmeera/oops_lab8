import java.net.InetAddress;
import java.net.UnknownHostException;

/** Q11. Displays this computer's IP address and host name using InetAddress. */
public class IpInfo {

    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Host name  : " + local.getHostName());
            System.out.println("IP address : " + local.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not determine the local host: " + e.getMessage());
        }
    }
}

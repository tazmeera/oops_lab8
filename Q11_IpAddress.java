import java.net.InetAddress;
import java.net.UnknownHostException;

/** Q11: display this computer's IP address and host name using InetAddress. */
public class Q11_IpAddress {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Host name  : " + local.getHostName());
            System.out.println("IP address : " + local.getHostAddress());
            InetAddress loop = InetAddress.getLoopbackAddress();
            System.out.println("Loopback   : " + loop.getHostName() + " / " + loop.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Could not determine local host: " + e.getMessage());
        }
    }
}

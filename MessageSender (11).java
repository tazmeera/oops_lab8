import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/** Q16. UDP client: sends the message "Ping" to the UDP server (MessageReceiver) on port 6000. */
public class MessageSender {

    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        try (DatagramSocket socket = new DatagramSocket()) {
            byte[] data = "Ping".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length,
                    InetAddress.getByName(host), MessageReceiver.PORT);
            socket.send(packet);
            System.out.println("Sent: Ping");
        } catch (IOException e) {
            System.out.println("Sender error: " + e.getMessage());
        }
    }
}

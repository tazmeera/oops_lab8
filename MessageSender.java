import java.net.*;

/** Q16: UDP client that sends the message "Ping" to the UDP server on port 6000. */
public class MessageSender {
    public static void main(String[] args) throws Exception {
        byte[] data = "Ping".getBytes();
        try (DatagramSocket socket = new DatagramSocket()) {
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 6000);
            socket.send(packet);
            System.out.println("Sent: Ping");
        }
    }
}

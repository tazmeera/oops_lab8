import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/** Q17. UDP server on port 6000: receives one datagram from a client and prints it. */
public class MessageReceiver {
    public static final int PORT = 6000;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("MessageReceiver waiting on UDP port " + PORT + " ...");
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);                                  // blocks until a datagram arrives
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + message + "  (from " + packet.getAddress().getHostAddress()
                    + ":" + packet.getPort() + ")");
        } catch (IOException e) {
            System.out.println("Receiver error: " + e.getMessage());
        }
    }
}

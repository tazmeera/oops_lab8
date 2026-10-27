import java.net.*;

/** Q17: UDP server on port 6000: receives one datagram and prints it. Start before MessageSender. */
public class MessageReceiver {
    public static void main(String[] args) throws Exception {
        final int PORT = 6000;
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("MessageReceiver waiting on UDP port " + PORT + " ...");
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);                                   // blocks until a datagram arrives
            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received: " + msg + "  (from " + packet.getAddress().getHostAddress() + ":" + packet.getPort() + ")");
        }
    }
}

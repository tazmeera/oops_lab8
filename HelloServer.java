import java.io.*;
import java.net.*;

/**
 * Q12 + Q14: TCP server on port 5000.
 * Q12: waits for a client and prints "Client connected".
 * Q14 (modified version): then reads the client's message and prints "Received from client: <message>".
 * Start this first, then run HelloClient.
 */
public class HelloServer {
    public static void main(String[] args) {
        final int PORT = 5000;
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("HelloServer listening on port " + PORT + " ...");
            try (Socket client = server.accept()) {              // blocks until a client connects
                System.out.println("Client connected");
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String message = in.readLine();                  // Q14: read the message
                System.out.println("Received from client: " + message);
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

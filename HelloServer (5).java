import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Q12 + Q14. TCP server on port 5000.
 *  Q12: waits for a client and prints "Client connected".
 *  Q14 (modification): also reads the message sent by the client and prints
 *       "Received from client: <message>".
 * Start this first, then run HelloClient.
 */
public class HelloServer {
    public static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("HelloServer listening on port " + PORT + " ...");

            try (Socket client = server.accept()) {              // blocks until a client connects
                System.out.println("Client connected");           // ---- Q12 ----

                BufferedReader in = new BufferedReader(           // ---- Q14 ----
                        new InputStreamReader(client.getInputStream()));
                String message = in.readLine();
                System.out.println("Received from client: " + message);
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

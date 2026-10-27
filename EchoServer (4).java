import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Q15. TCP echo server on port 7000: sends back every line it receives until the client closes the
 * connection. Test with EchoClient (or telnet localhost 7000).
 */
public class EchoServer {
    public static final int PORT = 7000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("EchoServer listening on port " + PORT + " ...");
            try (Socket client = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                System.out.println("Client connected");
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Echoing: " + line);
                    out.println(line);                    // send the same message back
                }
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

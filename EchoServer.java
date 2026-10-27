import java.io.*;
import java.net.*;

/** Q15: TCP echo server on port 5001: sends back every line it receives, until the client disconnects. */
public class EchoServer {
    public static void main(String[] args) {
        final int PORT = 5001;
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("EchoServer listening on port " + PORT + " ...");
            try (Socket client = server.accept()) {
                System.out.println("Client connected: " + client.getRemoteSocketAddress());
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Echoing: " + line);
                    out.println(line);                           // same message back
                }
                System.out.println("Client disconnected");
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}

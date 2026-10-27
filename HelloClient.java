import java.io.*;
import java.net.*;

/** Q13: TCP client that connects to HelloServer (localhost:5000) and sends "Hello Server". */
public class HelloClient {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        try (Socket socket = new Socket(host, 5000)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);   // autoflush
            out.println("Hello Server");
            System.out.println("Message sent to server");
        } catch (IOException e) {
            System.err.println("Could not reach server (is HelloServer running?): " + e.getMessage());
        }
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/** Q13. TCP client: connects to HelloServer (localhost:5000) and sends "Hello Server". */
public class HelloClient {

    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        try (Socket socket = new Socket(host, HelloServer.PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("Hello Server");
            System.out.println("Message sent to server: Hello Server");
        } catch (IOException e) {
            System.out.println("Client error (is HelloServer running?): " + e.getMessage());
        }
    }
}

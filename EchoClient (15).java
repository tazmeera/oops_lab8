import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** Helper for Q15: sends a few messages to EchoServer and prints what comes back. */
public class EchoClient {

    public static void main(String[] args) {
        String[] messages = {"Hello Echo", "Java sockets are easy", "Bye"};
        try (Socket socket = new Socket("localhost", EchoServer.PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            for (String m : messages) {
                out.println(m);
                System.out.println("Sent: " + m + "  |  Echoed back: " + in.readLine());
            }
        } catch (IOException e) {
            System.out.println("Client error (is EchoServer running?): " + e.getMessage());
        }
    }
}

import java.io.*;
import java.net.*;

/** Helper for testing EchoServer: sends a few messages (or the args) and prints each reply. */
public class EchoClient {
    public static void main(String[] args) throws IOException {
        String[] messages = args.length > 0 ? args : new String[] {"Hello", "Echo this back", "Bye"};
        try (Socket s = new Socket("localhost", 5001)) {
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            for (String m : messages) {
                out.println(m);
                System.out.println("Sent: " + m + "   |   Echo: " + in.readLine());
            }
        }
    }
}

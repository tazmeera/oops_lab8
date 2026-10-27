import java.io.*;
import java.net.*;

/** Helper for testing MultiClientServer: launches N clients at the same time, each sending one message. */
public class MultiClientDemoClient {
    public static void main(String[] args) throws Exception {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 3;
        Thread[] ts = new Thread[n];
        for (int i = 1; i <= n; i++) {
            final int id = i;
            ts[i - 1] = new Thread(() -> {
                try (Socket s = new Socket("localhost", 5002)) {
                    new PrintWriter(s.getOutputStream(), true).println("Hello from client " + id);
                } catch (IOException e) { System.err.println("client " + id + ": " + e); }
            });
            ts[i - 1].start();
        }
        for (Thread t : ts) t.join();
        System.out.println(n + " clients finished");
    }
}

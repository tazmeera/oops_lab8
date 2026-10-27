import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/** Helper for Q20: starts 5 clients at the same time; each sends one message to MultiClientServer. */
public class ClientSimulator {

    public static void main(String[] args) throws InterruptedException {
        Thread[] clients = new Thread[5];
        for (int i = 1; i <= clients.length; i++) {
            final int id = i;
            clients[i - 1] = new Thread(() -> {
                try (Socket socket = new Socket("localhost", MultiClientServer.PORT);
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    out.println("Hello from client " + id);
                } catch (IOException e) {
                    System.out.println("Client " + id + " error (is MultiClientServer running?): " + e.getMessage());
                }
            });
            clients[i - 1].start();
        }
        for (Thread t : clients) {
            t.join();
        }
        System.out.println("All clients finished.");
    }
}

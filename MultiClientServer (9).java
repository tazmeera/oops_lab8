import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Q20. Multithreaded TCP server on port 8000. For every client that connects the server starts a new
 * thread; each client sends a message and the server prints it together with the handling thread's
 * name. Stop the server with Ctrl+C. Test with ClientSimulator (starts several clients at once).
 */
public class MultiClientServer {
    public static final int PORT = 8000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("MultiClientServer listening on port " + PORT + " (Ctrl+C to stop) ...");
            int count = 0;
            while (true) {
                Socket client = server.accept();
                count++;
                Thread t = new Thread(new ClientHandler(client), "Client-Thread-" + count);
                t.start();                                       // main thread goes back to accept()
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    /** Handles one client in its own thread. */
    static class ClientHandler implements Runnable {
        private final Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket s = socket;
                 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
                String message = in.readLine();
                System.out.println("[" + Thread.currentThread().getName() + "] received: " + message);
            } catch (IOException e) {
                System.out.println("[" + Thread.currentThread().getName() + "] error: " + e.getMessage());
            }
        }
    }
}

import java.io.*;
import java.net.*;

/**
 * Q20: multithreaded TCP server on port 5002. Every accepted client gets its own thread; each client
 * sends a message and the server prints it together with the handling thread's name.
 * Optional argument: number of clients to serve before shutting down (default 0 = run forever).
 */
public class MultiClientServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 5002;
        int maxClients = args.length > 0 ? Integer.parseInt(args[0]) : 0;
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("MultiClientServer listening on port " + PORT + (maxClients > 0 ? " (will serve " + maxClients + " clients)" : ""));
            Thread[] workers = new Thread[Math.max(maxClients, 0)];
            int served = 0;
            while (maxClients == 0 || served < maxClients) {
                Socket client = server.accept();
                Thread t = new Thread(new ClientHandler(client));      // one thread per client
                t.start();
                if (maxClients > 0) workers[served] = t;
                served++;
            }
            for (Thread t : workers) { try { t.join(); } catch (InterruptedException ignored) { } }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;
        ClientHandler(Socket socket) { this.socket = socket; }

        @Override public void run() {
            try (Socket s = socket;
                 BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
                String msg = in.readLine();
                System.out.println("[" + Thread.currentThread().getName() + "] " + msg);
            } catch (IOException e) {
                System.err.println("[" + Thread.currentThread().getName() + "] error: " + e.getMessage());
            }
        }
    }
}

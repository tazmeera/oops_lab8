import java.io.*;
import java.net.*;

/** Q18: read and print the content of a web page using a URL object (default http://example.com). */
public class WebReader {
    public static void main(String[] args) {
        String address = args.length > 0 ? args[0] : "http://example.com";
        try {
            URL url = new URL(address);
            System.out.println("Protocol: " + url.getProtocol() + " | Host: " + url.getHost() + " | Path: '" + url.getPath() + "'");
            System.out.println("-------- content --------");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = in.readLine()) != null) System.out.println(line);
            }
        } catch (MalformedURLException e) {
            System.err.println("Bad URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Could not read " + address + ": " + e);
        }
    }
}

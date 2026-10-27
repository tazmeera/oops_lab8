import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Q18. Reads and prints the content of http://example.com using a URL object.
 * Optional: pass a different URL as the first argument.
 */
public class WebReader {

    public static void main(String[] args) {
        String address = args.length > 0 ? args[0] : "http://example.com";
        try {
            URL url = new URL(address);
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read " + address + " : " + e.getMessage());
        }
    }
}

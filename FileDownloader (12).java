import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Q19. Downloads https://www.example.com/sample.txt using URLConnection and saves it as sample.txt in
 * the current folder. Optional arguments: [url] [output file name].
 */
public class FileDownloader {

    public static void main(String[] args) {
        String address = args.length > 0 ? args[0] : "https://www.example.com/sample.txt";
        String outName = args.length > 1 ? args[1] : "sample.txt";
        try {
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            System.out.println("Content type   : " + connection.getContentType());
            System.out.println("Content length : " + connection.getContentLength());

            long total = 0;
            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(outName)) {
                byte[] buffer = new byte[4096];
                int n;
                while ((n = in.read(buffer)) != -1) {
                    out.write(buffer, 0, n);
                    total += n;
                }
            }
            System.out.println("Downloaded " + total + " bytes to " + outName);
        } catch (IOException e) {
            System.out.println("Download failed: " + e.getMessage());
        }
    }
}

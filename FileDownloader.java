import java.io.*;
import java.net.*;
import java.nio.file.*;

/**
 * Q19: download a file using URLConnection (default https://www.example.com/sample.txt)
 * and save it in the current folder. Usage: java FileDownloader [url] [outputFileName]
 */
public class FileDownloader {
    public static void main(String[] args) {
        String address = args.length > 0 ? args[0] : "https://www.example.com/sample.txt";
        String outName = args.length > 1 ? args[1] : "downloaded_sample.txt";
        try {
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(10_000);
            conn.setReadTimeout(10_000);
            if (conn instanceof HttpURLConnection) {
                int code = ((HttpURLConnection) conn).getResponseCode();
                if (code != HttpURLConnection.HTTP_OK) {
                    System.err.println("Server answered HTTP " + code + " - nothing downloaded.");
                    return;
                }
            }
            System.out.println("Content-Type  : " + conn.getContentType());
            System.out.println("Content-Length: " + conn.getContentLengthLong());
            long total = 0;
            try (InputStream in = new BufferedInputStream(conn.getInputStream());
                 OutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get(outName)))) {
                byte[] buf = new byte[4096];
                int n;
                while ((n = in.read(buf)) != -1) { out.write(buf, 0, n); total += n; }
            }
            System.out.println("Downloaded " + total + " bytes to " + Paths.get(outName).toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Download failed: " + e);
        }
    }
}

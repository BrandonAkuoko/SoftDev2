package activities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchPrinter {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        Scanner scanner = new Scanner(is);
        BufferedWriter bw = new BufferedWriter(new FileWriter("google.html"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
            bw.write(line);
        }
        bw.close();
        scanner.close();
    }
    
}

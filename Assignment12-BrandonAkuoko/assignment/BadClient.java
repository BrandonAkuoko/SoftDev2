package assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BadClient {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 13000);
        PrintWriter out = new PrintWriter(server.getOutputStream());

            out.println("Bobby");
            out.flush();

            Scanner input = new Scanner(server.getInputStream());
            String response = input.nextLine();
            System.out.println(response);
            
            server.close();

    }
}

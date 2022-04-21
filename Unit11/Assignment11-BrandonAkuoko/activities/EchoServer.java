package activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(54321);
        Socket c = ss.accept();
        Scanner s = new Scanner(c.getInputStream());
        String m = s.nextLine();
        System.out.println("From Client "+ m);
    }
}

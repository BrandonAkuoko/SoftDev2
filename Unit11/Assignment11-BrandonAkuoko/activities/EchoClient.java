package activities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s = new Socket("localhost", 54321);
        OutputStream o = s.getOutputStream();
        PrintWriter p = new PrintWriter(o);
        Scanner sc = new Scanner(s.getInputStream());

        String m = "Hello Server";
        System.out.println(m);
        p.flush();
        System.out.println("Sent " + m);
        m = sc.nextLine();
        p.close();
        s.close();

    }
}

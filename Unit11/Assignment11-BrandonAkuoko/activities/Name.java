package activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Name {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("gpark.csec.rit.edu", 12345);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("Brandon");
        pw.flush();
        socket.close();
    }
}
package activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class Listener {
   public static void main(String[] args) throws IOException {
       ServerSocket ss = new ServerSocket(12347);
       System.out.println("Server is listening");
       Socket c = ss.accept();
       System.out.println("connection is accepted");

   } 
}

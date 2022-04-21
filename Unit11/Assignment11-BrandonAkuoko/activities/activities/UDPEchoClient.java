package activities;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String m = "Hello Server";
        byte[] b = m.getBytes();
        InetAddress i = InetAddress.getByName("localhost");
        DatagramPacket p = new DatagramPacket(b, b.length,i,54321);
        ds.send(p);
        System.out.println("Sent " + p);
        
        

        
    }
}

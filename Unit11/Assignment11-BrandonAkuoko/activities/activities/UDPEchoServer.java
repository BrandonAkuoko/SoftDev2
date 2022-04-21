package activities;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(54321);
        //receive
        byte[] b = new byte[1024]; 
        DatagramPacket p = new DatagramPacket(b, b.length);
        ds.receive(p);
        // String m = ds.receive(p);
        // //send
        // ds.send(p);
        String m = new String(b, 0, b.length);
        System.out.println(m);

        byte[] bo = m.getBytes();
        InetAddress i = p.getAddress();
        int port = p.getPort();
        DatagramPacket po = new DatagramPacket(bo, bo.length,i,port);
        ds.send(po);
    }
}

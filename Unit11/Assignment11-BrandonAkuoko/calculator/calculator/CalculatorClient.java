package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket dsock = new DatagramSocket(12400);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter math operation: ");
        String input = in.nextLine();
        while (!input.equals(" ")) {
            byte[] outgoing = input.getBytes();
            InetAddress i = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(outgoing, outgoing.length,i,12400);
            // System.out.println(input);
            dsock.send(packet);
            in.nextLine();
            
        }
    }
    
}

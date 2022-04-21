package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class CalculatorServer {
    public static void main(String[] args) throws IOException {
        List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
        OPERATIONS.add (new Addition());
        OPERATIONS.add (new Subtraction());
        OPERATIONS.add (new Multiplication());
        OPERATIONS.add (new Division());
        OPERATIONS.add (new FloorDivision());
        OPERATIONS.add (new Exponent());
        Calculator calculator = new Calculator(OPERATIONS);
        DatagramSocket ds = new DatagramSocket(12400);
        byte[] data = new byte[1024];
        DatagramPacket operation = new DatagramPacket(data, data.length);
        ds.receive(operation);
        String term = new String(data, 0, data.length);
        System.out.println(term);
        String[] tokens = term.strip().split(" ");
        String result;
        float op1 = Float.parseFloat(tokens[0]);
        float op2 = Float.parseFloat(tokens[2]);
        result = calculator.calculate(tokens[1], op1, op2) + "";
        byte[] bo = operation.getData();
        InetAddress i = operation.getAddress();
        int port = operation.getPort();
        DatagramPacket po = new DatagramPacket(bo, bo.length, i, port);
        System.out.println(result);
        ds.send(po);
        


    } 
   
}

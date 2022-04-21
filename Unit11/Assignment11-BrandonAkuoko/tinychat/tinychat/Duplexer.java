package tinychat;

import java.io.IOException;

import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;

public class Duplexer {

    private Socket sock;

    private Scanner netIn;

    private PrintWriter netOut;

   

    public Duplexer(Socket socket)  throws IOException {

        sock = socket;

        netIn = new Scanner (socket.getInputStream ());

        netOut = new PrintWriter (socket.getOutputStream ());

    }

 

    public void close() throws IOException {

        sock.close ();

        netOut.close ();

        netIn.close ();

    }

 

    public void send (String message) {

        netOut.println (message);

        netOut.flush ();

    }

 

    public String read () {

        return netIn.nextLine ();

    }

}
package tinychat;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler extends Duplexer implements Runnable{
    private Socket socket;
    private List<Socket> list;
    
    public ClientHandler(Socket socket, List<Socket> list) throws IOException{
        super(socket);
        this.socket = socket;
        this.list = list;
    }
    @Override
    public void run() {
        String recieve;
        boolean temp = true;
        while (temp) {
            recieve = read();
            String[] array = recieve.split("+");
            if (array[0].equals(">")) {
                send("Connected");
                for (Socket sock : list) {
                   if (sock != socket) {
                       Duplexer dup;
                    try {
                        dup = new Duplexer(sock);
                        dup.send(array[1] + ": Connected"); 
                        break;
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                       
                       
                   } 
                } 
            }
            if (array[0].equals("Quit")) {
                System.out.println("Closing");
                break;
            }
            else{
                for (Socket sock : list) {
                    Duplexer d;
                    try {
                        d = new Duplexer(sock);
                        d.send(array[1] + ": " + array[2]);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

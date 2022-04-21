package tinychat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class TinyChatServer{
    
    
    private static List<Socket> list = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(12410);
        while (true) {
            Socket socket = ss.accept();
            list.add(socket);
            ClientHandler handler = new ClientHandler(socket, list);
            Thread hand = new Thread(handler);
            hand.start();
            
        }

    }
    
}

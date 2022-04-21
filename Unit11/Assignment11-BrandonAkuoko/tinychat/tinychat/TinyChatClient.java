package tinychat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatClient extends Duplexer implements Runnable{
    
    private static boolean temp = false;
    

    public TinyChatClient(Socket socket)throws IOException{
        super(socket);
        
    }

    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 12410);
        TinyChatClient client = new TinyChatClient(s);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter name: ");
        String line = scanner.nextLine();
        String name = ">+" + line;
        String nameTemp = line + "+";
        String message = "";
        // >+ Brandon + eating
        client.send(name);
        Runnable run = new Runnable(){
            @Override
            public void run() {
                while (!temp) {
                    String comment = client.read();
                    System.out.println(comment);
                    
                }
            }
        };
        Thread runnable = new Thread(run);
        runnable.start();
        while (!temp) {
            if (line.equals("Quit")) {
                client.send(nameTemp + message);
                temp = true;
                break;
            }
            else{
                client.send(nameTemp + line);
            }
            line = scanner.nextLine();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

   

    
}



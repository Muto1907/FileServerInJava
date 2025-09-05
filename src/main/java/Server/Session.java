package Server;

import jdk.dynalink.beans.StaticClass;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Session extends Thread{
    private final Socket socket;
    private static String serverMsg = "All files were sent!";
    Session(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        try(DataInputStream input = new DataInputStream(this.socket.getInputStream());
            DataOutputStream output = new DataOutputStream(this.socket.getOutputStream());
        ) {
            String clientMsg = input.readUTF();
            System.out.printf("Received: %s%n", clientMsg);
            output.writeUTF(clientMsg);
            System.out.printf("Sent: %s%n", serverMsg);
        } catch (Exception e) {
           e.printStackTrace();
        }
        finally {
            try {
                this.socket.close();
            } catch (IOException e) {
                System.out.println("Couldn't close socket.");
                e.printStackTrace();
            }
        }
    }
}

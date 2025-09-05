package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        final int PORT = 55555;
        final String ADDRESS = "127.0.0.1";
        final String clientMsg = "Give me everything you have!";
        System.out.println("Client has started!");
        String serverMsg;
        try(Socket socket = new Socket(ADDRESS, PORT);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ){
            output.writeUTF(clientMsg);
            System.out.printf("Sent: %s%n", clientMsg);
            serverMsg = input.readUTF();
            System.out.printf("Received: %s%n", serverMsg);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

package Server;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server started!");
        final int PORT = 55555;
        final String ADDRESS = "127.0.0.1";
        final int MAX_CONNECTIONS = 50;

        try (ServerSocket serverSocket = new ServerSocket(PORT, MAX_CONNECTIONS, InetAddress.getByName(ADDRESS))){
            while (true){
                Session session = new Session(serverSocket.accept());
                session.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}

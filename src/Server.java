import javafx.scene.effect.Light;

import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Server {
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        new SendIpAdress();
        ServerSocket server = new ServerSocket();
        Scanner sc = new Scanner(System.in);
        String ip = Inet4Address.getLocalHost().getHostAddress();
        server.bind(new InetSocketAddress(ip, 9999));
        try {
            while (true) {
                Socket socket = server.accept();
                try {

                    serverList.add(new ServerSomthing(socket));
                    System.out.println(serverList);

                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}
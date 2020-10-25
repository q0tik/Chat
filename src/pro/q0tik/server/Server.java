package pro.q0tik.server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    private String ip = InetAddress.getLocalHost().getHostAddress();
    private int port;

    public Server(int port) throws IOException {
        this.port = port;
        SServer();
    }

    private void SServer () throws IOException {
        server = new ServerSocket(port);
        System.out.println("Yr ip is " + ip);

        clientSocket = server.accept();

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String word = in.readLine();
        System.out.println(word);

        out.write("lolkek)");
        out.flush();

        clientSocket.close();
        in.close();
        out.close();
        System.out.println("Server closed!");
        server.close();
    }
}

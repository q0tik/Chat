package pro.q0tik.server;

import pro.q0tik.Connectable;
import pro.q0tik.Listener;
import pro.q0tik.Sender;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class Server implements Connectable { //TODO: q0tChatServer + databases
    static Socket clientSocket;
    static ServerSocket server;
    static Listener listener;
    static Sender sender;

    String ip = InetAddress.getLocalHost().getHostAddress();
    int port;

    public Server(int port) throws UnknownHostException {this.port = port;}

    @Override
    public Socket connectTo() {
        try {
            System.out.println("Successful connection!");
            return new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Something was wrong :(");
        return null;
    }

    @Override
    public String[] data() {
        return new String[] {ip, "" + port};
    }

    abstract void startServer() throws IOException;

    abstract void stopServer() throws IOException;

    //TODO: logfile...
}

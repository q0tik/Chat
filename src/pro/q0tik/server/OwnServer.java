package pro.q0tik.server;

import pro.q0tik.Listener;
import pro.q0tik.Sender;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class OwnServer extends Server {
    private String password;
    Listener listener;
    Sender sender;

    public OwnServer(int port, String password) throws IOException {
        super(port);
        this.password = (password); //TODO: to md5 hex
        startServer();
    }

    @Override
    public Socket connectTo() { //create a socket object
        try {
            return new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void closeConnection() {}

    //TODO: multithreading
    @Override
    void startServer() throws IOException {
        if (init()) {
            System.out.println(Arrays.toString(data()));
            listener.start();
            sender.start();
            if (!sender.isWorking) {
                stopServer();
            }
        }
    }

    boolean init() { //all object initialization
        try {
            server = new ServerSocket(port);
            clientSocket = server.accept();
            listener = new Listener(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
            //out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            sender = new Sender(new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    void stopServer() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
        System.out.println("Server closed!");
        server.close();
    }
}
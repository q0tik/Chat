package pro.q0tik.client;

import pro.q0tik.Connectable;
import pro.q0tik.Listener;
import pro.q0tik.Sender;

import java.io.*;
import java.net.Socket;

public class ClientCon implements Connectable {
    public ClientCon(String ip, int port, String name) throws IOException {
        this.ip = ip;
        this.port = port;
        this.username = name;
        SChat();
    }

    private final int port;
    private final String ip;

    public String username;

    private Socket clientSocket;

    Listener listener;
    Sender sender;


    private void SChat() throws IOException {
        if (init()) {
            sender.start();
            listener.start();

            try {
                sender.join();
                listener.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            closeConnection();

        }
    }

    private boolean init() {
        try {
            clientSocket = connectTo();
            sender = new Sender(username, new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())));
            listener = new Listener(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())), sender);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Socket connectTo() {
        try {
            return new Socket(ip, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void closeConnection() throws IOException {
        clientSocket.close();
        listener.in.close();
        sender.out.close();
    }

    @Override
    public String[] data() {
        return new String[]{ip, "" + port};
    }
}

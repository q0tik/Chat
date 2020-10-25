package pro.q0tik.client;

import java.io.*;
import java.net.Socket;

public class ClientCon {
    public ClientCon(String ip, int port) throws IOException {
        this.ip = ip;
        this.port = port;
        SChat();
    }

    private int port;
    private String ip;

    private Socket clientSocket;
    private BufferedReader reader;

    private BufferedReader in;
    private BufferedWriter out;

    private void SChat() throws IOException {
        clientSocket = new Socket(ip, port);
        reader = new BufferedReader(new InputStreamReader(System.in));

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String word = reader.readLine();

        out.write(word + '\n');
        out.flush();

        String serverWord = in.readLine();
        System.out.println(serverWord);

        clientSocket.close();
        in.close();
        out.close();
    }
}

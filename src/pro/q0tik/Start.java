package pro.q0tik;

import pro.q0tik.client.ClientCon;
import pro.q0tik.server.Server;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {

        if (args[0].equals("-s")) {
            new Server(6565);
        }

        if (args[0].equals("-c")) {
            new ClientCon("q0tik.pro", 6565);
        }
    }
}
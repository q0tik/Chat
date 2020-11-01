package pro.q0tik;

import java.io.BufferedReader;
import java.io.IOException;

public class Listener extends Thread{
    public BufferedReader in;
    Sender sender;


    public Listener(BufferedReader br, Sender s) {
        in = br;
        sender = s;
    }

    public void run() {
        String msg;
        while (sender.isWorking) {
            try {
                msg = in.readLine();
                if (msg != null) {
                    System.out.println("\n" + "\u001B[35m" + msg + "\u001B[0m");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

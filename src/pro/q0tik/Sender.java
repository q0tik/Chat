package pro.q0tik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sender extends Thread {
    public BufferedWriter out;
    public BufferedReader reader;
    public boolean isWorking = true;
    public String username;

    public Sender(String username, BufferedWriter bw) {
        out = bw;
        this.username = username;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        String word = "";
        while (!word.equals("/exit")) {
            try {
                word = reader.readLine();
                //System.out.println("\u001B[33m" + username + ": " + "\u001B[0m");
                out.write(username + ": " + word + '\n');
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        isWorking = false;
    }
}

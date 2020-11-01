package pro.q0tik;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sender extends Thread {
    public BufferedWriter out;
    public BufferedReader reader;
    public boolean isWorking = true;

    public Sender(BufferedWriter bw) {
        out = bw;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        String word = "";
        while (!word.equals("/exit")) {
            try {
                word = reader.readLine();
                out.write(word + '\n');
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        isWorking = false;
    }
}

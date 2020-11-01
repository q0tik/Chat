package pro.q0tik;

import java.io.BufferedReader;
import java.io.IOException;

public class Listener extends Thread{
    public BufferedReader in;

    public Listener(BufferedReader br) {
        in = br;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

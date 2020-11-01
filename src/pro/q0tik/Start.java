package pro.q0tik;

import pro.q0tik.client.ClientCon;
import pro.q0tik.server.OwnServer;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author q0tik
 * @version 1.0
 */
public class Start { //TODO: to opti&to clean
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        if (args[0].equals("-h")) {
            System.out.println("This is an online chat app\n" +
                    "-s - run as web server\n" +
                    "-c - run as a client\n" +
                    "-q - run as a client and connect to the q0tik.pro web-server");
        }

        if (args[0].equals("-s")) {
            System.out.print("Chose the port: ");
            int port = scanner.nextInt();
            System.out.print("Chose the password: ");
            String password = scanner.nextLine();
            new OwnServer(port, password); //TODO: OwnServer class... :3
        }

        { //TODO: create a normal client class (or interface)
            if (args[0].equals("-c")) {
                System.out.print("Enter a username: ");
                String name = scanner.nextLine();
                System.out.print("Enter the ip(dns): ");
                String ip = scanner.nextLine();
                System.out.print("Enter the port: ");
                int port = scanner.nextInt();
                new ClientCon(ip, port, name);
            }

            /*if (args[0].equals("-q")) {
                new ClientCon("q0tik.pro", 6565);
            }*/
        }
    }
}
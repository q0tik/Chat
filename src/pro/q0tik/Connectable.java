package pro.q0tik;

import java.io.IOException;
import java.net.Socket;

public interface Connectable {
    Socket connectTo();
    void closeConnection() throws IOException;
    String[] data();
}

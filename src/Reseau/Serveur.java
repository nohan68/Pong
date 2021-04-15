package Reseau;

import java.io.IOException;
import java.net.ServerSocket;

public class Serveur extends ServerSocket {
    public static final int PORT = 1111;

    public Serveur() throws IOException {
        super(PORT);
    }
}

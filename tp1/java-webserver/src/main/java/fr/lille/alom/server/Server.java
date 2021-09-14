package fr.lille.alom.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static int PORT = 12345;
    private boolean running = false;

    public void run() {
        System.out.println("Le serveur à démarrer sur le port " + PORT + "...");
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Le serveur est prêt");
            this.running = true;
            while(this.running) {
                Socket socket = serverSocket.accept();
                new Thread(new Session(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du démarrage du serveur");
        }
    }
}

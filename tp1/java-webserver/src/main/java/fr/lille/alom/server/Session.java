package fr.lille.alom.server;

import fr.lille.alom.Request;
import fr.lille.alom.RequestAnalyzer;
import fr.lille.alom.Servlet;
import fr.lille.alom.ServletRequestHandler;

import java.io.IOException;
import java.net.Socket;

public class Session implements Runnable {

    private final Socket socket;

    public Session(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        System.out.println("Client connecté");
        try {
            Request request = new Request(socket);
            RequestAnalyzer requestAnalyzer = new RequestAnalyzer();
            requestAnalyzer.handleRequest(request);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

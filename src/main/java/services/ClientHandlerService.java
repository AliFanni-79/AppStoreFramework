package services;

import model.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import static model.Packet.*;

public class ClientHandlerService {
    private final ConnectionService server;
    private final Socket client;
    ObjectInputStream input;
    ObjectOutputStream out;
    public ClientHandlerService(Socket client, ConnectionService server) {
        this.server = server;
        this.client = client;
    }

    void listen() {
        try {
            input = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());
        } catch (SocketException ignored) {
            System.out.println("[SERVER] Client Disconnected!");
        } catch (IOException e) {
            System.err.println("[SERVER] Server IO " + e.getMessage());
        }

        if (server.isNotClosed()) {
            try {
                serverReceiver();
            } catch (InterruptedException e) {
                System.err.println("ClientHandler Interrupt " + e.getMessage());
            }
        }
        
    }
    private void serverReceiver() throws InterruptedException {
        try {
            while (server.isNotClosed()) {
                Packet object = (Packet) input.readObject();
                switch (object.aim) {
                    case PAGE, FILE, REVIEW, SEARCH -> server.send(object.aim, client, (String) object.file);
                    default -> {
                        System.err.println("Server Side Error! Undefined Expression: " + object.aim);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (SocketException ignored) {
            System.err.println("[SERVER] Client Disconnected!");
        } catch (Exception e) {
            System.err.println("Server Side Error! " + e);
        }
    }
}

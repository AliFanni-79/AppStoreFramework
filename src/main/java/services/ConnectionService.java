package services;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static model.Packet.PAGE;
import static model.Packet.REVIEW;
import static services.CoreService.appStoreService;

public class ConnectionService {
    ServerSocket listener;
    public ConnectionService() {
        try {
            listener = new ServerSocket(1119);
            while (!listener.isClosed()) {
                Socket client = listener.accept();
                ClientHandlerService clientThread = new ClientHandlerService(client, this);
                ExecutorService clientPool = Executors.newCachedThreadPool();
                clientPool.execute(clientThread::listen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String code, Socket client, String ... request) throws Exception {
        switch (code) {
            case PAGE -> {
                switch (request[0]) {
                    case "MAIN" -> ((ObjectOutputStream) client.getOutputStream()).writeObject(new view.MainPage());
                    case "APP" -> ((ObjectOutputStream) client.getOutputStream()).writeObject(new view.AppPage());
                    default -> System.err.println("Server Side Error! Undefined Expression: " + request[0]);
                }
            }
            case REVIEW ->
                appStoreService.addReview(request[1],
                        request[2],
                        Integer.parseInt(request[3]),
                        request[4]);
            default -> System.err.println("Server Side Error! Undefined Expression: " + code);
        }
    }
    public boolean isNotClosed() {
        return !listener.isClosed();
    }
}

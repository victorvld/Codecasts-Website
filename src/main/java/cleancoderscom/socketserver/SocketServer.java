package cleancoderscom.socketserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SocketServer {
    private int port;
    private SocketService service;
    private boolean running;
    private ServerSocket serverSocket;
    private ExecutorService executor;

    public SocketServer(SocketService service, int port) throws Exception {
        this.port = port;
        this.service = service;
        serverSocket = new ServerSocket(port);
        executor = Executors.newFixedThreadPool(4);
    }

    public void start() {
        Runnable connectionHandler = () -> {
            try {
                while (running) {
                    Socket serviceSocket = serverSocket.accept();
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                service.serve(serviceSocket);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            } catch (IOException e) {
                if (running) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(connectionHandler);
        running = true;
    }

    public void stop() throws Exception {
        serverSocket.close();
        running = false;
        executor.shutdown();
        executor.awaitTermination(2000, TimeUnit.MILLISECONDS);
    }

}

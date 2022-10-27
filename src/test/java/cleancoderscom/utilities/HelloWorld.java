package cleancoderscom.utilities;

import cleancoderscom.socketserver.SocketServer;
import cleancoderscom.socketserver.SocketService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HelloWorld implements SocketService {
    public static void main(String[] args) throws Exception {
        SocketServer server = new SocketServer(new HelloWorld(), 8080);
        server.start();
    }

    @Override
    public void serve(Socket s) {
        OutputStream os = null;

        String response = "HTTP/1.1 200 OK\n" +
                "Content-Length: 21\n" +
                "\n" +
                "<h1>Hello, world</h1>";
        try {
            os = s.getOutputStream();
            os.write(response.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package cleancoderscom.socketserver;

import java.io.IOException;
import java.net.Socket;

public interface SocketService {
    public void serve(Socket s) throws IOException;
}

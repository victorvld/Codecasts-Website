package cleancoderscom.socketserver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

@Disabled
public class SocketServerTest {

    private SocketService echoService;
    private SocketServer server;
    private int port;

    @BeforeEach
    void setUp() throws Exception {
        port = 8042;
        echoService = new EchoSocketService();
        server = new SocketServer(echoService, port);
    }

    @AfterEach
    void tearDown() throws Exception {
        server.stop();
    }

    public static abstract class TestSocketService implements SocketService {
        @Override
        public void serve(Socket s) {
            try {
                doService(s);
                synchronized (this) {
                    notify();
                }
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected abstract void doService(Socket s) throws IOException;
    }

    public static class EchoSocketService extends TestSocketService {
        @Override
        protected void doService(Socket s) throws IOException {
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            OutputStream os = s.getOutputStream();
            os.write(message.getBytes());
            os.flush();
        }
    }

    @Test
    public void canEcho() throws Exception {
        server.start();
        Thread.yield();
        Socket s = new Socket("localhost", port);
        s.getOutputStream().write("echo\n".getBytes());
        String response = new BufferedReader(new InputStreamReader(s.getInputStream())).readLine();

        Assertions.assertEquals("echo", response);
    }

    @Test
    public void multipleEchoes() throws IOException, InterruptedException {
        server.start();
        Thread.sleep(100);

        Socket s1 = new Socket("localhost", port);
        Socket s2 = new Socket("localhost", port);

        s1.getOutputStream().write("echo1\n".getBytes());
        s2.getOutputStream().write("echo2\n".getBytes());

        String response1 = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
        String response2 = new BufferedReader(new InputStreamReader(s2.getInputStream())).readLine();

        Assertions.assertEquals("echo1", response1);
        Assertions.assertEquals("echo2", response2);
    }

}

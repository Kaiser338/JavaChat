package Kaiser;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient extends Thread{
    private Socket socket;
    private InputStream input;
    private BufferedReader reader;
    private OutputStream output;
    private PrintWriter writer;
    private String hostname;
    private int port;
    private ClientChat clientChat;

    public SocketClient(){
         this.port = 9999;
         this.hostname = "127.0.0.1";
    }

    public SocketClient(Socket socket, ClientChat clientChat) throws IOException {
        this.socket = socket;
        this.clientChat = clientChat;
        clientChat.setSocket(this.socket);
    }

    public void run(){
        try {
            input = this.socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            while(true) {
                String msg = "";
                msg = reader.readLine();
                clientChat.sendMessageServer(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void socketHandler() throws IOException {
        ClientChat clientChat = new ClientChat();

    }


    public void socketSendMsg(String msg) throws IOException {
        try (Socket socket = new Socket(hostname, port)) {
            output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
            System.out.println("Creating socket");
            writer.println(msg);
            this.socket = socket;
        } catch (UnknownHostException ex) {
            System.out.println("Serwer nieosiągalny: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Błąd we/wy" + ex.getMessage());
        }
    }
}

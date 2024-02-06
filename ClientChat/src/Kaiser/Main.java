package Kaiser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {



    public static void main(String[] args){
        ClientChat clientChat = new ClientChat();
        MainFrame mainFrameObject = new MainFrame(clientChat);
        try (Socket clientSocket = new Socket("127.0.0.1", 9999)) {
            SocketClient socketClient = new SocketClient(clientSocket, clientChat);
            socketClient.start();
            while(true){

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}

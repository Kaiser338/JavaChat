import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private ArrayList<ServerThread> threadList;
    private Socket socket;
    InputStream input;
    BufferedReader reader;
    OutputStream output;
    PrintWriter writer;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) throws IOException {
        this.socket = socket;
        this.threadList = threads;
    }

    public void run() {
            try {
                input = socket.getInputStream();
                reader = new BufferedReader(new InputStreamReader(input));
                output = socket.getOutputStream();
                writer = new PrintWriter(output, true);
               while (true) {
                   String msg = reader.readLine();
                   for (ServerThread sT : threadList) {
                       sT.writer.println(msg);
                   }

               }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }



}
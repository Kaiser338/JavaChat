package Kaiser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientChat {
    private JTextArea textArea;
    private JTextField textField;
    private JPanel chatPanel;
    private JButton confirmMessage;
    private String nickname;
    private Socket socket;

    public ClientChat() {


        confirmMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = nickname + ": "+textField.getText();
                sendMessage(msg);

                try {
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println(msg);
                    textField.setText("");
                    //socketClient.socketSendMsg(msg);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


    }

    public void sendMessage(String msg){
        //textArea.append(msg);
        //textField.setText("");
    }

    public void sendMessageServer(String msg){
        textArea.append(msg+"\n");
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public JPanel getChatPanel(){
        return chatPanel;
    }

    public void setSocket(Socket socket){this.socket = socket;}


}

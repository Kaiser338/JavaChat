package Kaiser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientSetName {
    private JTextField textNickname;
    private JButton buttonNickname;
    private JPanel nicknamePanel;
    private ClientChat clientChat;

    public ClientSetName(ClientChat clientChat) {
        buttonNickname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nick = textNickname.getText();
                if (nick != ""){
                    MainFrame mainFrame = new MainFrame(clientChat);

                    clientChat.setNickname(nick);
                    JPanel chatPanel = clientChat.getChatPanel();
                    mainFrame.changeContentPane(chatPanel);
                }
            }
        });
    }

    public JPanel getNicknamePanel(){
        return nicknamePanel;
    }
}

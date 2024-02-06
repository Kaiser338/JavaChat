package Kaiser;

import javax.swing.*;

public class MainFrame {
    private static JFrame mainFrame = new JFrame("Chat");;
    private ClientChat clientChat;

    public MainFrame(ClientChat clientChat){
        this.clientChat = clientChat;
        ClientSetName clientSetName = new ClientSetName(this.clientChat);
        mainFrame.setContentPane(clientSetName.getNicknamePanel());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame(){
        return mainFrame;
    }

    public void changeContentPane(JPanel pane){
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(pane);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }





}

package deprecatedStuff;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;

@Singleton
public class HanabiUI {

    @Inject
    private RequestSenderService requestSender;

    private JFrame frame = new JFrame("CLIENT");
    private JTextField textField = new JTextField(40);
    private JTextArea messageArea = new JTextArea(8, 40);
    private JButton sendConnectionRequestButton = new JButton("Send connectionRequest");

    public HanabiUI() {
        initializeUI();
    }

    private final void initializeUI() {
        textField.setEditable(true);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(sendConnectionRequestButton, "South");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        textField.addActionListener(listener -> {
            requestSender.sendChatMessage(textField.getText());
            textField.setText("");
        });

        sendConnectionRequestButton.addActionListener(listener -> {
            //            requestSender.sendConnectionRequest("TYBRIS" + Math.random());
            //            requestSender.sendConnectionRequest("TYBRIS" + Math.random());

            requestSender.sendDiscardCardRequest(new Card(Color.BLUE, Number.ONE));
        });
    }

    public void showUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void handleChatMessage(String message) {
        messageArea.append(message + "\n");
    }
}

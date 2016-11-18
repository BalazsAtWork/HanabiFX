package de.novatec.cg.sc.hanabi.client;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.common.configuration.Config;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

public class Client {

    public static final void connectToServer() {
        new Client().connectAsClientToServer();
    }

    @Inject
    private LoggingService loggingService;

    //    private PrintWriter outToServer;

    private Client() {
        GuiceInjector.injectMembersInto(this);
    }

    private final void connectAsClientToServer() {
        try {
            loggingService.logClientMessage("Connecting to " + Config.SERVER_URI);
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(HanabiClientEndpoint.class, URI.create(Config.SERVER_URI));
        } catch (DeploymentException | IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        //        loggingService.logClientMessage("TRY CONNECT TO SERVER");
        //        try (Socket client = new Socket(Config.HOST_NAME, Config.SERVER_PORT)) {
        //
        //            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //            frame.setVisible(true);
        //
        //            loggingService.logClientMessage("CONNECTING TO SERVER SUCCESSFUL");
        //            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        //            outToServer = new PrintWriter(client.getOutputStream(), true);
        //jsonContainer-->{"payloadType":"GAMESTATE","payload":"{\"hintTokens\":0,\"errorTokens\":0,\"jsonType\":\"GAMESTATE\"}"}
        //            outToServer.println("HELLO SERVER! CAN YOU HEAR ME?");

        //             ESSAGE FROM CLIENT: {"payloadType":"GAMESTATE","payload":"{"hintTokens":0,"errorTokens":0,"jsonType":"GAMESTATE"}"}

        //            JsonService mngr = new JsonService();
        //            PayloadContainer obj2 = new PayloadContainer();
        //            obj2.payload = mngr.fromObjectToJson(new ConnectionRequest());
        //            String message = mngr.fromObjectToJson(obj2);
        //
        //            outToServer.println(message);

        //            while (true) {
        //                loggingService.logClientMessage("WAIT FOR MESSAGES FROM SERVER");
        //                String fromServer = inFromServer.readLine();
        //                loggingService.logClientMessage("MESSAGE FROM SERVER->" + fromServer);
        //                messageArea.append(fromServer);
        //                try {
        //                    Thread.sleep(2000);
        //                } catch (InterruptedException e) {
        //                    // TODO Auto-generated catch block
        //                    e.printStackTrace();
        //                }
        //            }
        //        } catch (
        //
        //        IOException e) {
        //            loggingService.logClientMessage("NO SERVER AVAILABLE ON HOST: " + Config.HOST_NAME + " PORT: " + Config.SERVER_PORT);
        //            return false;
        //        }
    }
}

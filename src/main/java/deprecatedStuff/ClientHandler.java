package deprecatedStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.common.payload.handler.ResponseMessageHandler;
import de.novatec.cg.sc.hanabi.common.service.JsonService;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

@Singleton
public class ClientHandler {

    @Inject
    private LoggingService loggingService;

    private int numberOfClientsConnected = 0;

    private final List<PrintWriter> clientWriter = new ArrayList<>();

    public final void handle(Socket client) {
        new ClientThread(client).start();
        numberOfClientsConnected++;
        loggingService.logServerMessage("NumberOfClientsConnected: " + numberOfClientsConnected);
    }

    private static final class ClientThread extends Thread {

        @Inject
        private LoggingService loggingService;

        @Inject
        private ResponseMessageHandler payloadHandler;

        @Inject
        private JsonService jsonManager;

        private final Socket client;

        private ClientThread(Socket client) {
            GuiceInjector.injectMembersInto(this);
            this.client = client;
        }

        @Override
        public void run() {
            loggingService.logServerMessage("A CLIENT HAS CONNECTED: " + client);
            loggingService.logServerMessage("client.getPort(): " + client.getPort());
            loggingService.logServerMessage("client.getLocalPort(): " + client.getLocalPort());
            loggingService.logServerMessage("client.getInetAddress(): " + client.getInetAddress());
            loggingService.logServerMessage("client.getLocalAddress(): " + client.getLocalAddress());
            try {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter outToClient = new PrintWriter(client.getOutputStream(), true);
                outToClient.println("YOU HAVE SUCCESSFULLY CONNECTED TO SERVER");

                while (true) {
                    loggingService.logServerMessage("WAITING FOR MESSAGES FROM CLIENT");
                    String inputFromClient = inFromClient.readLine();
                    loggingService.logServerMessage("MESSAGE FROM CLIENT: " + inputFromClient);
                    outToClient.println("OK");

                    //                    PayloadContainer payloadContainer = jsonManager.fromJsonToObject(inputFromClient, PayloadContainer.class);
                    //                    payloadHandler.handle(payloadContainer);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

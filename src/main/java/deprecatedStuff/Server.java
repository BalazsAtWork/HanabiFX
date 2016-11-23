package deprecatedStuff;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

public class Server {

    public static final void startupServer() {
        new Server().startServer();
    }

    @Inject
    private LoggingService loggingService;

    @Inject
    private ClientHandler clientHandler;

    private Server() {
        GuiceInjector.injectMembersInto(this);
    }

    private final void startServer() {
        try (ServerSocket server = new ServerSocket(4444)) {
            loggingService.logServerMessage("STARTING UP-->");

            while (true) {
                loggingService.logServerMessage("WAITING FOR CLIENTS");
                Socket connectedClient = waitingForClientConnectingTo(server);
                clientHandler.handle(connectedClient);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Socket waitingForClientConnectingTo(ServerSocket server) throws IOException {
        return server.accept();
    }
}

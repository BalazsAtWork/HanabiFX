package deprecatedStuff;

import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.client.Client;

@Singleton
public class HanabiGame {

    public void startHanabi() {
        //        boolean successfullyConnectedAsClient =
        Client.connectToServer();
        //                if (!successfullyConnectedAsClient) {
        //        Server.startupServer();
        //                }
    }
}

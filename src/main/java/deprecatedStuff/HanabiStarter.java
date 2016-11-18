package deprecatedStuff;

import de.novatec.cg.sc.hanabi.GuiceInjector;

public class HanabiStarter {

    public static void main(String[] args) {
        HanabiGame hanabiGame = GuiceInjector.get(HanabiGame.class);
        hanabiGame.startHanabi();
    }
}

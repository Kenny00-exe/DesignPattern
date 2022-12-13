package Template_Strategy;

import Builder.Game;
import ChainOfResponsibility.PlayerFighters;
import Servant.Preparation;

public class Challenge extends Game implements Preparation {

    private PlayerFighters playerFighters;

    public Challenge(String Name) {
        super(Name);
        playerFighters = new PlayerFighters();
    }

    @Override
    public void gameStart() {
        playerFighters.fight();
    }

    @Override
    public void gameEnd() {
        setVisited(true);
    }

    @Override
    public void getValue(int no) {

    }

    @Override
    public void gamePreparation() {

    }
}

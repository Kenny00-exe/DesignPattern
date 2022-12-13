package ChainOfResponsibility;

import SimpleFactory.Player;

public class PlayerFighter extends AbstractOpponent {

    private Player character;
    private PlayerFighter presentFighter;

    public PlayerFighter() {
    }

    public Player getCharacter() {
        return character;
    }

    public void setCharacter(Player character) {
        this.character = character;
    }

}


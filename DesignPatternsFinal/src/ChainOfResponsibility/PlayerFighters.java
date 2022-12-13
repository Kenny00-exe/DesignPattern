package ChainOfResponsibility;

import Iterator.PlayerContainer;

import java.util.ArrayList;
import java.util.Random;

public class PlayerFighters {

    private ArrayList<PlayerFighter> playerFighters = new ArrayList<>();
    private PlayerFighter presentFighter;

    public PlayerFighters() {
        for (int i = 0; i < 4; ++i) {
            PlayerFighter playerFighter = new PlayerFighter();
            playerFighter.setCharacter(PlayerContainer.getInstance().get(i));
            playerFighters.add(playerFighter);
        }
    }

    public void fight() {
        int i = 1;
        presentFighter = playerFighters.get(0);
        presentFighter.setNextAbstractOpponent(playerFighters.get(1));

        while (i < playerFighters.size()) {
            PlayerFighter nextFighter = (PlayerFighter) presentFighter.getNextAbstractOpponent();
            Random rand = new Random();
            double random = (rand.nextInt(100));
            if (random >= 50) {
                System.out.println("第" + i + "轮：" + presentFighter.getCharacter().getCharacterName()
                        + " vs " + nextFighter.getCharacter().getCharacterName() + "  胜者："
                        + presentFighter.getCharacter().getCharacterName());
                if (i == 3) {
                    break;
                }
                presentFighter.setNextAbstractOpponent(playerFighters.get(++i));
            } else {
                System.out.println("第" + i + "轮：" + presentFighter.getCharacter().getCharacterName()
                        + " vs " + nextFighter.getCharacter().getCharacterName() + "  胜者："
                        + nextFighter.getCharacter().getCharacterName());
                if (i == 3) {
                    presentFighter = (PlayerFighter) presentFighter.getNextAbstractOpponent();
                    break;}
                presentFighter = (PlayerFighter) presentFighter.getNextAbstractOpponent();
                presentFighter.setNextAbstractOpponent(playerFighters.get(++i));
            }
        }
        System.out.println("冠军是" + presentFighter.getCharacter().getCharacterName() + '!');
    }
}

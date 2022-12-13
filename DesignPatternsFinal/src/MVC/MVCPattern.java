package MVC;

import SimpleFactory.Player;
import SimpleFactory.PlayerFactory;

import java.util.Scanner;

public class MVCPattern {
    public static void main(String[] args) {
        Player model = getCharacter();

        CharacterViews views = new CharacterViews();

        CharacterController controller = new CharacterController(model,views);

        controller.updateView();

        String str;
        System.out.println("plz input new name:");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        controller.setCharacterName(str);

        controller.updateView();
    }

    private static Player getCharacter(){
        return new PlayerFactory().createPlayer("Slime", "Mage");
    }
}

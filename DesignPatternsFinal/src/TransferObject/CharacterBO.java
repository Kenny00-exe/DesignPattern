package TransferObject;

import SimpleFactory.Player;
import SimpleFactory.PlayerFactory;

import java.util.ArrayList;
import java.util.List;

public class CharacterBO {
    List<Player> characters;

    public CharacterBO() {
        characters = new ArrayList<>();
        Player character1 = new PlayerFactory().createPlayer("Slime", "Mage");
        Player character2 = new PlayerFactory().createPlayer("Tcho_Tcho", "Warrior");
        Player character3 = new PlayerFactory().createPlayer("Elf", "Archer");
        characters.add(character1);
        characters.add(character2);
        characters.add(character3);
    }

    //删除玩家
    public void deleteCharacter(Player character) {
        characters.remove(character);
        System.out.println(character.getCharacterName() + "已经被删除");
    }

    //getter
    public List<Player> getAllCharacters() {
        return characters;
    }

    public Player getCharacter(int rollNo) {
        return characters.get(rollNo);
    }

    //更新玩家列表
    public void updateCharacter(Player character) {
        characters.add(character);
        System.out.println(character.getCharacterName() + ", 加入了游戏!");
    }
}
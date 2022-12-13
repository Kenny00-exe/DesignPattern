package SimpleFactory;

import State.StateGood;

public class PlayerFactory {
    //创建并初始化玩家
    public Player createPlayer(String race, String ability) {
        PlayerIngredientFactory playerIngredientFactory = new PlayerIngredientFactory();
        Player player = new Player();
        player.setCharacterRace(playerIngredientFactory.setRace(race));
        player.setCharacterAbility(playerIngredientFactory.setAbility(ability));
        player.setCharacterName(race+"("+ability+")");
        if (player.getCharacterRace().getRace() == "Slime") {
            player.setIntelligence(100);
            player.setPhysical(100);
            player.setStrength(100);
            player.setSkill(100);
        } else if (player.getCharacterRace().getRace() == "Tcho_Tcho") {
            player.setIntelligence(89);
            player.setPhysical(106);
            player.setStrength(108);
            player.setSkill(92);
        } else if (player.getCharacterRace().getRace() == "Elf") {
            player.setIntelligence(110);
            player.setPhysical(80);
            player.setStrength(90);
            player.setSkill(110);
        }
        player.setRank(new int[]{0, 0, 0});
        player.setDamage(new double[]{0, 0, 0});
        player.setCharacterState(new StateGood());
        return player;
    }

}

package AbstractFactory;

public class Boss {
    private String BossName;
    private Race BossRace;
    private GameType gameType;

    private BossIngredientFactory factory;// factory interface

    //getter & setter
    public BossIngredientFactory getFactory() {
        return factory;
    }

    public void setFactory(BossIngredientFactory factory) {//bind product factory
        this.factory = factory;
    }

    public String getBossName() {
        return BossName;
    }

    public void setBossName(String bossName) {
        BossName = bossName;
    }

    public GameType getGameType() {
        return gameType;
    }

    public Race getBossRace() {
        return BossRace;
    }

    public void setBossRace(Race bossRace) {
        BossRace = bossRace;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}

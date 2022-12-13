package AbstractFactory;

public class BossStore {
    //单例模式
    private static BossStore instance = new BossStore();
    private BossStore() { }
    public static BossStore getInstance() {
        return instance;
    }

    //选择对应工厂
    public Boss createBoss(String BossName) {

        Boss boss = new Boss();
        BossIngredientFactory factory;

        switch (BossName) {
            case "LichKing":
                factory = new ICCInstanceFactory();
                boss.setFactory(factory);
                break;
            case "DeathWing":
                factory = new CataclysmInstanceFactory();
                boss.setFactory(factory);
                break;
            default:
                break;
        }

        return boss;
    }

    //设置副本、种族
    public Boss orderBoss(String BossName) {
        Boss boss = createBoss(BossName);
        boss.setGameType(boss.getFactory().CreateType());
        boss.setBossRace(boss.getFactory().CreateRace());
        return boss;
    }

}

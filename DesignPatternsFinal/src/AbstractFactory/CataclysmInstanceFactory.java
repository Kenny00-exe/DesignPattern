package AbstractFactory;

public class CataclysmInstanceFactory implements BossIngredientFactory {
    //大灾变
    @Override
    public Race CreateRace() {
        return new LichKing();
    }

    @Override
    public GameType CreateType() {
        return new Cataclysm();
    }
}

package AbstractFactory;

public class ICCInstanceFactory implements BossIngredientFactory {
    //冰冠堡垒
    @Override
    public Race CreateRace() {
        return new DeathWing();
    }

    @Override
    public GameType CreateType() {
        return new Cataclysm();
    }
}

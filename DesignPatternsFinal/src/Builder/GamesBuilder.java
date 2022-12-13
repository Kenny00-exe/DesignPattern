package Builder;

import Template_Strategy.Challenge;
import Iterator.GameContainer;
import Template_Strategy.Cataclysm;
import Template_Strategy.IcecrownCitadel;

public class GamesBuilder {

    //单例模式
    private static GamesBuilder instance = new GamesBuilder();
    private GamesBuilder() { }
    public static GamesBuilder getInstance() {
        return instance;
    }

    //创建所有副本
    public void buildGames() {
        GameContainer.getInstance().add(new Cataclysm("大灾变"));
        GameContainer.getInstance().add(new IcecrownCitadel("冰冠堡垒"));
        GameContainer.getInstance().add(new Challenge("天下第一武道会"));
    }
}

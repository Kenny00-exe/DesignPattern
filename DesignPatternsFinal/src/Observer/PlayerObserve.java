package Observer;

import Iterator.PlayerContainer;

public class PlayerObserve implements Observer {

    int PlayerNum;

    public PlayerObserve(int playerNum) {
        PlayerNum = playerNum;
    }

    //更新同步数据
    @Override
    public void update(int game, int rank, double damage) {
        PlayerContainer.getInstance().get(PlayerNum).getRank()[game] = rank;
        PlayerContainer.getInstance().get(PlayerNum).getDamage()[game] = damage;
    }
}

package Observer;

import java.util.ArrayList;
import java.util.List;

public class DamageSubject implements Subject {
    //单例模式
    private static DamageSubject instance = new DamageSubject();
    private DamageSubject() {
        for (int i = 0; i < 4; ++i) {
            registerObserver(new PlayerObserve(i));
        }
    }
    public static DamageSubject getInstance() {
        return instance;
    }

    private List<Observer> OBList = new ArrayList<Observer>();

    //增加观察者
    @Override
    public void registerObserver(Observer observer) {
        OBList.add(observer);
    }

    //移除观察者
    @Override
    public void removeObserver(Observer observer) {
        OBList.remove(observer);
    }

    //通知所有观察者
    @Override
    public void notifyObserver(int game, int[] rank, double[] damage) {
        for (int i = 0; i < rank.length; ++i) {
            OBList.get(i).update(game, rank[i], damage[i]);
        }
    }
}

package Iterator;

import AbstractFactory.Boss;

import java.util.ArrayList;

public class BossContainer implements Container {
    //Boss容器

    //单例模式
    private static BossContainer instance = new BossContainer();
    //建立boss容器
    private ArrayList<Boss> bosses;

    private BossContainer() {
        bosses = new ArrayList<>();
    }

    public static BossContainer getInstance() {
        return instance;
    }

    //根据指针返回容器对应的对象
    public Boss get(int index) {
        return bosses.get(index);
    }

    //在容器末尾增加对象
    public void add(Boss boss) {
        bosses.add(boss);
    }

    //返回容器大小
    public int size() {
        return bosses.size();
    }

    //返回容器对象
    public ArrayList<Boss> getBosses() {
        return bosses;
    }

    //生成容器迭代器
    @Override
    public Iterator iterator() {
        return new BossIterator(this);
    }
}

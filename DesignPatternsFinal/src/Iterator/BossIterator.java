package Iterator;

import AbstractFactory.Boss;

public class BossIterator implements Iterator {
    //Boss的迭代器类
    private BossContainer bossContainer;
    private int index;

    // 将操作对象容器传入
    public BossIterator(BossContainer bossContainer) {
        this.bossContainer = bossContainer;
        this.index = 0;
    }

    //判断是否有下一个对象存在
    @Override
    public boolean hasNext() {
        return index < bossContainer.size();
    }

    //指针后移
    @Override
    public Object next() {
        Boss boss = bossContainer.get(index);
        index++;
        return boss;
    }
}

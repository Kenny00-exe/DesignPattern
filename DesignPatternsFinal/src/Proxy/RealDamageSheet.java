package Proxy;

import Builder.Game;
import Iterator.GameContainer;

public class RealDamageSheet implements DamageSheet {
    @Override
    //查看已攻略副本
    public void printDamageSheet() {
        for (int i = 0; i < 2; ++i) {
            switch (i) {
                case 0:
                    System.out.println("大灾变：");
                    break;
                case 1:
                    System.out.println("冰冠堡垒：");
                    break;
                default:
                    break;
            }
            if (GameContainer.getInstance().get(i).isVisited()) {
                System.out.println("已攻略");
            }
            else
                System.out.println("未攻略");
        }
    }
}

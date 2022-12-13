package Template_Strategy;

import Builder.Game;
import Observer.DamageSubject;
import Servant.Preparation;
import SimpleFactory.Player;
import State.StateGood;
import State.StatePerfect;
import State.StateTired;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Cataclysm extends Game implements Preparation {
    public Cataclysm(String Name) {
        super(Name);
    }

    @Override
    public void gamePreparation() {
        System.out.println("大灾变副本初始化中");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大灾变副本初始化完毕");
    }

    @Override
    public void gameStart() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("挑战开始");
        for (int i = 0; i < 4; ++i) {
            getValue(i);
        }
        sortDamage();
    }

    @Override
    public void gameEnd() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setVisited(true);
        System.out.println("挑战结束");
        System.out.println("副本输出排行：");
        for (int i = 1; i <= 4; ++i) {
            System.out.println("玩家编号：" + i + "  名称：" + getPlayerLists().get(i - 1).getCharacterName() + "  输出：" + getDamage()[i - 1]);
        }
        System.out.println("MVP：" + getPlayerLists().get(getRankByRank()[0]).getCharacterName());
        System.out.println("你的输出排名：" + getRankByNO()[0]);
        DamageSubject.getInstance().notifyObserver(0, getRankByNO(), getDamage());
            switch (getPlayerLists().get(0).getCharacterState().toString()) {
                case "StatePerfect":
                    getPlayerLists().get(0).setCharacterState(new StateGood());
                    break;
                case "StateGood":
                    getPlayerLists().get(0).setCharacterState(new StateTired());
                    break;
                case "StateTired":
                    break;
                default:
                    break;
        }
    }

    @Override
    public void getValue(int no) {
        Random rand = new Random();
        double random = (rand.nextInt(200) + 900);
        Player player = getPlayerLists().get(no);
        double value = (player.getIntelligence() * 1.5 + player.getPhysical() * 0.8 + player.getStrength() * 0.9 + player.getSkill() * 1.2) / player.getCharacterState().getState();
        double damage = value * random;
        getDamage()[no] =(double)Math.round(damage*100)/100;
    }

}

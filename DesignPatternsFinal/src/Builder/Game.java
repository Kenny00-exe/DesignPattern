package Builder;

import AbstractFactory.Boss;
import AbstractFactory.BossStore;
import Iterator.PlayerContainer;
import Iterator.BossContainer;
import SimpleFactory.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    private String name;
    private List<Player> playerLists = new ArrayList<Player>();
    private Boss boss;
    private double[] damage = new double[4];
    private int[] rankByNO = new int[4];
    private int[] rankByRank = new int[4];
    private boolean isVisited;

    public Game(String Name) {
        name = Name;
        switch (Name) {
            case "大灾变":
                boss = BossStore.getInstance().orderBoss("DeathWing");
                boss.setBossName("死亡之翼");
                break;
            case "冰冠堡垒":
                boss = BossStore.getInstance().orderBoss("LichKing");
                boss.setBossName("巫妖王");
                break;
            default:
                break;
        }
        BossContainer.getInstance().add(boss);
        for (int i = 0; i < 4; ++i) {
            addPlayer(PlayerContainer.getInstance().get(i));
        }
        isVisited = false;
    }

    //getter & setter
    public void addPlayer(Player player) {
        playerLists.add(player);
    }

    public abstract void gameStart();

    public abstract void gameEnd();

    public abstract void getValue(int no);

    public String getName() {
        return name;
    }

    public List<Player> getPlayerLists() {
        return playerLists;
    }

    public Boss getBoss() {
        return boss;
    }

    public double[] getDamage() {
        return damage;
    }

    public int[] getRankByNO() {
        return rankByNO;
    }

    public int[] getRankByRank() {
        return rankByRank;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
    //排名
    public void sortDamage() {
        for (int i = 0; i < 4; ++i) {
            rankByNO[i] = 1;
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (damage[i] > damage[j]) {
                    ++rankByNO[j];
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            rankByRank[rankByNO[i] - 1] = i;
        }
    }

    //输出测试信息
    public void showGameInfo() {
        System.out.println("关卡名称：" + name);
        if (boss != null) {
            System.out.println("关卡Boss：" + boss.getBossName());
        }
        System.out.println("组队玩家名单：");
        for (int i = 1; i <= 4; ++i) {
            System.out.println("玩家编号：" + i + "  名称：" + playerLists.get(i - 1).getCharacterName());
        }
        System.out.println("\n");
    }

}

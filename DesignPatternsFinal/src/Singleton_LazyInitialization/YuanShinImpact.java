package Singleton_LazyInitialization;

import Adapter.AliAdapter;
import Adapter.WechatPay;
import Bridge.*;
import Builder.Game;
import Builder.GamesBuilder;
import Composite.Menu;
import Composite.MenuOption;
import Facade.Facade;
import FactoryMethod.ArmorFactory;
import FactoryMethod.Equipment;
import FactoryMethod.SwordFactory;
import Iterator.PlayerContainer;
import Iterator.GameContainer;
import Proxy.ProxyDamageSheet;
import Proxy.DamageSheet;
import Servant.Preparation;
import Servant.Worker;
import SimpleFactory.Player;
import SimpleFactory.PlayerFactory;
import Template_Strategy.Challenge;
import Template_Strategy.Cataclysm;
import Template_Strategy.IcecrownCitadel;

import java.util.Scanner;

public class YuanShinImpact {

    //创建 Singleton.YuanShinImpact 的一个对象

    private Player player;

    //让构造函数为 private，这样该类就不会被实例化
    private YuanShinImpact() {
    }

    public static YuanShinImpact getInstance() {
        return SingletonHolder.instance;
    }

    //测试信息
    public void showMessage() {
        System.out.println("ASM Created Successfully!");
    }

    //流程控制器
    public void flowController() throws CloneNotSupportedException {
        System.out.println("欢迎游玩⚪神！⚪神是一款由我研发的文字冒险游戏后面忘了。");
        Scanner input = new Scanner(System.in);
        //创建玩家
        System.out.println("请输入你的名字：");
        String name = input.nextLine();
        System.out.println("选择你的种族 [1]Slime [2]Tcho_Tcho [3]Elf");
        int raceNum = input.nextInt();
        System.out.println("选择你的职业 [1]Mage [2]Warrior [3]Archer");
        int abilityNum = input.nextInt();
        String race = "Slime";
        String ability = "Mage";
        switch (raceNum) {
            case 1:
                race = "Slime";
                break;
            case 2:
                race = "Tcho_Tcho";
                break;
            case 3:
                race = "Elf";
                break;
            default:
                break;
        }
        switch (abilityNum) {
            case 1:
                ability = "Mage";
                break;
            case 2:
                ability = "Warrior";
                break;
            case 3:
                ability = "Archer";
                break;
            default:
                break;
        }
        PlayerFactory playerFactory = new PlayerFactory();
        player = playerFactory.createPlayer(race, ability);
        player.setCharacterName(name);
        PlayerContainer.getInstance().add(player);
        //创建NPC玩家
        PlayerContainer.getInstance().add(playerFactory.createPlayer("Slime", "Mage"));
        PlayerContainer.getInstance().add(playerFactory.createPlayer("Tcho_Tcho", "Warrior"));
        PlayerContainer.getInstance().add(playerFactory.createPlayer("Elf", "Archer"));
        //创建秘境
        GamesBuilder.getInstance().buildGames();
        for (Game game : GameContainer.getInstance().getGames()) {
            game.showGameInfo();
        }
        //玩家与NPC载入
        Facade facade = new Facade();
        facade.method();
        //游戏正式开始
        //设置测试用菜单
        Menu rootMenu = new Menu("大厅选择");
        //第一个副本菜单
        Menu gameMenu = new Menu("副本");
        //创建三个副本实例
        int element = 0;
        MenuOption cataclysm = new MenuOption("大灾变", GameContainer.getInstance().get(0));
        MenuOption icecrown = new MenuOption("冰冠堡垒", GameContainer.getInstance().get(1));
        MenuOption challenge = new MenuOption("天下第一武道会", GameContainer.getInstance().get(2));
        // 向副本菜单中添加三个选项
        // 可在此处创建三个副本实例替换 Add 中参数 element  后续同理
        gameMenu.add(cataclysm);
        gameMenu.add(icecrown);
        gameMenu.add(challenge);
        MenuOption buyEquipment = new MenuOption("买装备", element);
        MenuOption printRank = new MenuOption("查看已攻略副本", element);
        MenuOption recharge = new MenuOption("我要氪金", element);
        rootMenu.add(gameMenu);
        rootMenu.add(buyEquipment);
        rootMenu.add(printRank);
        rootMenu.add(recharge);
        // 菜单以及选择返回
        rootMenu.printMenu();
        int i = input.nextInt();
        int gameVisited = 0;
        while (i != 0) {
            switch (i) {
                case 1: {
                    gameMenu.printMenu();
                    Game game;
                    switch (input.nextInt()) {
                        case 1:
                            game = (Cataclysm) (gameMenu.getMenu().get(0).option);
                            if (game.isVisited()) {
                                System.out.println("该副本正在重置...");
                                break;
                            }
                            Worker worker1 = new Worker();
                            worker1.prepare((Preparation) game);
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 2:
                            game = (IcecrownCitadel) (gameMenu.getMenu().get(1).option);
                            if (game.isVisited()) {
                                System.out.println("该副本正在重置...");
                                break;
                            }
                            Worker worker2 = new Worker();
                            worker2.prepare((Preparation) game);
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 3:
                            game = (Challenge) (gameMenu.getMenu().get(2).option);
                            if (game.isVisited()) {
                                System.out.println("该副本正在重置...");
                                break;
                            }
                            game.gameStart();
                            game.gameEnd();
                            ++gameVisited;
                            break;
                        case 0:
                            cataclysm.getLast().printMenu();
                            i = input.nextInt();
                            break;
                        default:
                            break;
                    }
                    if (gameVisited == 3) {
                        System.out.println("");
                    }
                    break;
                }
                case 2:
                    System.out.println("欢迎光临铁匠铺！");
                    System.out.println("购买装备 [1]长剑 [2]护甲");
                    int k = input.nextInt();
                    if (k == 1) {
                        SwordFactory swordFactory = new SwordFactory();
                        Equipment sword = swordFactory.createEquipment(player);
                        EquipmentImplementor ei = new Equip();
                        AbstractCharacterEquip equipment = new SwordEquipment(ei);
                        equipment.EquipEquipment(player, sword);
                    } else if (k == 2) {
                        ArmorFactory armorFactory = new ArmorFactory();
                        Equipment armor = armorFactory.createEquipment(player);
                        EquipmentImplementor ei = new Equip();
                        AbstractCharacterEquip equipment = new ArmorEquipment(ei);
                        equipment.EquipEquipment(player, armor);
                    }
                    break;
                case 3:
                    DamageSheet proxyDamageSheet = new ProxyDamageSheet();
                    proxyDamageSheet.printDamageSheet();
                    break;
                case 4:
                    Scanner scan = new Scanner(System.in);
                    int type;
                    System.out.println("请选择你要使用的支付方式：\n1、Ali支付  2、WeChat支付");
                    type = scan.nextInt();
                    switch (type) {
                        case 1: {
                            //使用支付宝
                            new AliAdapter().pay();
                            break;
                        }
                        case 2: {
                            //使用微信
                            new WechatPay().pay();
                            break;
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    break;
            }
            if (gameVisited == 3) {
                System.out.println("防沉迷提示:你今天的游玩时间已达到上限");
                break;
            }
            rootMenu.printMenu();
            i = input.nextInt();
        }
        System.out.println("游戏结束！感谢你的游玩！");
    }

    private static class SingletonHolder {
        // 静态初始化器，有JVM来保证线程安全
        private static YuanShinImpact instance = new YuanShinImpact();
    }

}

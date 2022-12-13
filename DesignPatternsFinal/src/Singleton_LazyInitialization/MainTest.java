package Singleton_LazyInitialization;

import AbstractFactory.Boss;
import AbstractFactory.BossStore;
import Adapter.AliAdapter;
import Bridge.AbstractCharacterEquip;
import Bridge.EquipmentImplementor;
import Bridge.Equip;
import Bridge.SwordEquipment;
import Builder.Game;
import Builder.GamesBuilder;
import Composite.Menu;
import Composite.MenuOption;
import Facade.Facade;
import FactoryMethod.Equipment;
import FactoryMethod.SwordFactory;
import Iterator.PlayerContainer;
import Iterator.GameContainer;
import MVC.CharacterController;
import MVC.CharacterViews;
import NullObject.AbstractCustomer;
import NullObject.CustomerFactory;
import Observer.DamageSubject;
import Proxy.ProxyDamageSheet;
import Proxy.DamageSheet;
import Servant.Preparation;
import SimpleFactory.Player;
import SimpleFactory.PlayerFactory;
import TransferObject.CharacterBO;

import java.util.ArrayList;

public class MainTest {
    //单例模式
    private static MainTest instance = new MainTest();
    private MainTest() { }
    public static MainTest getInstance() {
        return instance;
    }

    //测试流程控制器
    public void TestController() throws InterruptedException {
        SingletonTest();
        SimpleFactoryTest();
        IteratorTest();
        AbstractFactoryTest();
        BuilderTest();
        FacadeTest();
        CompositeTest();
        TemplateTest();
        StrategyTest();
        StateTest();
        ObserverTest();
        FactoryMethodTest();
        BridgeTest();
        ProxyTest();
        ChainOfResponsibilityTest();
        LazyInitializationTest();
        MVCTest();
        TransferObjectTest();
        NullObjectTest();
        ServantTest();
        AdapterTest();
    }

    //1 单例模式（Singleton Pattern）
    public void SingletonTest() {
        System.out.println("1 单例模式（Singleton Pattern）");
        System.out.println("包:Singleton_LazyInitialization");
        System.out.println("类：YuanShinImpact");
        System.out.println("实现接口：YuanShinImpact.getInstance()");
        System.out.println("测试信息：");
        YuanShinImpact.getInstance().showMessage();
        System.out.println();
    }

    //2 简单工厂模式（Simple Factory Pattern）
    public void SimpleFactoryTest() {
        System.out.println("2 简单工厂模式（Simple Factory Pattern）");
        System.out.println("包:SimpleFactory");
        System.out.println("类：PlayerFactory");
        System.out.println("实现接口：PlayerFactory.createPlayer(String race, String ability)");
        System.out.println("测试信息：");
        Player player = new PlayerFactory().createPlayer("Tcho_Tcho", "Warrior");
        if (player != null) {
            System.out.println("角色创建成功！");
            player.showCharacterInfo();
        } else {
            System.out.println("角色创建失败！");
        }
        PlayerContainer.getInstance().add(player);
        System.out.println();
    }

    //3 迭代器模式（Iterator Pattern）
    public void IteratorTest() {
        System.out.println("3 迭代器模式（Iterator Pattern）");
        System.out.println("包:Iterator");
        System.out.println("类：PlayerContainer");
        System.out.println("实现接口：PlayerContainer.getInstance()");
        System.out.println("测试信息：");
        PlayerFactory playerFactory = new PlayerFactory();
        PlayerContainer.getInstance().add(playerFactory.createPlayer("Slime", "Mage"));
        PlayerContainer.getInstance().add(playerFactory.createPlayer("Tcho_Tcho", "Archer"));
        PlayerContainer.getInstance().add(playerFactory.createPlayer("Elf", "Archer"));
        ArrayList<Player> players = PlayerContainer.getInstance().getPlayers();
        if (!players.isEmpty()) {
            System.out.println("玩家列表获取成功！");
            for (Player player : players) {
                player.showCharacterInfo();
            }
        } else {
            System.out.println("玩家列表获取失败！");
        }
        System.out.println();
    }

    //4 抽象工厂模式（Abstract Factory Pattern）
    public void AbstractFactoryTest() {
        System.out.println("4 抽象工厂模式（Abstract Factory Pattern）");
        System.out.println("包:AbstractFactory");
        System.out.println("类：BossStore");
        System.out.println("实现接口：boss = BossStore.getInstance().orderBoss(String BossName)");
        System.out.println("测试信息：");
        Boss boss = BossStore.getInstance().orderBoss("DeathWing");
        boss.setBossName("死亡之翼");
        System.out.println("Boss创建成功！");
        System.out.println("Boss名称：" + boss.getBossName());
        System.out.println("副本：" + boss.getGameType().toString());
        System.out.println();
    }

    //5 建造者模式（Builder Pattern）
    public void BuilderTest() {
        System.out.println("5 建造者模式（Builder Pattern）");
        System.out.println("包:Builder");
        System.out.println("类：GamesBuilder");
        System.out.println("实现接口：GamesBuilder.getInstance().buildGames()");
        System.out.println("测试信息：");
        GamesBuilder.getInstance().buildGames();
        if (!GameContainer.getInstance().getGames().isEmpty()) {
            System.out.println("副本创建成功！");
            for (Game game : GameContainer.getInstance().getGames()) {
                game.showGameInfo();
            }
        } else {
            System.out.println("副本创建失败！");
        }
        System.out.println();
    }

    //6 外观模式（Facade Pattern）
    public void FacadeTest() {
        System.out.println("6 外观模式（Facade Pattern）");
        System.out.println("包:Facade");
        System.out.println("类：Facade");
        System.out.println("实现接口：facade.method()");
        System.out.println("测试信息：");
        Facade facade = new Facade();
        facade.method();
        System.out.println();
    }

    //7 组合模式（Composite Pattern）
    public void CompositeTest() {
        System.out.println("7 组合模式（Composite Pattern）");
        System.out.println("包:Composite");
        System.out.println("类：MenuOption");
        System.out.println("实现接口：printMenu()");
        System.out.println("测试信息：");
        //设置测试用菜单
        Menu rootMenu = new Menu("大厅选择");
        //第一个副本菜单
        Menu gameMenu = new Menu("刷副本");
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
        rootMenu.add(recharge);
        rootMenu.add(buyEquipment);
        rootMenu.add(printRank);
        // 菜单以及选择返回
        System.out.println("打印一级菜单：");
        rootMenu.printMenu();
        System.out.println("打印二级菜单：");
        gameMenu.printMenu();
        System.out.println();
    }

    //8 模板模式（Template Pattern）
    public void TemplateTest() {
        System.out.println("8 模板模式（Template Pattern）");
        System.out.println("包:Template_Strategy");
        System.out.println("类：Cataclysm/IcecrownCitadel/Challenge");
        System.out.println("实现接口：game.showGameInfo()");
        System.out.println("测试信息：");
        for (Game game : GameContainer.getInstance().getGames()) {
            game.showGameInfo();
        }
        System.out.println();
    }

    //9 策略模式（Strategy Pattern）
    public void StrategyTest() {
        System.out.println("9 策略模式（Strategy Pattern）");
        System.out.println("包:Template_Strategy");
        System.out.println("类：Cataclysm/IcecrownCitadel/Challenge");
        System.out.println("实现接口：game.gameStart()");
        System.out.println("测试信息：");
        for (int i = 0; i < 3; ++i) {
            GameContainer.getInstance().get(i).gameStart();
            GameContainer.getInstance().get(i).gameEnd();
        }
        System.out.println();
    }

    //10 状态模式（State Pattern）
    public void StateTest() {
        System.out.println("10 状态模式（State Pattern）");
        System.out.println("包:State");
        System.out.println("类：CharacterState");
        System.out.println("实现接口：player.getCharacterState()");
        System.out.println("测试信息：");
        System.out.println("当前状态：" + PlayerContainer.getInstance().get(0).getCharacterState().toString());
        System.out.println();
    }

    //11 观察者模式（Observer Pattern）
    public void ObserverTest() {
        System.out.println("11 观察者模式（Observer Pattern）");
        System.out.println("包:Observer");
        System.out.println("类：PlayerObserver");
        System.out.println("实现接口：DamageSubject.getInstance().notifyObserver(int game, int[] rank, double[] damage)");
        System.out.println("测试信息：");
        Player player = PlayerContainer.getInstance().get(0);
        System.out.println("原始数据：");
        System.out.println(player.getCharacterName() + " 副本："
                + GameContainer.getInstance().get(0).getName() + " 输出："
                + player.getDamage()[0] + " 输出排名：" + player.getRank()[0]);
        DamageSubject.getInstance().notifyObserver(0, new int[]{1}, new double[]{1000000});
        System.out.println("数据同步更新成功！");
        System.out.println(player.getCharacterName() + " 副本："
                + GameContainer.getInstance().get(0).getName() + " 输出："
                + player.getDamage()[0] + " 输出排名：" + player.getRank()[0]);
        System.out.println();
    }
    //12 工厂方法模式（Factory Method Pattern）
    public void FactoryMethodTest() {
        System.out.println("12 工厂方法模式（Factory Method Pattern）");
        System.out.println("包:FactoryMethod");
        System.out.println("类：ArmorFactory/SwordFactory");
        System.out.println("实现接口：SwordFactory.createEquipment(Player owner)");
        System.out.println("测试信息：");
        Player player = PlayerContainer.getInstance().get(0);
        SwordFactory swordFactory = new SwordFactory();
        Equipment sword = swordFactory.createEquipment(player);
        System.out.println("装备创建成功！");
        System.out.println("装备类型：" + sword.getEquipmentName());
        System.out.println();
    }

    //13 桥接模式（Bridge Pattern）
    public void BridgeTest() {
        System.out.println("13 桥接模式（Bridge Pattern）");
        System.out.println("包:Bridge");
        System.out.println("类：EquipmentImplementor");
        System.out.println("实现接口：Equip.equip(Player character, Equipment equipment)");
        System.out.println("测试信息：");
        Player player = PlayerContainer.getInstance().get(0);
        System.out.println("装备前力量：" + player.getStrength());
        SwordFactory swordFactory = new SwordFactory();
        Equipment sword = swordFactory.createEquipment(player);
        EquipmentImplementor ei = new Equip();
        AbstractCharacterEquip equipment = new SwordEquipment(ei);
        equipment.EquipEquipment(player, sword);
        System.out.println("装备后力量：" + player.getStrength());
        System.out.println();
    }
    //14 代理模式（Proxy Pattern）
    public void ProxyTest() {
        System.out.println("14 代理模式（Proxy Pattern）");
        System.out.println("包:Proxy");
        System.out.println("类：ProxyDamageSheet");
        System.out.println("实现接口：ProxyDamageSheet.printDamageSheet()");
        System.out.println("测试信息：");
        DamageSheet proxyDamageSheet = new ProxyDamageSheet();
        proxyDamageSheet.printDamageSheet();
        System.out.println();
    }
    //15 责任链模式（Chain Of Responsibility Pattern）
    public void ChainOfResponsibilityTest() {
        System.out.println("15 责任链模式（Chain Of Responsibility Pattern）");
        System.out.println("包:ChainOfResponsibility");
        System.out.println("类：PlayerFighters");
        System.out.println("实现接口：PlayerFighters.fight()");
        System.out.println("测试信息：");
        GameContainer.getInstance().get(2).gameStart();
        GameContainer.getInstance().get(2).gameEnd();
        System.out.println();
    }

    //16 延迟初始化模式（Lazy Initialization Pattern）
    public void LazyInitializationTest() {
        System.out.println("16 延迟初始化模式（Lazy Initialization Pattern）");
        System.out.println("包:Singleton_LazyInitialization");
        System.out.println("类：YuanShinImpact");
        System.out.println("实现接口：YuanShinImpact.getInstance()");
        System.out.println("测试信息：");
        System.out.println("静态初始化器，通过JVM来保证线程安全");
        YuanShinImpact.getInstance().showMessage();
        System.out.println();
    }

    //17 MVC模式（MVC Pattern）
    public void MVCTest() {
        System.out.println("17 MVC模式（MVC Pattern）");
        System.out.println("包:MVC");
        System.out.println("类：CharacterController");
        System.out.println("实现接口：CharacterController.updateView()");
        System.out.println("测试信息：");
        Player player = new PlayerFactory().createPlayer("Slime", "Mage");
        CharacterViews views = new CharacterViews();
        CharacterController controller = new CharacterController(player, views);
        controller.updateView();
        System.out.println("修改名称为：塞尔达");
        controller.setCharacterName("塞尔达");
        controller.updateView();
        System.out.println();
    }

    //18 传输对象模式（Transfer Object Pattern）
    public void TransferObjectTest() {
        System.out.println("18 传输对象模式（Transfer Object Pattern）");
        System.out.println("包:TransferObject");
        System.out.println("类：CharacterBO");
        System.out.println("实现接口：CharacterBO.getCharacter(int rollNo)");
        System.out.println("测试信息：");
        CharacterBO characterBusinessObject = new CharacterBO();
        System.out.println("当前参赛成员列表：");
        for (Player characters : characterBusinessObject.getAllCharacters()) {
            System.out.println("名字: " + characters.getCharacterName());
        }
        characterBusinessObject.deleteCharacter(characterBusinessObject.getCharacter(2));
        System.out.println("当前参赛成员列表：");
        for (Player characters : characterBusinessObject.getAllCharacters()) {
            System.out.println("名字: " + characters.getCharacterName());
        }
        Player player = new PlayerFactory().createPlayer("Elf", "Archer");
        characterBusinessObject.updateCharacter(player);
        System.out.println("当前参赛成员列表：");
        for (Player characters : characterBusinessObject.getAllCharacters()) {
            System.out.println("名字: " + characters.getCharacterName());
        }
        System.out.println();
    }

    //19 空对象模式（Null Object Pattern）
    public void NullObjectTest() {
        System.out.println("19 空对象模式（Null Object Pattern）");
        System.out.println("包:NullObject");
        System.out.println("类：NullCustomer");
        System.out.println("实现接口：abstractCustomer.getName()");
        System.out.println("测试信息：");
        AbstractCustomer abstractCustomer;
        CustomerFactory customerFactory = new CustomerFactory();
        abstractCustomer = customerFactory.getCustomer("Slime(Archer)");
        boolean result = abstractCustomer.isNil();
        if (!result) {
            System.out.println("该名称存在，名称为：");
            System.out.println(abstractCustomer.getName());
        } else {
            System.out.println("名称不存在");
            System.out.println(abstractCustomer.getName());
        }
        abstractCustomer = customerFactory.getCustomer("Slime(Mage)");
        result = abstractCustomer.isNil();
        if (!result) {
            System.out.println("该名称存在，名称为：");
            System.out.println(abstractCustomer.getName());
        } else {
            System.out.println("名称不存在");
            System.out.println(abstractCustomer.getName());
        }
        System.out.println();
    }

    //20 雇工模式（Servant Pattern）
    public void ServantTest() {
        System.out.println("20 雇工模式（Servant Pattern）");
        System.out.println("包:Servant");
        System.out.println("类：Worker");
        System.out.println("实现接口：Worker.prepare(Preparation game)");
        System.out.println("测试信息：");
        Preparation game = (Preparation) GameContainer.getInstance().get(0);
        game.gamePreparation();
        System.out.println();
    }
    //21 适配器模式（Adapter Pattern）
    public void AdapterTest() {
        System.out.println("21 适配器模式（Adapter Pattern）");
        System.out.println("包:AliAdapter");
        System.out.println("类：Adapter");
        System.out.println("实现接口：AliAdapter().pay()");
        System.out.println("测试信息：");
        new AliAdapter().pay();
        System.out.println();
    }
}

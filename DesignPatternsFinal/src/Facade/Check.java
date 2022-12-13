package Facade;

import Iterator.PlayerContainer;

public class Check {
    public void dosomething() {
        System.out.println("等待所有玩家确认...");
        System.out.println("你的种族：" + PlayerContainer.getInstance().get(0).getCharacterRace().getRace());
        System.out.println("你的职业：" + PlayerContainer.getInstance().get(0).getCharacterAbility().getAbility());
        System.out.println("你的体力能力值：" + PlayerContainer.getInstance().get(0).getPhysical());
        System.out.println("你的智慧能力值：" + PlayerContainer.getInstance().get(0).getIntelligence());
        System.out.println("你的力量能力值：" + PlayerContainer.getInstance().get(0).getStrength());
        System.out.println("你的技巧能力值：" + PlayerContainer.getInstance().get(0).getSkill());
    }
}

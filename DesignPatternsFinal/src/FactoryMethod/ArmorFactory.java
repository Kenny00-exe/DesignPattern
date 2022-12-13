package FactoryMethod;

import SimpleFactory.Player;

public class ArmorFactory implements IFactory {
    //创建护甲
    @Override
    public Equipment createEquipment(Player owner) {
        return new Armor(owner);
    }
}

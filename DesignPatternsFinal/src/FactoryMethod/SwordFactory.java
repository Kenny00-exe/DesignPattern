package FactoryMethod;

import SimpleFactory.Player;

public class SwordFactory implements IFactory {
    @Override
    public Equipment createEquipment(Player owner) {
        return new Sword(owner);
    }
}

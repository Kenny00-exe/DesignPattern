package FactoryMethod;

import SimpleFactory.Player;

public class Armor extends Equipment {
    public Armor(Player owner) {
        super(owner);
    }

    @Override
    public String getEquipmentName() {
        return "Armor";
    }
}

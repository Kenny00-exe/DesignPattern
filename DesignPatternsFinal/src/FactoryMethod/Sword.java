package FactoryMethod;

import SimpleFactory.Player;

public class Sword extends Equipment {

    public Sword(Player owner) {
        super(owner);
    }

    @Override
    public String getEquipmentName() {
        return "Sword";
    }
}

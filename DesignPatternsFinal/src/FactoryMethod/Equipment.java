package FactoryMethod;

import SimpleFactory.Player;

public abstract class Equipment {
    Player Owner;

    public Equipment(Player owner) {
        Owner = owner;
    }

    public abstract String getEquipmentName();
}

package FactoryMethod;

import SimpleFactory.Player;

public interface IFactory {
    Equipment createEquipment(Player owner);
}

package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Player;

public interface EquipmentImplementor {
    public void equip(Player character, Equipment equipment);
}

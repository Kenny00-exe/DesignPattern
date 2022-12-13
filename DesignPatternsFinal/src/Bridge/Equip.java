package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Player;

public class Equip implements EquipmentImplementor {
    //桥接
    @Override
    public void equip(Player character, Equipment equipment) {
        System.out.println("成功装备" + equipment.getEquipmentName());
    }
}

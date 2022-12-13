package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Player;

public class ArmorEquipment extends AbstractCharacterEquip {
    public ArmorEquipment(EquipmentImplementor characterEquip) {
        super(characterEquip);
    }

    //桥接后增加新的功能
    @Override
    public void EquipEquipment(Player character, Equipment equipment) {
        super.EquipEquipment(character, equipment);
        character.setPhysical(character.getPhysical() + 3);
        character.setSkill(character.getSkill() - 2);
    }

}

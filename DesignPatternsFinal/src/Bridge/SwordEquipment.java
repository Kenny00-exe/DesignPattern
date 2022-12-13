package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Player;

public class SwordEquipment extends AbstractCharacterEquip {
    public SwordEquipment(EquipmentImplementor characterEquip) {
        super(characterEquip);
    }

    //桥接后增加新的功能
    @Override
    public void EquipEquipment(Player character, Equipment equipment) {
        super.EquipEquipment(character, equipment);
        character.setPhysical(character.getPhysical() + 2);
        character.setStrength(character.getStrength()+3);
        character.setSkill(character.getSkill()+1);
    }
}

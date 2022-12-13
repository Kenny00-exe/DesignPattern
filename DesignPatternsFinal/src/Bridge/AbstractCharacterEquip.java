package Bridge;

import FactoryMethod.Equipment;
import SimpleFactory.Player;

public abstract class AbstractCharacterEquip {
    private EquipmentImplementor characterEquip;

    public AbstractCharacterEquip(EquipmentImplementor characterEquip) {
        this.characterEquip = characterEquip;
    }

    public void EquipEquipment(Player character, Equipment equipment) {
        this.characterEquip.equip(character, equipment);
    }
}

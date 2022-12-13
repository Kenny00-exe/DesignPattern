package SimpleFactory;

public class PlayerIngredientFactory {
    //设置种族
    public Race setRace(String raceType) {
        if (raceType == null) {
            return null;
        }
        if (raceType.equalsIgnoreCase("TCHO_TCHO")) {
            return new Tcho_Tcho();
        } else if (raceType.equalsIgnoreCase("SLIME")) {
            return new Slime();
        } else if (raceType.equalsIgnoreCase("ELF")) {
            return new Elf();
        }
        return null;
    }

    //设置职业
    public Ability setAbility(String abilityType) {
        if (abilityType == null) {
            return null;
        }
        if (abilityType.equalsIgnoreCase("MAGE")) {
            return new Mage();
        } else if (abilityType.equalsIgnoreCase("WARRIOR")) {
            return new Warrior();
        } else if (abilityType.equalsIgnoreCase("ARCHER")) {
            return new Archer();
        }
        return null;
    }
}

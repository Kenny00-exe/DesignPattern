package SimpleFactory;

import State.CharacterState;

public class Player {
    private String CharacterName;
    private Race CharacterRace;
    private Ability CharacterAbility;
    private double intelligence;
    private double physical;
    private double strength;
    private double skill;
    private CharacterState characterState;
    private int[] Rank;
    private double[] Damage;

    public Player() {
    }

    //构造函数（不会调用，仅作为比较）
    private Player(Race race, Ability ability) {
        CharacterRace = race;
        CharacterAbility = ability;
        CharacterName = CharacterAbility.getAbility() + CharacterRace.getRace();
        if (race.getRace() == "Slime") {
            intelligence = 106;
            physical = 96;
            strength = 94;
            skill = 104;
        } else if (race.getRace() == "Tcho_Tcho") {
            intelligence = 103;
            physical = 99;
            strength = 100;
            skill = 101;
        } else if (race.getRace() == "Elf") {
            intelligence = 98;
            physical = 104;
            strength = 99;
            skill = 108;
        }
    }

    //getter & stter
    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getPhysical() {
        return physical;
    }

    public void setPhysical(double physical) {
        this.physical = physical;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSkill() {
        return skill;
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public String getCharacterName() {
        return CharacterName;
    }

    public void setCharacterName(String characterName) {
        CharacterName = characterName;
    }

    public Ability getCharacterAbility() {
        return CharacterAbility;
    }

    public void setCharacterAbility(Ability characterAbility) {
        CharacterAbility = characterAbility;
    }

    public Race getCharacterRace() {
        return CharacterRace;
    }

    public void setCharacterRace(Race characterRace) {
        CharacterRace = characterRace;
    }

    public int[] getRank() {
        return Rank;
    }

    public void setRank(int[] rank) {
        Rank = rank;
    }

    public double[] getDamage() {
        return Damage;
    }

    public void setDamage(double[] damage) {
        Damage = damage;
    }

    public CharacterState getCharacterState() {
        return characterState;
    }

    public void setCharacterState(CharacterState characterState) {
        this.characterState = characterState;
    }

    //输出测试信息
    public void showCharacterInfo() {
        System.out.println("Name is " + CharacterName + "!");
        CharacterRace.getRace();
        CharacterAbility.getAbility();
    }

}

package it.academy;


public abstract class Fighter {
    private int health;
    private final int strength;
    private final int defense;

    public Fighter(int health, int strength, int defense) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}


package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Deku extends Hero {

    private double fullCowl = 1.0;
    private static final int DAMAGE_LIMIT = 333;

    public Deku(int health, int damage, String name) {
        super(health, damage, SuperAbility.ONE_FOR_ALL, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        double boostChance = 0.5;

        if (RPG_Game.random.nextDouble() < boostChance) {
            int boostType = RPG_Game.random.nextInt(4);
            int boostPower = 0;

            switch (boostType) {
                case 0 -> {
                    fullCowl *= 1.2;
                    boostPower = 20;
                }
                case 1 -> {
                    fullCowl *= 1.5;
                    boostPower = 50;
                }
                case 2 -> {
                    fullCowl *= 2.0;
                    boostPower = 100;
                }
                default -> {
                }
            }
            int maxHealthLoss = 25;
            int healthLoss = (int) (maxHealthLoss * fullCowl);

            setHealth(getHealth() - healthLoss);
            setDamage(getDamage() + boostType);
            System.out.println(getName() + " used " + boostPower + "% one for all and lost " + healthLoss + " health");
        }
    }

    @Override
    public int getDamage() {
        int damage = (int) (super.getDamage() * fullCowl);
        return Math.min(damage, DAMAGE_LIMIT);
    }
}

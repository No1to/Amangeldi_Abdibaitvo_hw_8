package kg.geeks.game.players;

public class Golem extends Hero {

    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.ABSORPTION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int absorbedDamage = boss.getDamage() / 5;
        this.setHealth(this.getHealth() - absorbedDamage);

        System.out.println("Golem " + this.getName() + " took " + absorbedDamage + " damage from boss.");
    }

}

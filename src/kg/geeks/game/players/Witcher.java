package kg.geeks.game.players;

public class Witcher extends Hero {
    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.REVIVE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Hero deadHero = findDeadHero(heroes);
        if (deadHero != null) {
            deadHero.setHealth(this.getHealth());
            this.setHealth(0);
            System.out.println(this.getName() + " revive " + deadHero.getName());
        }
    }

    private Hero findDeadHero(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() <= 0) {
                return hero;
            }
        }
        return null;
    }
}

package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int boost = RPG_Game.random.nextInt(5) + 2;

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && !(hero instanceof Witcher)) {
                hero.setDamage(hero.getDamage() + boost);
            }
        }
        System.out.println("\n" + this.getName() + " boosts the team by " + boost);
    }
}

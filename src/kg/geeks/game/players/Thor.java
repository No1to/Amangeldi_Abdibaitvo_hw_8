package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.random.nextBoolean()) {
            boss.setSkippingRounds(1);
        }
    }
}
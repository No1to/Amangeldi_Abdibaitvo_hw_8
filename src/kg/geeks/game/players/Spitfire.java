package kg.geeks.game.players;

public class Spitfire extends Hero{
    public Spitfire(int health, int damage, String name) {
        super(health, damage, SuperAbility.AGGRESSION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int initialHealth = this.getHealth();
        // Проверяем, убили ли героя
        if (this.getHealth() <= 0 && initialHealth > 0) {
            this.setDamage(this.getDamage() + 80); // Увеличиваем урон на 80 единиц
            System.out.println("Spitfire " + this.getName() + " shows aggression and gains +80 damage!");
        }
    }
}

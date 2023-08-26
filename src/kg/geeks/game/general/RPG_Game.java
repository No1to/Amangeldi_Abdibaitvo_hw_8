package kg.geeks.game.general;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(23040, 50, "Sargeros");

        Warrior warrior = new Warrior(290, 10, "Crown");
        Warrior warrior2 = new Warrior(270, 15, "Artur");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magic magic = new Magic(280, 20, "Asta");
        Berserk berserk = new Berserk(260, 10, "Guts");
        Medic assistant = new Medic(300, 5, 5, "Strange");
        Witcher vesemir = new Witcher(300, 0, "Vesemir");
        Thor loki = new Thor(300, 30, "Loki");
        Deku midoriya = new Deku(300, 3, "Midoriya");
        Golem golem = new Golem(450, 20, "Rock");
        Spitfire spitfire = new Spitfire(230, 2, "Aggressor");

        Hero[] heroes = {warrior, warrior2, doc, magic, berserk, assistant, vesemir, loki, midoriya, golem, spitfire};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("\n" + "ROUND " + roundNumber + " ");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
        System.out.println(" ");
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }
}

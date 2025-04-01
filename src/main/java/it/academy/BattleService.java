package it.academy;

public class BattleService {

    public void fight(Player player, Enemy enemy) {
        if (player.getHealth() > 0 && enemy.getHealth() > 0) {
            int damageToEnemy = player.getStrength() - enemy.getDefense();
            if (damageToEnemy > 0) {
                enemy.setHealth(enemy.getHealth() - damageToEnemy);
                if (enemy.getHealth() <= 0) {
                    System.out.println("Enemy defeated!");
                } else {
                    int damageToPlayer = enemy.getStrength() - player.getDefense();
                    if (damageToPlayer > 0) {
                        player.setHealth(player.getHealth() - damageToPlayer);
                        if (player.getHealth() <= 0) {
                            System.out.println("Player defeated!");
                        } else {
                            System.out.println("Battle continues...");
                        }
                    } else {
                        System.out.println("Enemy couldn't hurt the player.");
                    }
                }
            } else {
                System.out.println("Player couldn't hurt the enemy.");
            }
        } else {
            if (player.getHealth() <= 0) {
                System.out.println("Player is already defeated.");
            } else {
                System.out.println("Enemy is already defeated.");
            }
        }
    }
}


package it.academy;

public class BattleService {

    public String fight(Player player, Enemy enemy) {
        if (player.getHealth() > 0 && enemy.getHealth() > 0) {
            int damageToEnemy = player.getStrength() - enemy.getDefense();
            if (damageToEnemy > 0) {
                enemy.setHealth(enemy.getHealth() - damageToEnemy);
                if (enemy.getHealth() <= 0) {
                    return "Enemy defeated!";
                } else {
                    int damageToPlayer = enemy.getStrength() - player.getDefense();
                    if (damageToPlayer > 0) {
                        player.setHealth(player.getHealth() - damageToPlayer);
                        if (player.getHealth() <= 0) {
                            return "Player defeated!";
                        } else {
                            return "Battle continues...";
                        }
                    } else {
                        return "Enemy couldn't hurt the player.";
                    }
                }
            } else {
                return "Player couldn't hurt the enemy.";
            }
        } else {
            if (player.getHealth() <= 0) {
                return "Player is already defeated.";
            } else {
                return "Enemy is already defeated.";
            }
        }
    }
}


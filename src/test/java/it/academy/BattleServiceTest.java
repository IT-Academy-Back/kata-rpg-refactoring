package it.academy;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class BattleServiceTest {

    private final BattleService service = new BattleService();


    @Test
    void givenStrongPlayer_whenFight_thenEnemyDefeatedImmediately() {
        Player player = new Player(100, 15, 10);
        Enemy enemy = new Enemy(10, 5, 5);

        var sut = service.fight(player, enemy);

        assertTrue(enemy.getHealth() <= 0, "Enemy should be defeated");
        assertEquals(100, player.getHealth(), "Player should not take damage");
        assertTrue(sut.contains("Enemy defeated!"), "Output should mention enemy is defeated.");
    }

    @Test
    void givenStrongEnemy_whenFight_thenPlayerDefeatedImmediately() {
        Player player = new Player(40, 50, 10);
        Enemy enemy = new Enemy(100, 50, 5);

        var sut = service.fight(player, enemy);

        assertTrue(player.getHealth() <= 0, "Player should be defeated");
        assertEquals(55, enemy.getHealth(), "Enemy should not take damage");
        assertTrue(sut.contains("Player defeated!"), "Output should mention player is defeated.");
    }

    @Test
    void givenBothHaveHealth_whenFight_thenBothTakeDamage() {
        Player player = new Player(100, 20, 5);
        Enemy enemy = new Enemy(50, 30, 10);

        var sut = service.fight(player, enemy);

        assertEquals(40, enemy.getHealth(), "Enemy should lose 10 HP");
        assertEquals(75, player.getHealth(), "Player should lose 25 HP");
        assertEquals("Battle continues...", sut);
    }

    @Test
    void givenWeakPlayer_whenFight_thenNoDamageToEnemy() {
        Player player = new Player(100, 5, 5);
        Enemy enemy = new Enemy(100, 10, 10);

        var sut = service.fight(player, enemy);

        assertEquals(100, enemy.getHealth(), "Enemy should take no damage");
        assertEquals(100, player.getHealth(), "Player should take no damage");
        assertEquals("Player couldn't hurt the enemy.", sut);
    }

    @Test
    void givenStrongPlayerAndWeakEnemy_whenFight_thenEnemyCannotHurtBack() {
        Player player = new Player(100, 20, 20);
        Enemy enemy = new Enemy(50, 10, 10);

        var sut = service.fight(player, enemy);

        assertEquals(40, enemy.getHealth(), "Enemy should lose 10 HP");
        assertEquals(100, player.getHealth(), "Player should not be hurt");
        assertEquals("Enemy couldn't hurt the player.", sut);
    }

    @Test
    void givenBothAreDead_whenFight_thenNoActionHappens() {
        Player player = new Player(0, 20, 10);
        Enemy enemy = new Enemy(0, 20, 10);

        var sut = service.fight(player, enemy);

        assertEquals(0, enemy.getHealth());
        assertEquals(0, player.getHealth());
        assertTrue(sut.contains("Player is already defeated."), "Output should mention player is already defeated.");
    }

    @Test
    void givenPlayerDead_whenFight_thenOnlyMessagePrinted() {
        Player player = new Player(0, 20, 10);
        Enemy enemy = new Enemy(100, 10, 5);

        var sut = service.fight(player, enemy);

        assertEquals(0, player.getHealth());
        assertEquals(100, enemy.getHealth());

        assertTrue(sut.contains("Player is already defeated."), "Output should mention player is already defeated.");
    }

    @Test
    void givenEnemyDead_whenFight_thenOnlyMessagePrinted() {
        Player player = new Player(100, 20, 10);
        Enemy enemy = new Enemy(0, 10, 5);

        var sut = service.fight(player, enemy);

        assertEquals(100, player.getHealth());
        assertEquals(0, enemy.getHealth());

        assertTrue(sut.contains("Enemy is already defeated."), "Output should mention enemy is already defeated.");

    }
}

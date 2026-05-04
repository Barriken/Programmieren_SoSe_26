package de.tha.prog2.task2;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import de.tha.prog2.task1.EinmalEins;
import de.tha.prog2.task1.GameDefinition;

class QuestionGameTest {

    @Test
    void playerAccumulatesPoints() {
        Player player = new Player("Alice");

        player.recordPoints(5);
        player.recordPoints(3);

        assertEquals("8 - Alice", player.toString());
    }

    @Test
    void playerCompareToComparesByPoints() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");

        alice.recordPoints(10);
        bob.recordPoints(5);

        assertTrue(alice.compareTo(bob) > 0);
        assertTrue(bob.compareTo(alice) < 0);
    }

    @Test
    void highScoreSortsPlayersDescending() {
        HighScore highScore = new HighScore();

        Player alice = new Player("Alice");
        alice.recordPoints(10);

        Player bob = new Player("Bob");
        bob.recordPoints(5);

        Player charlie = new Player("Charlie");
        charlie.recordPoints(15);

        highScore.recordEntry(alice);
        highScore.recordEntry(bob);
        highScore.recordEntry(charlie);

        assertEquals(
            "** HIGH SCORE **\n" +
            "15 - Charlie\n" +
            "10 - Alice\n" +
            "5 - Bob\n",
            highScore.toString()
        );
    }

    @Test
    void highScoreStoresOnlyTenPlayers() {
        HighScore highScore = new HighScore();

        for (int i = 0; i < 11; i++) {
            Player player = new Player("P" + i);
            player.recordPoints(i);
            highScore.recordEntry(player);
        }

        String result = highScore.toString();

        assertTrue(result.contains("10 - P10"));
        assertFalse(result.contains("0 - P0"));
    }

    @Test
    void createGameDefinitionLoadsEinmalEinsByReflection() throws Exception {
        QuestionGame questionGame = new QuestionGame();

        Method method = QuestionGame.class.getDeclaredMethod("createGameDefinition", String.class);
        method.setAccessible(true);
        method.invoke(questionGame, "EinmalEins");

        assertNotNull(questionGame.gameDefinition);
        assertTrue(questionGame.gameDefinition instanceof GameDefinition);
        assertTrue(questionGame.gameDefinition instanceof EinmalEins);
    }
}
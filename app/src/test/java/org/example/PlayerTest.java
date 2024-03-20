package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void testGetName() {
        String playerName = "Jugador 1";
        Player player = new Player(playerName);
        
        // Verificar que el nombre del jugador sea el esperado
        assertEquals(playerName, player.getName());
    }

    @Test
    public void testAddToHand() {
        Player player = new Player("Jugador 1");
        Card card = new Card("Hearts", "A");

        // Agregar una carta a la mano del jugador
        player.addToHand(card);

        // Verificar que la carta se haya agregado correctamente a la mano del jugador
        assertEquals(1, player.getHand().size());
        assertTrue(player.getHand().contains(card));
    }
}

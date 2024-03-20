package org.example;
import static org.junit.Assert.*;
import org.junit.Test;

public class TableTest {

    @Test
    public void testDealFlop() {
        // Crear una baraja y una mesa
        Deck deck = new Deck();
        Table table = new Table();

        // Repartir el flop
        table.dealFlop(deck);

        // Verificar que se hayan repartido tres cartas comunitarias
        assertEquals(3, table.getCommunityCards().size());
    }

    @Test
    public void testDealTurn() {
        // Crear una baraja y una mesa
        Deck deck = new Deck();
        Table table = new Table();

        // Repartir el turn
        table.dealTurn(deck);

        // Verificar que se haya repartido una carta comunitaria
        assertEquals(1, table.getCommunityCards().size());
    }

    @Test
    public void testDealRiver() {
        // Crear una baraja y una mesa
        Deck deck = new Deck();
        Table table = new Table();

        // Repartir el river
        table.dealRiver(deck);

        // Verificar que se haya repartido una carta comunitaria
        assertEquals(1, table.getCommunityCards().size());
    }
}

/*package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego de póker!");

       
        System.out.print("Ingrese el número de jugadores: ");
        int numPlayers = scanner.nextInt();
        Deck deck = new Deck();
        List<List<Card>> hands = deck.dealCards(numPlayers);

       
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Mano del Jugador " + (i + 1) + ": " + hands.get(i));
        }
        scanner.close();
    }
}*/
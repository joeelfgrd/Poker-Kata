/*package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego de póker!");

        // Solicitar al usuario que ingrese el número de jugadores
        System.out.print("Ingrese el número de jugadores: ");
        int numPlayers = scanner.nextInt();

        // Crear una instancia de la clase Deck
        Deck deck = new Deck();

        // Repartir cartas a los jugadores
        List<List<Card>> hands = deck.dealCards(numPlayers);

        // Mostrar las manos de los jugadores
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Mano del Jugador " + (i + 1) + ": " + hands.get(i));
        }

        // Cerrar el scanner
        scanner.close();
    }
}*/
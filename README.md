# Poker-Kata
## Resumen del Proyecto
  El proyecto consiste en un sistema de evaluación de manos de póker, implementado en Java. Incluye varias clases para representar las cartas, la baraja, los jugadores y la mesa de juego, así como tests unitarios para garantizar el correcto funcionamiento de las clases.
### Clases
Card:

Representa una carta de juego con un palo y un valor.
Deck:

Representa una baraja de cartas y proporciona métodos para mezclarla y repartirla.
HandRank:

Enumeración que define las posibles clasificaciones de manos de póker.
HandWithPlayerIndex:

Representa una mano de jugador con su clasificación y la carta de mayor valor.
Player:

Representa un jugador en el juego.
PlayingCard:

Representa una carta de juego con un palo y un valor, incluyendo un método para comparar cartas.
Table:

Representa la mesa de juego en el póker, con métodos para repartir cartas comunitarias.
Tests
CardTest:

Verifica el funcionamiento de los métodos de la clase Card.
DeckTest:

Verifica el funcionamiento de los métodos de la clase Deck.
HandRankTest:

Verifica que la enumeración HandRank esté definida correctamente.
HandWithPlayerIndexTest:

Verifica el funcionamiento de los métodos de la clase HandWithPlayerIndex.
PlayerTest:

Verifica el funcionamiento de los métodos de la clase Player.
PlayingCardTest:

Verifica el funcionamiento del método compareTo() de la clase PlayingCard.
TableTest:

Verifica el funcionamiento de los métodos de la clase Table.
Estos tests garantizan que las clases y sus métodos funcionen correctamente en el contexto del juego de póker.

### El orden de fuerza de las manos de póker, de menor a mayor, es el siguiente:

High Card (Carta Alta): La mano no contiene ninguna de las combinaciones descritas a continuación. En este caso, la mano se evalúa por la carta más alta que contiene.

One Pair (Par): La mano contiene dos cartas del mismo valor.

Two Pair (Doble Par): La mano contiene dos pares de cartas del mismo valor.

Three of a Kind (Trío): La mano contiene tres cartas del mismo valor.

Straight (Escalera): La mano contiene cinco cartas consecutivas de diferentes palos.

Flush (Color): La mano contiene cinco cartas del mismo palo, pero no necesariamente consecutivas.

Full House (Full): La mano contiene un trío y un par.

Four of a Kind (Póker): La mano contiene cuatro cartas del mismo valor.

Straight Flush (Escalera de Color): La mano contiene cinco cartas consecutivas del mismo palo.

Royal Flush (Escalera Real): La mano es una escalera de color que va desde el 10 hasta el as.
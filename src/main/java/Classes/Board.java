package Classes;

import java.util.ArrayList;
import java.util.Collections;

public class Board {

    // Give a random Element among the deck's elements
    public void giveRandomElement(Player player){
        Collections.shuffle(player.manaTypes);
        player.manaPool.add(player.manaTypes.getFirst());
    }

    /*
    Start Turn:
        draw a card
        give a random element
        check effects affecting the monsters (if any)
     */
    public void startTurn(Player player){
        player.drawCard();
        giveRandomElement(player);
    }

    /*
    End Turn:
        check damage due to effects affecting the monsters (if any)
        - poison
        - fire
     */
    public void endTurn(Player player){

    }


    public void initGame(Player player1, Player player2){
        player1.shuffleDeck();
        player2.shuffleDeck();
        player1.initialD();
        player2.initialD();
        System.out.println("START");
    }
}

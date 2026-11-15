package com.junia;

import Classes.Board;
import Classes.CSV.CSVReadException;
import Classes.CSV.CSVService;
import Classes.Enum.Element;
import Classes.Items.MegaPotion;
import Classes.Items.Potion;
import Classes.Monsters.Ajarakan;
import Classes.Monsters.Aknosom;
import Classes.Monsters.Barioth;
import Classes.Monsters.JinDahaad;
import Classes.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import static Classes.Player.somebodyHasWon;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, CSVReadException {
        try {
            CSVService.initialize();
            Board board = new Board();          // creation of the board
            ArrayList<Player> players = board.askPlayerName(2);

            players.get(0).addToDeck(new Ajarakan(players.get(0)));
            players.get(0).addToDeck(new Ajarakan(players.get(0)));
            players.get(0).addToDeck(new Aknosom(players.get(0)));
            players.get(0).addToDeck(new Barioth(players.get(0)));
            players.get(0).addToDeck(new Barioth(players.get(0)));
            players.get(0).addToDeck(new Aknosom(players.get(0)));
            players.get(0).addToDeck(new JinDahaad(players.get(0)));
            players.get(0).addToDeck(new JinDahaad(players.get(0)));
            players.get(0).addToDeck(new Potion(players.get(0)));
            players.get(0).addToDeck(new MegaPotion(players.get(0)));

            players.get(1).addToDeck(new Ajarakan(players.get(1)));
            players.get(1).addToDeck(new Ajarakan(players.get(1)));
            players.get(1).addToDeck(new Aknosom(players.get(1)));
            players.get(1).addToDeck(new Aknosom(players.get(1)));
            players.get(1).addToDeck(new Barioth(players.get(1)));
            players.get(1).addToDeck(new Barioth(players.get(1)));
            players.get(1).addToDeck(new JinDahaad(players.get(1)));
            players.get(1).addToDeck(new JinDahaad(players.get(1)));
            players.get(1).addToDeck(new Potion(players.get(1)));
            players.get(1).addToDeck(new MegaPotion(players.get(1)));

            Collections.shuffle(players);
            board.initGame(players.get(0),players.get(1));

            int turnNumber = 1;
            boolean playerHasPlayed = false;
            while(!somebodyHasWon(players)) {
                System.out.println("\n\n------- ROUND "+ turnNumber + " ------ ");
                playerHasPlayed = false;
                System.out.println("- " + players.getFirst().getName() + " -");
                board.startTurn(players.getFirst(),players.getLast());
                do{
                    if(board.doPlayerChoice(players.getFirst(), players.getLast()) != -1){;
                        playerHasPlayed = true;
                    };
                }while(!playerHasPlayed);
                playerHasPlayed = false;
                System.out.println("\n\n- " + players.getLast().getName() + " -");
                board.startTurn(players.getLast(),players.getFirst());
                do{
                    if(board.doPlayerChoice(players.getLast(), players.getFirst()) != -1){;
                        playerHasPlayed = true;
                    };
                }while(!playerHasPlayed);
                turnNumber++;
            }
//            Ajarakan ajarakan1 = new Ajarakan(players.get(0));
//            Aknosom aknosom1 = new Aknosom(players.get(1));
//            players.get(0).addMana(Element.Elementless);
//            players.get(0).addMana(Element.Elementless);
//            players.get(0).addMana(Element.Fire);
//            players.get(0).addMana(Element.Fire);
//            System.out.println("------------------------------------");
//            System.out.println("Verification monsters attributes");
//            System.out.println("name: "+ ajarakan1.getName());
//            System.out.println("HP: "+ ajarakan1.getHP());
//            System.out.println("Weakness: "+ ajarakan1.getWeakness());
//            System.out.println("RetreatCost: "+ ajarakan1.getRetreatCost());
//            System.out.println("Rarity: "+ ajarakan1.getRarity());
//            System.out.println("Moves: "+ ajarakan1.getMoves());
//            // ajarakan1.Attack1(aknosom1);
//            // ajarakan1.Attack2(aknosom1);
//            System.out.println(players.get(0).getManaPool());
//            ajarakan1.attack3(aknosom1);
//            System.out.println(players.get(0).getManaPool());
//            System.out.println("2nd attack: "+ ajarakan1.ShoulderRam(aknosom1));
//            System.out.println("3rd attack: "+ ajarakan1.BlastingStar(aknosom1));
//            System.out.println("------------------------------------");

        }catch (Exception e){
            System.err.println("CRASH! details: ");
            e.printStackTrace();
        }





    }

        // ----------------------------------------------------------------------------------
//        Player player1 = new Player("Audrey",new ArrayList<Card>(),new ArrayList<ConsumableCard>(),new ArrayList<Element>(List.of(Element.Fire,Element.Ice)));
//        Player player2 = new Player("Alex",new ArrayList<Card>(),new ArrayList<ConsumableCard>(),new ArrayList<Element>(List.of(Element.Fire,Element.Ice)));
//        player1.addToDeck(new Ajarakan(player1));
//        player1.addToDeck(new Ajarakan(player1));
//        player1.addToDeck(new Aknosom(player1));
//        player1.addToDeck(new Barioth(player1));
//        player1.addToDeck(new Barioth(player1));
//        player1.addToDeck(new Aknosom(player1));
//        player1.addToDeck(new JinDahaad(player1));
//        player1.addToDeck(new JinDahaad(player1));
//        player2.addToDeck(new Ajarakan(player2));
//        player2.addToDeck(new Ajarakan(player2));
//        player2.addToDeck(new Aknosom(player2));
//        player2.addToDeck(new Aknosom(player2));
//        player2.addToDeck(new Barioth(player2));
//        player2.addToDeck(new Barioth(player2));
//        player2.addToDeck(new JinDahaad(player2));
//        player2.addToDeck(new JinDahaad(player2));
//
//        Board board = new Board();
//        board.initGame(player1,player2);
//        System.out.println("P2 deck: " + player2.CardtoString(player2.getDeck()));
//        System.out.println("P2 hand: " + player2.CardtoString(player2.getHand()));
//        for(int i = 0; i < 4; i++){
//            System.out.println("tour" + i);
//            System.out.println("P1 deck: " + player1.CardtoString(player1.getDeck()));
//            System.out.println("P1 hand: " + player1.CardtoString(player1.getHand()));
//            System.out.println("P1 manapool: " + player1.ElementtoString(player1.getManaPool()));
//            System.out.println("P1 manatype: " + player1.ElementtoString(player1.getManaTypes()));
//            board.startTurn(player1);
//        }
//    }
}

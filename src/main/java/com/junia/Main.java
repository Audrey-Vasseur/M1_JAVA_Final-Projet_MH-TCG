package com.junia;

import Classes.CSV.CSVModel;
import Classes.CSV.CSVReadException;
import Classes.CSV.CSVService;
import Classes.Monsters.Ajarakan;
import Classes.Monsters.Aknosom;
import Classes.Player;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, CSVReadException {
//        var app = Javalin.create(config -> {
//            config.staticFiles.add(staticFiles -> {
//                staticFiles.directory = "web";
//                staticFiles.location = Location.CLASSPATH;});
//
//            config.routes.get("/api/test", ctx ->
//                    ctx.result("Connexion au serveur réussie"));
//        }).start(7070);


        try {
            CSVService.initialize();

            Player player1 = new Player("Audrey");
            Ajarakan ajarakan1 = new Ajarakan(player1);
            Player player2 = new Player("Alex");
            Aknosom aknosom1 = new Aknosom(player2);

            System.out.println("------------------------------------");
            System.out.println("Verification monsters attributes");
            System.out.println("name: "+ ajarakan1.getName());
            System.out.println("HP: "+ ajarakan1.getHP());
            System.out.println("Weakness: "+ ajarakan1.getWeakness());
            System.out.println("RetreatCost: "+ ajarakan1.getRetreatCost());
            System.out.println("Rarity: "+ ajarakan1.getRarity());
            System.out.println("1st attack: "+ ajarakan1.PowerPunch(aknosom1));
            System.out.println("Moves: "+ ajarakan1.getMoves());
//            System.out.println("2nd attack: "+ ajarakan1.ShoulderRam(aknosom1));
//            System.out.println("3rd attack: "+ ajarakan1.BlastingStar(aknosom1));
            System.out.println("------------------------------------");

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

    /*
    vérifier à chaque fin de tour si les cartes subissent des effets et agir en conséquence
    changer de joueur en appuyant sur un bouton pour mettre fin à son tour
    compter les tours
    lors du changement de joueur, mettre un bouton qui permet de valider
    à l'autre joueur que c'est bien lui qui joue et afficher sa main et ses objets dispo

    comptabiliser les points pour condition de victoire
    donner des points en fonction de la carte tuée
     */


//            config.staticFiles.add(staticFiles -> {
//            staticFiles.directory = "web";
//            staticFiles.location = Location.CLASSPATH;
//            });
//        }).start(7070);
//
//        app.get("/api/test", (Context ctx) -> ctx.result("Connexion au serveur Java réussie"));
//        }

}

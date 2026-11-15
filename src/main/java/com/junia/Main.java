package com.junia;

import Classes.*;
import Classes.Enum.Element;
import Classes.Monsters.Ajarakan;
import Classes.Monsters.Aknosom;
import Classes.Monsters.Barioth;
import Classes.Monsters.JinDahaad;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        var app = Javalin.create(config -> {
//            config.staticFiles.add(staticFiles -> {
//                staticFiles.directory = "web";
//                staticFiles.location = Location.CLASSPATH;});
//
//            config.routes.get("/api/test", ctx ->
//                    ctx.result("Connexion au serveur réussie"));
//        }).start(7070);

        Player player1 = new Player("Audrey",new ArrayList<Card>(),new ArrayList<ConsumableCard>(),new ArrayList<Element>(List.of(Element.Fire,Element.Ice)));
        Player player2 = new Player("Alex",new ArrayList<Card>(),new ArrayList<ConsumableCard>(),new ArrayList<Element>(List.of(Element.Fire,Element.Ice)));
        player1.addToDeck(new Ajarakan(player1));
        player1.addToDeck(new Ajarakan(player1));
        player1.addToDeck(new Aknosom(player1));
        player1.addToDeck(new Barioth(player1));
        player1.addToDeck(new Barioth(player1));
        player1.addToDeck(new Aknosom(player1));
        player1.addToDeck(new JinDahaad(player1));
        player1.addToDeck(new JinDahaad(player1));
        player2.addToDeck(new Ajarakan(player2));
        player2.addToDeck(new Ajarakan(player2));
        player2.addToDeck(new Aknosom(player2));
        player2.addToDeck(new Aknosom(player2));
        player2.addToDeck(new Barioth(player2));
        player2.addToDeck(new Barioth(player2));
        player2.addToDeck(new JinDahaad(player2));
        player2.addToDeck(new JinDahaad(player2));
        Board board = new Board();
        board.initGame(player1,player2);
        System.out.println("P2 deck: " + player2.CardtoString(player2.getDeck()));
        System.out.println("P2 hand: " + player2.CardtoString(player2.getHand()));
        for(int i = 0; i < 4; i++){
            System.out.println("tour" + i);
            System.out.println("P1 deck: " + player1.CardtoString(player1.getDeck()));
            System.out.println("P1 hand: " + player1.CardtoString(player1.getHand()));
            System.out.println("P1 manapool: " + player1.ElementtoString(player1.getManaPool()));
            System.out.println("P1 manatype: " + player1.ElementtoString(player1.getManaTypes()));
            board.startTurn(player1);
        }
    }

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

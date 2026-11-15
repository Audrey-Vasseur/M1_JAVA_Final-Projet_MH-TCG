package Classes;

import Classes.Enum.Element;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Board {
    public Scanner scanner = new Scanner(System.in);

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
    public void startTurn(Player player, Player target){
        player.drawCard();
        giveRandomElement(player);
        System.out.println(player.getManaPool());
    }

    /*
    End Turn:
        check damage due to effects affecting the monsters (if any)
        - poison
        - fire
     */
    public void endTurn(Player player){

    }


    public void askChoicesDeck(Scanner scanner){
        int choice = 0;
        boolean validInput = false;
        while (!validInput){
            System.out.println("Choose your deck:");
            System.out.println("1. Ice");
            System.out.println("2. Dragon");
            System.out.println("3. Fire");
            System.out.println("4. Thunder");
            System.out.println("5. Water");
            System.out.println("Enter your choice (1-5):");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
                switch(choice){
                    case 1:
                        System.out.println("You choose the Ice deck!");
                        validInput = true;
                        break;
                    case 2:
                        System.out.println("You choose the Dragon deck!");
                        validInput = true;
                        break;
                    case 3:
                        System.out.println("You choose the Fire deck!");
                        validInput = true;
                        break;
                    case 4:
                        System.out.println("You choose the Thunder deck!");
                        validInput = true;
                        break;
                    case 5:
                        System.out.println("You choose the Water deck!");
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid Option. Enter only a number between 1 and 5 included.");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
    //       deckChoice1 = askChoicesDeck(scanner);
    //        deckChoice2 = askChoicesDeck(scanner);

    public ArrayList<Player> askPlayerName(int numberOfPlayers){
        ArrayList<Player> playersList = new ArrayList<>();
        for(int i = 0; i < numberOfPlayers; i++){
            System.out.println("Enter the "+ (i+1) + " player's name: ");
            String namePlayer = scanner.nextLine();
            Player player = new Player(namePlayer,new ArrayList<Card>(),new ArrayList<Consumable>(),new ArrayList<Element>(List.of(Element.Fire,Element.Ice)));
            playersList.add(player);
        }
        return playersList;
    }

    public void initGame(Player player1, Player player2){
        player1.shuffleDeck();
        player2.shuffleDeck();
        player1.initialD();
        player2.initialD();
        System.out.println("START");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int chooseSpotOnBoard(Player player, boolean  limitedToBench, boolean needsToBeMonster){
        System.out.println("Choose a spot on "+player.name+"'s board :");
        if ( limitedToBench){
            System.out.println(boardToString(player, false, true));
        }else{
            System.out.println(boardToString(player, true, true));
        }
        int spot = -2;
        do{
            String input = scanner.nextLine();
            try {
                if(input.toUpperCase().equals("X")){
                    return -1;
                }
                spot = Integer.parseInt(input.trim());
                int maxSpot =  limitedToBench ? 3 : 4;
                if (spot < 1 || spot > maxSpot) {
                    throw new IllegalArgumentException("It must be between provided choices");
                }
                int index = spot - 1;

                if (needsToBeMonster) {
                    if (index >= player.board.size() || !(player.board.get(index) instanceof MonsterCard)) {
                        throw new IllegalArgumentException("It must be a Monster");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                spot =-2;
            }
        }while(spot == -2);
        return spot;
    }

    public String boardToString(Player player, boolean Active, boolean Bench){
        if(Active && !Bench){
            return ActiveToString(player);
        }
        if(!Active && Bench){
            return benchToString(player);
        }
        return boardToString(player);
    }

    private String boardToString(Player player) {
        ArrayList<Card> board = player.getBoard();

        return "Active  1: " + formatSlot(board, 0) +
                "\nBench: 2 - " + formatSlot(board, 1) +
                " | 3 - " + formatSlot(board, 2) +
                " | 4 - " + formatSlot(board, 3) +
                "\nBack : X";
    }
    private String ActiveToString(Player player) {
        ArrayList<Card> board = player.getBoard();

        return "Active: 1" + formatSlot(board, 0) +"\nBack : X";
    }
    private String benchToString(Player player) {
        ArrayList<Card> board = player.getBoard();

        return "Bench: 1 - " + formatSlot(board, 1) +
                " | 2 - " + formatSlot(board, 2) +
                " | 3 - " + formatSlot(board, 3) +
                "\nBack : X";
    }

    private String formatSlot(ArrayList<Card> board, int index) {
        if (board == null || index >= board.size() || board.get(index) == null) {
            return "Empty";
        }
        return board.get(index).toString();
    }


    public int showHand(Player player){
        String str = "";
        int i =1;
        for (Card card : player.getHand()){
            str += i +"- " + card +" ";
            i++;
        }
        System.out.println(str);
        int answer = -1;
        do{
            String input = scanner.nextLine();
            try {
                answer = Integer.parseInt(input.trim());
                if (answer < 1 || answer > player.getHand().size()) {
                    throw new IllegalArgumentException("It must be between provided choices");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                answer =-1;
            }
        }while(answer == -1);
        answer--;
        if(player.getHand().get(answer) instanceof MonsterCard){
            if(player.handToBoard(answer)){
                return 1;
            }
            return -1;
        }else{
            ItemCard ic = (ItemCard) player.getHand().get(answer);
            boolean bool = false;
            do{
                int spot = chooseSpotOnBoard(player,false,true);
                if(spot == -1){
                    bool = true;
                }else if(ic.use(spot)){
                    return 2;
                }
            }while(!bool);
            return -1;
        }
    }

    public int doPlayerChoice(Player player, Player target){
        System.out.println("What do you want to do?\n 1- Attack with " + player.getActiveMonster() + " | 2- Hand  | 3- Skip turn");
        int answer = -1;
        do{
            String input = scanner.nextLine();
            try {
                answer = Integer.parseInt(input.trim());
                if (answer < 1 || answer > 3) {
                    throw new IllegalArgumentException("It must be between provided choices");
                }
                if(answer == 1 && player.getBoard().getFirst() == null){
                    throw new IllegalArgumentException("You have no active Monster");
                }
                if(answer == 3 && player.getBoard().getFirst() == null){
                    throw new IllegalArgumentException("You need an active Monster");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                answer =-1;
            }
        }while(answer == -1);
        if(answer == 1){
            return player.getActiveMonster().executeAttack(player.getActiveMonster().chooseAttack(scanner), target);
        }else if (answer == 2){
            return showHand(player);
        }else{
            return 1;
        }
    }
}
//

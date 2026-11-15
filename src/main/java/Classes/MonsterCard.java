package Classes;

import Classes.CSV.CSVModel;
import Classes.CSV.CSVService;
import Classes.Enum.Element;
import Classes.Enum.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public abstract class MonsterCard extends Card {
    protected int HP;
    protected int maxHP;
    protected ArrayList<Element> weakness;
    protected ArrayList<Element> retreatCost;
    protected int rarity;
    protected ArrayList<Token> tokens;
    protected Player owner;
    protected ArrayList<ArrayList<String>> moves;

    // To create a basic card with no attacks (they'll be created for each monster
    // directly)
    // public MonsterCard(String name, int maxHP, Element weakness, int retreatCost,
    // int rarity, Player owner){
    // super(name);
    // this.HP = maxHP;
    // this.maxHP = maxHP;
    // this.weakness = weakness;
    // this.retreatCost = new
    // ArrayList<Element>(Collections.nCopies(retreatCost,Element.Elementless)) ;
    // this.rarity = rarity;
    // this.tokens = new ArrayList<Token>();
    // this.owner = owner;
    // }

    public MonsterCard(String name, Player owner) {
        CSVModel data = CSVService.getCardByName(name);
        super(name);
        this.tokens = new ArrayList<Token>();
        this.owner = owner;

        if (data != null) {
            this.HP = data.getHealthpoints();
            this.maxHP = data.getHealthpoints();
            this.weakness = data.getWeakness();
            this.rarity = data.getRarity();
            this.retreatCost = new ArrayList<Element>(Collections.nCopies(data.getRetreatCost(), Element.Elementless));
            this.moves = data.getMoves();
        }
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public ArrayList<Element> getWeakness() {
        return weakness;
    }

    public ArrayList<Element> getRetreatCost() {
        return retreatCost;
    }

    public int getRarity() {
        return rarity;
    }

    public ArrayList<ArrayList<String>> getMoves() {
        return moves;
    }

    // Setters
    public void setHP(int HP) {
        this.HP = HP;
    }

    /*
     * METHODS FOR ALL MONSTERS
     */

    // loseHP --> when a Monster takes damage
    public int loseHP(int damageReceived, Element element) {
        if (this.weakness.contains(element)) {
            damageReceived += 20;
        }
        HP -= damageReceived;
        return damageReceived;
    }

    // recoverHP --> when a Monster heals himself or use an object to heal
    public int recoverHP(int HPReceived) {
        HP += HPReceived;
        return HPReceived;
    }

    // retreatCostCalcul --> if the retreatCost changes due to some affliction
    public int retreatCostCalcul(int retreatCost) {
        int realRetreatCost = retreatCost;
        if (tokens.contains(Token.Iceblight)) {
            realRetreatCost += 1;
        }
        return realRetreatCost;
    }

    public void retreat(int to) {
        owner.useManaElement(retreatCost);
        owner.moveCardOnBoard(0, to);
    }

    // AddToken --> used to add tokens of affliction to a Monster
    public void AddToken(Token token) {
        tokens.add(token);
    }

    public void AddToken(Token token, int number) {
        for (int i = 0; i < number; i++) {
            AddToken(token);
        }
    }

    //
    protected ArrayList<Element> ALBuilder(int fire, int water, int ice, int thunder, int dragon, int elementless) {
        ArrayList<Element> list = new ArrayList<>();
        for (int i = 0; i < fire; i++) {
            list.add(Element.Fire);
        }
        for (int i = 0; i < water; i++) {
            list.add(Element.Water);
        }
        for (int i = 0; i < ice; i++) {
            list.add(Element.Ice);
        }
        for (int i = 0; i < thunder; i++) {
            list.add(Element.Thunder);
        }
        for (int i = 0; i < dragon; i++) {
            list.add(Element.Dragon);
        }
        for (int i = 0; i < elementless; i++) {
            list.add(Element.Elementless);
        }
        return list;
    }

    public ArrayList<Element> buildFromList(ArrayList<String> singleMoveInfo) {
        int fire = 0;
        int water = 0;
        int ice = 0;
        int thunder = 0;
        int dragon = 0;
        int elementless = 0;

        for (int i = 2; i < singleMoveInfo.size() - 1; i += 2) {
            int value = Integer.parseInt(singleMoveInfo.get(i));
            String element = singleMoveInfo.get(i + 1);

            switch (element) {
                case "Fire":
                    fire = value;
                    break;
                case "Water":
                    water = value;
                    break;
                case "Ice":
                    ice = value;
                    break;
                case "Thunder":
                    thunder = value;
                    break;
                case "Dragon":
                    dragon = value;
                    break;
                case "Elementless":
                    elementless = value;
                    break;
            }
        }
        return ALBuilder(fire, water, ice, thunder, dragon, elementless);
    }

    protected Element defineAttackElementType(ArrayList<Element> list) {
        if (list.contains(Element.Fire)) {
            return Element.Fire;
        }
        if (list.contains(Element.Water)) {
            return Element.Water;
        }
        if (list.contains(Element.Ice)) {
            return Element.Ice;
        }
        if (list.contains(Element.Thunder)) {
            return Element.Thunder;
        }
        if (list.contains(Element.Dragon)) {
            return Element.Dragon;
        }
        return Element.Elementless;
    }

    public String attackToString(String attackName, ArrayList<Element> cost, int attackDamage, Element elementType, MonsterCard enemy) {
        return this.name + " uses " + attackName + " for " + CostToString(cost) + "! \nIt deals " + attackDamage +" " + elementType + " damage to the opponent's "+ enemy.getName() +"!";

    }

    public String CostToString(ArrayList<Element> cost) {
        ArrayList<String> parts = new ArrayList<>();
        for (Element element : Element.values()) {
            int count = Collections.frequency(cost, element);
            if (count > 0) {
                parts.add(count + " " + element.name());
            }
        }
        return String.join(" and ", parts);
    }

    public int chooseAttack(Scanner scanner){
        String str = "";
        int i =1;
        for (ArrayList<String> move : moves){
            str += i +"- " + move.getFirst()+" ";
            i++;
        }
        System.out.println(str);
        int answer = -1;
        do{
            String input = scanner.nextLine();
            try {
                answer = Integer.parseInt(input.trim());
                if (answer < 1 || answer > moves.size()) {
                    throw new IllegalArgumentException("it must be between provided choices");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                answer =-1;
            }
        }while(answer == -1);
        return answer;
    }
    public abstract int executeAttack(int attackNumber, Player target);

    @Override
    public String toString() {
        return name;
    }
}

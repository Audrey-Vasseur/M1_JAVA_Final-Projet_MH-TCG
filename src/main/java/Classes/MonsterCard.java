package Classes;

import Classes.Enum.Element;
import Classes.Enum.Token;
import java.util.ArrayList;
import java.util.Collections;

public abstract class MonsterCard extends Card{
    protected int HP;
    protected int maxHP;
    protected Element weakness;
    protected ArrayList<Element> retreatCost;
    protected int rarity;
    protected ArrayList<Token> tokens;
    protected Player owner;

    // To create a basic card with no attacks (they'll be created for each monster directly)
    public MonsterCard(String name, int maxHP, Element weakness, int retreatCost, int rarity, Player owner){
        super(name);
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.weakness = weakness;
        this.retreatCost = new ArrayList<Element>(Collections.nCopies(retreatCost,Element.Elementless)) ;
        this.rarity = rarity;
        this.tokens = new ArrayList<Token>();
        this.owner = owner;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public Element getWeakness() {
        return weakness;
    }
    
    public ArrayList<Element> getRetreatCost(){
        return retreatCost;
    }

    public int getRarity(){
        return rarity;
    }

    // Setters
    public void setHP(int HP) {
        this.HP = HP;
    }

    /*
    METHODS FOR ALL MONSTERS
    */

    // loseHP --> when a Monster takes damage
    public int loseHP(int damageReceived, Element element) {
        if(this.weakness == element){
            damageReceived+=20;
        }
        HP -=damageReceived;
        return damageReceived;
    }

    // recoverHP --> when a Monster heals himself or use an object to heal
    public int recoverHP(int HPReceived){
        HP += HPReceived;
        return HPReceived;
    }

    // retreatCostCalcul --> if the retreatCost changes due to some affliction
    public int retreatCostCalcul(int retreatCost){
        int realRetreatCost = retreatCost;
        if(tokens.contains(Token.Iceblight)){
            realRetreatCost +=1;
        }
        return realRetreatCost;
    }

    public void retreat(int to){
        owner.useManaElement(retreatCost);
        owner.moveCardOnBoard(0, to);
    }



    // AddToken --> used to add tokens of affliction to a Monster
    public void AddToken(Token token){
        tokens.add(token);
    }
    public void AddToken(Token token, int number){
        for (int i = 0; i < number; i++){
            AddToken(token);
        }
    }

    //
    protected ArrayList<Element> ALBuilder(int fire, int water, int ice, int thunder, int dragon, int elementless){
        ArrayList<Element> list = new ArrayList<>();
        for (int i = 0; i < fire; i++){
            list.add(Element.Fire);
        }
        for (int i = 0; i < water; i++){
            list.add(Element.Water);
        }
        for (int i = 0; i < ice; i++){
            list.add(Element.Ice);
        }
        for (int i = 0; i < thunder; i++){
            list.add(Element.Thunder);
        }
        for (int i = 0; i < dragon; i++){
            list.add(Element.Dragon);
        }
        for (int i = 0; i < fire; i++){
            list.add(Element.Elementless);
        }
        return list;
    }
}

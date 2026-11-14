package Classes;

import Classes.Enum.Element;
import Classes.Enum.Token;
import java.util.ArrayList;

abstract class MonsterCard {
    protected String name;
    protected int HP;
    protected int maxHP;
    protected Element weakness;
    protected int retreatCost;
    protected int rarity;
    protected ArrayList<Token> tokens;

    // To create a basic card with no attacks (they'll be created for each monster directly)
    public MonsterCard(String name, int maxHP, Element weakness, int retreatCost, int rarity){
        this.name = name;
        this.HP = maxHP;
        this.maxHP = maxHP;
        this.weakness = weakness;
        this.retreatCost = retreatCost ;
        this.rarity = rarity;
        this.tokens = new ArrayList<Token>();
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
    
    public int getRetreatCost(){
        return retreatCost;
    }

    public int getRarity(){
        return rarity;
    }

    // Setters
    public void setHP(int HP) {
        this.HP = HP;
    }
    protected void setWeakness(Element weakness){
        this.weakness = weakness;
    }

    protected void setRetreatCost(int retreatCost){
        this.retreatCost = retreatCost;
    }

    protected void setRarity(int rarity){
        this.rarity = rarity;
    }



    /*
    Methods for all Monsters
      I. loseHP
      II. recoverHP
      III. monsterRetreat
      IV. blight --> affected by something (poison, fire etc)

    */

    public int loseHP(int damageReceived, Element element) {
        if(this.weakness == element){
            damageReceived+=20;
        }
        HP -=damageReceived;
        return damageReceived;
    }

    public int recoverHP(int HPReceived){
        HP += HPReceived;
        return HPReceived;
    }

    public int retreatCostCalcul(int retreatCost){
        int realRetreatCost = retreatCost;
        if(tokens.contains(Token.Iceblight)){
            realRetreatCost +=1;
        }
        return realRetreatCost;
    }

    public void AddToken(Token token){
        tokens.add(token);
    }
    public void AddToken(Token token, int number){
        for (int i = 0; i < number; i++){
            AddToken(token);
        }
    }

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

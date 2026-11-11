package Classes;

abstract class MonsterCard {
    private int ID;
    protected String name;
    protected int HP;
    protected String weakness;
    protected int retreatCost;
    protected int rarity;

    // To create a basic card with no attacks (they'll be created for each monster directly)
    public MonsterCard(String name, int HP, String weakness, int retreatCost, int rarity){
        this.name = name;
        this.HP = HP;
        this.weakness = weakness ;
        this.retreatCost = retreatCost ;
        this.rarity = rarity;
        //à modifier pour que l'id soit différent si on a 2 fois le même type de carte
        ID = 0;
    }

    // Getters
    protected int getID(){
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public String getWeakness() {
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
    protected void setWeakness(String weakness){
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
      III. afflicted --> affected by something (poison, fire etc)

    */

    public int loseHP(int damageReceived) {
        int health = getHP();
        health = health - damageReceived;
        setHP(health);
        return HP;
    }

    public int recoverHP(int HPReceived){
        int health = getHP();
        health = health + HPReceived;
        setHP(health);
        return HP;
    }

}

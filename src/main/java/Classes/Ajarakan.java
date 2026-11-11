package Classes;

import Interfaces.BasicAttack;

public class Ajarakan extends MonsterCard implements BasicAttack {
    private static int firstAttackDamage = 30;
    private static int secondAttackDamage = 40;
    private static int thirdAttackDamage = 80;

    public Ajarakan(String name, int HP, String weakness, int retreatCost, int rarity) {
        super(name, HP, weakness, retreatCost, rarity);
    }

    @Override
    public int basicAttack(){
        System.out.println("Ajarakan uses Power Punch!");
        // Ajouter damage fait à l'ennemi
        System.out.println("It deals 30 damage to the opponent's Monster!");
    }
}

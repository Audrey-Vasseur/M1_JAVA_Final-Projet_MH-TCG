package Classes.Monsters;

import Classes.Enum.Element;
import Classes.Enum.Token;

import java.util.ArrayList;

import Classes.MonsterCard;
import Classes.Player;

public class Aknosom extends MonsterCard {
    public Aknosom(Player owner) {
        super("Aknosom", owner);
    }

    public int Attack1(MonsterCard enemy){
        ArrayList<String> attack = moves.get(0);
        String attackName =  attack.get(0);
        int attackDamage =  Integer.parseInt(attack.get(1));
        ArrayList<Element> cost = buildFromList(attack);
        Element elementType = defineAttackElementType(cost);

        if(owner.useManaElement(cost)) {
            System.out.println(attackToString(attackName, cost, attackDamage, elementType, enemy));
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return 0;
        }
    }

    public int Attack2(MonsterCard enemy){
        ArrayList<String> attack = moves.get(1);
        String attackName =  attack.get(0);
        int attackDamage =  Integer.parseInt(attack.get(1));
        ArrayList<Element> cost = buildFromList(attack);
        Element elementType = defineAttackElementType(cost);

        if(owner.useManaElement(cost)) {
            System.out.println(attackToString(attackName, cost, attackDamage, elementType, enemy));
            enemy.AddToken(Token.Fireblight);
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return 0;
        }
    }
}

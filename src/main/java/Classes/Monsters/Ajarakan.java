package Classes.Monsters;

import Classes.Enum.Element;

import java.util.ArrayList;

import Classes.Enum.Token;
import Classes.MonsterCard;
import Classes.Player;

public class Ajarakan extends MonsterCard {

    public Ajarakan(Player owner) {
        super("Ajarakan", owner);
    }

    // 1st attack: Power Punch
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

    // 2nd attack: Shoulder Ram --> apply 1 Blastblight Token
    public int Attack2(MonsterCard enemy){
        ArrayList<String> attack = moves.get(1);
        String attackName =  attack.get(0);
        int attackDamage =  Integer.parseInt(attack.get(1));
        ArrayList<Element> cost = buildFromList(attack);
        Element elementType = defineAttackElementType(cost);

        if(owner.useManaElement(cost)) {
            System.out.println(attackToString(attackName, cost, attackDamage, elementType, enemy));
            enemy.AddToken(Token.Blastblight);
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return 0;
        }
    }

    // 3rd attack: Blasting Star --> apply 2 Blastblight Token
    public int Attack3(MonsterCard enemy){
        ArrayList<String> attack = moves.get(2);
        String attackName =  attack.get(0);
        int attackDamage =  Integer.parseInt(attack.get(1));
        ArrayList<Element> cost = buildFromList(attack);
        Element elementType = defineAttackElementType(cost);

        if(owner.useManaElement(cost)) {
            System.out.println(attackToString(attackName, cost, attackDamage, elementType, enemy));
            enemy.AddToken(Token.Blastblight);
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return 0;
        }
    }
}

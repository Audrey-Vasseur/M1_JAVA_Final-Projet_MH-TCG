package Classes.Monsters;

import Classes.Enum.Element;
import Classes.Enum.Token;

import java.util.ArrayList;

import Classes.MonsterCard;
import Classes.Player;

public class JinDahaad extends MonsterCard {
    public JinDahaad(Player owner) {
        super("Jin Dahaad", owner);
    }

    public int Attack1(MonsterCard enemy){
        ArrayList<String> attack = moves.get(0);
        String attackName =  attack.get(0);
        int attackDamage =  Integer.parseInt(attack.get(1));
        ArrayList<Element> cost = buildFromList(attack);
        Element elementType = defineAttackElementType(cost);

        if(owner.useManaElement(cost)) {
            System.out.println(attackToString(attackName, cost, attackDamage, elementType, enemy));
            enemy.AddToken(Token.Iceblight);
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return -1;
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
            enemy.AddToken(Token.KO);
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return -1;
        }
    }

    public int Attack3(MonsterCard enemy){
        ArrayList<String> attack = moves.get(2);
        String attackName =  attack.get(0);
        int attackDamage =  Integer.parseInt(attack.get(1));
        ArrayList<Element> cost = buildFromList(attack);
        Element elementType = defineAttackElementType(cost);

        if(owner.useManaElement(cost)) {
            System.out.println(attackToString(attackName, cost, attackDamage, elementType, enemy));
            enemy.AddToken(Token.Iceblight);
            return enemy.loseHP(attackDamage, elementType);
        }else{
            System.out.println("You don't have enough Elements to use "+attackName+"!");
            return -1;
        }
    }
}

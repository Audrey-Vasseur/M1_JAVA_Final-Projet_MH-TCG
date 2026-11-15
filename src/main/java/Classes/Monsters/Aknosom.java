package Classes.Monsters;

import Classes.Enum.Element;
import Classes.Enum.Token;
import Classes.MonsterCard;
import Classes.Player;

public class Aknosom extends MonsterCard {
    private static final int firstAttackDamage = 20;
    private static final int secondAttackDamage = 30;

    public Aknosom(Player owner) {
        super("Aknosom", owner);
    }

    // 1st attack: Backward Kick
    public int backwardKick(MonsterCard enemy){
        System.out.println("Aknosom uses Backward Kick!");
        System.out.println("It deals "+firstAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(Element.Elementless);
        return enemy.loseHP(firstAttackDamage, Element.Elementless);
    }

    // 2nd attack: Fire Ball
    public int fireBall(MonsterCard enemy){
        System.out.println("Aknosom uses Fire Ball!");
        System.out.println("It deals "+secondAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(2,0,0,0,0,0));
        enemy.AddToken(Token.Fireblight);
        return enemy.loseHP(secondAttackDamage, Element.Fire);
    }
}

package Classes;

import Classes.Enum.Element;
import Classes.Enum.Token;

import java.util.ArrayList;

public class Ajarakan extends MonsterCard {
    private static final int firstAttackDamage = 30;
    private static final int secondAttackDamage = 40;
    private static final int thirdAttackDamage = 80;
    private Player owner;

    public Ajarakan() {
        super("Ajarakan", 90, Element.Water, 2, 1);
    }

    // 1st attack: Power Punch
    public int PowerPunch(MonsterCard enemy){
        System.out.println("Ajarakan uses Power Punch!");
        System.out.println("It deals "+firstAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(Element.Elementless);
        return enemy.loseHP(firstAttackDamage, Element.Elementless);
    }

    // 2nd attack: Shoulder Ram --> apply 1 Blastblight Token
    public int ShoulderRam(MonsterCard enemy){
        System.out.println("Ajarakan uses Shoulder Ram!");
        System.out.println("It deals "+secondAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(2,0,0,0,0,1));
        enemy.AddToken(Token.Blastblight);
        return enemy.loseHP(secondAttackDamage, Element.Fire);
    }

    // 3rd attack: Blasting Star --> apply 2 Blastblight Token
    public int BlastingStar(MonsterCard enemy){
        System.out.println("Ajarakan uses Blasting Star!");
        System.out.println("It deals "+thirdAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(2,0,0,0,0,2));
        enemy.AddToken(Token.Blastblight);
        return enemy.loseHP(thirdAttackDamage, Element.Fire);
    }
}

package Classes.Monsters;

import Classes.Enum.Element;
import Classes.Enum.Token;
import Classes.MonsterCard;
import Classes.Player;

public class Barioth extends MonsterCard {
    private static final int firstAttackDamage = 20;
    private static final int secondAttackDamage = 40;
    private static final int thirdAttackDamage = 50;

    public Barioth(Player owner) {
        super("Barioth", 2, 1, owner);
    }

    // 1st attack: Lunging Bite
    public int lungingBite(MonsterCard enemy){
        System.out.println("Barioth uses Lunging Bite!");
        System.out.println("It deals "+firstAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(Element.Elementless);
        return enemy.loseHP(firstAttackDamage, Element.Elementless);
    }

    // 2nd attack: Tail Sweep
    public int tailSweep(MonsterCard enemy){
        System.out.println("Barioth uses Tail Sweep!");
        System.out.println("It deals "+secondAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(0,0,0,0,0,2));
        return enemy.loseHP(secondAttackDamage, Element.Elementless);
    }

    // 3rd attack: Ice Tornado --> apply 1 Iceblight Token
    public int iceTornado(MonsterCard enemy){
        System.out.println("Barioth uses Ice Tornado!");
        System.out.println("It deals "+thirdAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(0,0,3,0,0,0));
        enemy.AddToken(Token.Iceblight);
        return enemy.loseHP(thirdAttackDamage, Element.Ice);
    }
}

package Classes.Monsters;

import Classes.Enum.Element;
import Classes.Enum.Token;
import Classes.MonsterCard;
import Classes.Player;

public class JinDahaad extends MonsterCard {
    private static final int firstAttackDamage = 40;
    private static final int secondAttackDamage = 50;
    private static final int thirdAttackDamage = 100;

    public JinDahaad(Player owner) {
        super("Jin Dahaad", 110, Element.Ice, 3, 1, owner);
    }

    // 1st attack: Sweeping Breath
    public int sweepingBreath(MonsterCard enemy){
        System.out.println("Jin Dahaad uses Sweeping Breath!");
        System.out.println("It deals "+firstAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(0,0,0,2,0,0));
        enemy.AddToken(Token.Iceblight);
        return enemy.loseHP(firstAttackDamage, Element.Ice);
    }

    // 2nd attack: Body Slam
    public int bodySlam(MonsterCard enemy){
        System.out.println("Jin Dahaad uses Body Slam!");
        System.out.println("It deals "+secondAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(0,0,0,0,0,3));
        enemy.AddToken(Token.KO);
        return enemy.loseHP(secondAttackDamage, Element.Elementless);
    }

    // 3rd attack: 
    public int iceNova(MonsterCard enemy){
        System.out.println("Jin Dahaad uses Ice Nova!");
        System.out.println("It deals "+thirdAttackDamage+" damage to the opponent's Monster!");
        owner.useManaElement(ALBuilder(0,0,0,5,0,0));
        enemy.AddToken(Token.Iceblight);
        return enemy.loseHP(thirdAttackDamage, Element.Ice);
    }
}

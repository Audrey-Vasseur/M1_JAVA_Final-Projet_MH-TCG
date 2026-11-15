package Classes.Monsters;

import Classes.Enum.Element;
import Classes.Enum.Token;
import Classes.MonsterCard;
import Classes.Player;

public class Ajarakan extends MonsterCard {
    private static final int firstAttackDamage = 30;
    private static final int secondAttackDamage = 40;
    private static final int thirdAttackDamage = 80;

    public Ajarakan(Player owner) {
        super("Ajarakan", owner);
    }

    // 1st attack: Power Punch
    public int PowerPunch(MonsterCard enemy){
        if(owner.useManaElement(Element.Elementless)) {
            System.out.println("Ajarakan uses Power Punch!");
            System.out.println("It deals " + firstAttackDamage + " damage to the opponent's Monster!");
            return enemy.loseHP(firstAttackDamage, Element.Elementless);
        }else{
            System.out.println("You don't have enough Elements to use Power Punch!");
            return 0;
        }
    }

    // 2nd attack: Shoulder Ram --> apply 1 Blastblight Token
    public int ShoulderRam(MonsterCard enemy){
        if(owner.useManaElement(ALBuilder(2,0,0,0,0,1))) {
            System.out.println("Ajarakan uses Shoulder Ram!");
            System.out.println("It deals " + secondAttackDamage + " damage to the opponent's Monster!");
            enemy.AddToken(Token.Blastblight);
            return enemy.loseHP(secondAttackDamage, Element.Fire);
        }else{
            System.out.println("You don't have enough Elements to use Shoulder Ram!");
            return 0;
        }
    }

    // 3rd attack: Blasting Star --> apply 2 Blastblight Token
    public int BlastingStar(MonsterCard enemy){
        if(owner.useManaElement(ALBuilder(2,0,0,0,0,2))) {
            System.out.println("Ajarakan uses Blasting Star!");
            System.out.println("It deals " + thirdAttackDamage + " damage to the opponent's Monster!");
            enemy.AddToken(Token.Blastblight);
            return enemy.loseHP(thirdAttackDamage, Element.Fire);
        }else{
            System.out.println("You don't have enough Elements to use Blasting Star!");
            return 0;
        }
    }
}

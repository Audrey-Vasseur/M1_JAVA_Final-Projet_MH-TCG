package Classes.Items;

import Classes.ItemCard;
import Classes.MonsterCard;
import Classes.Player;

public class Potion extends ItemCard{

    public Potion(Player player) {
        super("Potion", player);
    }

    @Override
    public boolean use(int spot){
        MonsterCard ms = (MonsterCard) (owner.getBoard().get(spot));
        if(ms.equals(owner.getActiveMonster())){
            return false;
        }
        System.out.println(owner.getName() + "'s " + ms.getName() + " recovers 20HP!");
        ms.recoverHP(20);
        return true;
    }
    @Override
    public String toString() {
        return "Potion : Heal one of your Benched Monster for 20hp\n";
    }
}

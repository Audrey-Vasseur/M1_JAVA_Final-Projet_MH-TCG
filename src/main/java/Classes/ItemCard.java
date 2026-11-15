package Classes;

// items are in the deck
public abstract class ItemCard extends Card{
    protected Player owner;
    public ItemCard(String name, Player owner) {
        super(name);
        this.owner = owner;
    }
    protected boolean use(int spot){
        return false;
    }
}

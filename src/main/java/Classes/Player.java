package Classes;

import Classes.Enum.Element;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    protected String name;
    protected ArrayList<Card> deck;
    protected ArrayList<Consumable> consumables;
    protected ArrayList<Card> hand;
    protected ArrayList<Card> board;
    protected ArrayList<Card> cemetery;
    protected int points;
    protected ArrayList<Element> manaPool;
    protected ArrayList<Element> manaTypes;

    public Player(String name, ArrayList<Card> deck, ArrayList<Consumable> consumables, ArrayList<Element> manaTypes) {
        this.name = name;
        this.deck = deck;
        this.consumables = consumables;
        this.points = 0;
        this.manaPool = new ArrayList<>();
        this.manaTypes = manaTypes;
        this.hand = new ArrayList<>();
        this.board = new ArrayList<>(Collections.nCopies(4,null));
        this.cemetery = new ArrayList<>();
    }
    public Player(String name){
        this(name, new ArrayList<Card>(), new ArrayList<Consumable>(), new ArrayList<Element>());
    }

    public String getName() {
        return name;
    }
    public MonsterCard getActiveMonster(){
        return (MonsterCard) board.get(0);
    }
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getBoard() {
        return board;
    }

    public ArrayList<Card> getCemetery() {
        return cemetery;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Consumable> getConsumables() {
        return consumables;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Element> getManaPool() {
        return manaPool;
    }

    public ArrayList<Element> getManaTypes() {
        return manaTypes;
    }

    public void addToDeck(Card card){
        deck.add(card);
    }
    public void addMana(Element element){
        manaPool.add(element);
    }
    public void addMana(ArrayList<Element> elements){
        manaPool.addAll(elements);
    }

    public boolean hasManaElement(Element element){
        return manaPool.contains(element);
    }
    public boolean hasManaElement(ArrayList<Element> elements){

        if(Collections.frequency(manaPool,Element.Fire) < Collections.frequency(elements,Element.Fire)){
            return false;
        }
        if(Collections.frequency(manaPool,Element.Ice) < Collections.frequency(elements,Element.Ice)){
            return false;
        }
        if(Collections.frequency(manaPool,Element.Thunder) < Collections.frequency(elements,Element.Thunder)){
            return false;
        }
        if(Collections.frequency(manaPool,Element.Water) < Collections.frequency(elements,Element.Water)){
            return false;
        }
        if(Collections.frequency(manaPool,Element.Dragon) < Collections.frequency(elements,Element.Dragon)){
            return false;
        }
        ArrayList<Element> manaPoolCopy = manaPool;
        ArrayList<Element> elementsCopy = elements;
        elementsCopy.removeIf(element -> element == Element.Elementless);
        useManaElement(manaPoolCopy,elementsCopy);
        if(manaPoolCopy.size() < Collections.frequency(elements,Element.Elementless)){
            return false;
        }
        return true;
    }

    public boolean useManaElement(Element element){
        if(element != Element.Elementless){
            return manaPool.remove(element);
        } else{
            if(!manaPool.isEmpty()) {
                manaPool.removeFirst();
                return true;
            }else {
                return false;
            }
        }
    }
    public boolean useManaElement(ArrayList<Element> manaPool, ArrayList<Element> elements){
        for (Element element : elements){
            boolean success = useManaElement(element);
            if(!success){
                return false;
            }
        }
        return true;
    }
    public boolean useManaElement(ArrayList<Element> elements){
        return useManaElement(manaPool, elements);
    }


    public void addPoint(int point){
        this.points += point;
        System.out.println("You gained "+ point + " point!");
    }

    public static boolean somebodyHasWon(ArrayList<Player> players){
        return players.getFirst().getPoints() >= 4 || players.getLast().getPoints() >= 4;
    }

    // Move a card from hand to board
    public boolean handToBoard(int index){
        return board.add(hand.remove(index));
    }

    // Move cards on the board
    public void moveCardOnBoard(int from, int to){
        Collections.swap(board, from, to);
    }

    // Draw a card from the deck
    public void drawCard(){
        if(!deck.isEmpty()) {
            Card drawnCard = deck.removeFirst();
            hand.add(drawnCard);
            System.out.println("You draw: "+ drawnCard.getClass().getName());
        }
    }

    // Draw MonsterCard
    public void drawMonster(){
        if(!deck.isEmpty()) {
            for(int i = 0; i < deck.size(); i++){
                if(deck.get(i) instanceof MonsterCard){
                    hand.add(deck.remove(i));
                    break;
                }
            }
            shuffleDeck();
        }
    }

    // InitialDraw: give 5 cards from the deck to the player's hand with a guaranteed Monster
    public void initialD(){
        for(int i = 0; i < 4 ;i++){
           drawCard();
        }
        if(hand.stream().anyMatch(obj -> obj instanceof MonsterCard)){
            drawCard();
        }else{
            drawMonster();
            Collections.shuffle(hand);
        }
    }

    // shuffle the deck
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    // Bury a Card (cemetery)
    public void sendToCemetery(Card card){
        hand.remove(card);
        board.remove(card);
        cemetery.add(card);
        System.out.println("Your card was sent to the Cemetery!");
    }

    public String CardtoString(ArrayList<Card> list){
        String strBuilder = "";
        for (int i = 0; i < list.size();i++){
            strBuilder+= list.get(i).name + ", ";
        }
        return strBuilder;
    }
    public String ElementtoString(ArrayList<Element> list){
        String strBuilder = "";
        for (int i = 0; i < list.size();i++){
            strBuilder+= list.get(i).toString() + ", ";
        }
        return strBuilder;
    }
}

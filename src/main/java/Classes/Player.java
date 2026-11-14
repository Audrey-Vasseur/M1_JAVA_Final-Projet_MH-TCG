package Classes;

import Classes.Enum.Element;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    protected String name;
    protected ArrayList<MonsterCard> deck;
    protected ArrayList<ObjectCard> objects;
    protected int points;
    protected ArrayList<Element> manaPool;

    public Player(String name, ArrayList<MonsterCard> deck, ArrayList<ObjectCard> objects) {
        this.name = name;
        this.deck = deck;
        this.objects = objects;
        this.points = 0;
        this.manaPool = new ArrayList<>();
    }
    Player(String name){
        this(name, new ArrayList<MonsterCard>(), new ArrayList<ObjectCard>());
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

    public void useManaElement(Element element){
        if(element != Element.Elementless){
            manaPool.remove(element);
        } else{
            manaPool.removeFirst();
        }
    }
    public void useManaElement(ArrayList<Element> manaPool, ArrayList<Element> elements){
        for (Element element : elements){
            useManaElement(element);
        }
    }
    public void useManaElement(ArrayList<Element> elements){
        useManaElement(manaPool, elements);
    }


    public void addPoint(int point){
        this.points += point;
    }
}

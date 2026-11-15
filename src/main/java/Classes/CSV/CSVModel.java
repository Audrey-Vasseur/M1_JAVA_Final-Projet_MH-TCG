package Classes.CSV;

import Classes.Enum.Element;
import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.util.ArrayList;

public class CSVModel {
    @CsvBindByName(column = "subname")
    protected String subname;

    @CsvBindByName(column = "name", required = true)
    protected String name;

    @CsvBindByName(column = "healthpoints", required = true)
    protected int healthpoints;

    @CsvBindAndSplitByName(column = "weakness", elementType = String.class, collectionType = ArrayList.class, splitOn = "\\s*/\\s*")
    protected ArrayList<Element> weakness;

    @CsvBindByName(column = "retreatCost", required = true)
    protected int retreatCost;

    @CsvBindByName(column = "rarity", required = true)
    protected String rarity;

    @CsvCustomBindByName(column = "moves", converter = CSVMovesConverter.class)
    protected ArrayList<ArrayList<String>> moves;

    public CSVModel() {
    }

    public CSVModel(String subname, String name, int healthpoints, ArrayList<Element> weakness, int retreatCost, String rarity, ArrayList<ArrayList<String>> moves) {
        this.subname = subname;
        this.name = name;
        this.healthpoints = healthpoints;
        this.weakness = weakness;
        this.retreatCost = retreatCost;
        this.rarity = rarity;
        this.moves = moves;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    public ArrayList<Element> getWeakness() {
        return weakness;
    }

    public void setWeakness(ArrayList<Element> weakness) {
        this.weakness = weakness;
    }

    public int getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(int retreatCost) {
        this.retreatCost = retreatCost;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public ArrayList<ArrayList<String>> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<ArrayList<String>> moves) {
        this.moves = moves;
    }
}

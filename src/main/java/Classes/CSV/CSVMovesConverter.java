package Classes.CSV;

import com.opencsv.bean.AbstractBeanField;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVMovesConverter extends AbstractBeanField<ArrayList<ArrayList<String>>, String> {

    public CSVMovesConverter() {
    }

    @Override
    protected Object convert(String value){
        //System.out.println("Valeur reçue");

        ArrayList<ArrayList<String>> movesList = new ArrayList<>();
        if(value == null || value.trim().isEmpty()){
            return movesList;
        }
        String[] rawMoves = value.split("/");

        for(String rawMove : rawMoves){
            String[] moveParts = rawMove.trim().split("\\s+");
            ArrayList<String> singleMoveInfo = new ArrayList<>(Arrays.asList(moveParts));
            movesList.add(singleMoveInfo);
        }
        return movesList;
    }
}

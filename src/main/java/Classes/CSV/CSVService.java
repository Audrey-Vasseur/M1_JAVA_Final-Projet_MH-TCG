package Classes.CSV;

import Classes.Enum.Element;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class CSVService {
    private static final String filePath = "src/main/resources/csv/cards_output.csv";

    public CSVService(){
    }

    private static ArrayList<CSVModel> allCardsCache = new ArrayList<>();

    public static void initialize() throws CSVReadException {
        allCardsCache = loadCards(filePath);
    }

    public static CSVModel getCardByName(String name){
        for(CSVModel card: allCardsCache){
            if(card.getName().equalsIgnoreCase(name)) return card;
        }
        return null;
    }

    public static ArrayList<CSVModel> loadCards(String filePath) throws CSVReadException {
        ArrayList<CSVModel> list = new ArrayList<>();

        try (FileReader fileReader = new FileReader(filePath); CSVReader csvReader = new CSVReader(fileReader)) {
            csvReader.readNext();  // 1st line are only the attributes'names

            String[] line;
            while((line = csvReader.readNext()) != null){
                if(line.length < 2 || line[1].trim().isEmpty()){
                    continue;
                }
                CSVModel model = new CSVModel();
                model.setName(line[1]);
                model.setHealthpoints(Integer.parseInt(line[2]));

                // For the weakness(es)
                String weaknessPlace = line[3];
                ArrayList<Element> weaknessList = new ArrayList<>();
                if(!weaknessPlace.isEmpty()) {
                    String[] weaknessSplit = weaknessPlace.split("/");
                    for (String s : weaknessSplit) {
                        Element elementEnum = Element.valueOf(s.trim());
                        weaknessList.add(elementEnum);
                    }
                }
                model.setWeakness(weaknessList);
                list.add(model);
            }
            return list;
        } catch (Exception e) {
            throw new CSVReadException("Error while reading the csv file: " + filePath, e);
        }
    }
}

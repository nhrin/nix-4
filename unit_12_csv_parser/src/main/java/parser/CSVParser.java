package parser;

import com.opencsv.CSVReader;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Getter
public class CSVParser {

    private List<String[]> inputData = parser();
    private List<String> titles = initialTitles();



    public String getField(int rowNumber, int columnNumber) {
        try {
            return inputData.get(rowNumber)[columnNumber-1];
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Wrong field address");
        }
    }

    public String getField(int rowNumber, String columnName) {
        if (titles.contains(columnName)) {
           try {
               return inputData.get(rowNumber)[titles.indexOf(columnName)];
           } catch (IndexOutOfBoundsException e) {
               throw new RuntimeException("Wrong number of row");
           }
        } else throw new RuntimeException("Wrong name of column");
    }


    @SneakyThrows
    private List<String[]> parser() {
        List<String[]> r;
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/input.csv"))) {
            r = reader.readAll();

        } catch (IOException e) {
            throw new RuntimeException("Error! Check path to input data.");
        }
        return r;
    }

    private List<String> initialTitles() {
        List<String> list = new ArrayList<>();
        for (String s : inputData.get(0)) {
            list.add(s);
        }
        return list;
    }
}

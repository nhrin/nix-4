import entity.DataTest;
import mapper.SetterFieldsFromCSV;
import parser.CSVParser;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        SetterFieldsFromCSV setter = new SetterFieldsFromCSV();
        CSVParser parser = new CSVParser();

        System.out.println("Getting element by number row and number column:");
        System.out.println(parser.getField(1,3));
        System.out.println();

        System.out.println("Getting element by number row and name column:");
        System.out.println(parser.getField(1,"model"));
        System.out.println();

        System.out.println("Getting titles");
        for (String s : parser.getTitles()) {
            System.out.print(s + " ");
        }
        System.out.println();

        List<DataTest> list = setter.getObjectsFromCSV(parser, DataTest.class);
        for (DataTest dataTest : list) {
            System.out.println(dataTest);
        }
    }
}

package mapper;

import annotation.SetFromCSV;
import lombok.SneakyThrows;
import parser.CSVParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SetterFieldsFromCSV {

    public List getObjectsFromCSV (CSVParser parser, Class tClass) {
        List list = new ArrayList();
        for (int i = 1; i < parser.getInputData().size(); i++) {
            list.add(create(parser, tClass, i));
        }
        return list;
    }



    @SneakyThrows
    public <T> T create(CSVParser parser, Class<T> tClass, int temp) {
        Constructor<T> constructor = tClass.getConstructor();
        T result = constructor.newInstance();
        Field[] fields = tClass.getFields();

        for (Field field : fields) {
            SetFromCSV key = field.getAnnotation(SetFromCSV.class);
            if (key == null) continue;
            String properties = parser.getField(temp, key.value());
            if (properties == null) continue;

            Class<?> type = field.getType();
            if (type == int.class) {
                field.setInt(result, Integer.parseInt(properties));
            } else if (type == long.class) {
                field.setLong(result, Long.parseLong(properties));
            } else if (type == double.class) {
                field.setDouble(result, Double.parseDouble(properties));
            } else if (type == boolean.class) {
                field.setBoolean(result, Boolean.parseBoolean(properties));
            } else if (type == String.class) {
                field.set(result, properties);
            } else {
                throw new RuntimeException("Not supported field type");
            }
        }
        return result;
    }

}

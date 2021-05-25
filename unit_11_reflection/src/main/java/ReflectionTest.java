import lombok.SneakyThrows;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class ReflectionTest {

    public static void main(String[] args) {
        ReflectionTest readProperties = new ReflectionTest();
        AppProperties test = new AppProperties();
        readProperties.initialFieldsByProperties(test);
        System.out.println(test);
    }

    @SneakyThrows
    public void initialFieldsByProperties (Object o) {
        Properties properties = getProperties();
        Class objectClass = o.getClass();
        Field [] fields = objectClass.getFields();
        for (Field field : fields) {
            if (field.getAnnotation(PropertyKey.class) != null) {
                field.set(o, Integer.parseInt(properties.getProperty(field.getAnnotation(PropertyKey.class).value())));
            }
        }
    }

    @SneakyThrows
    private static Properties getProperties () {
    Properties properties = new Properties();
        try(InputStream inputStream = ReflectionTest.class.getResourceAsStream("app.properties")) {
           properties.load(inputStream);
        }
        return properties;
    }
}

package alevel;

import alevel.entity.*;
import alevel.repository.*;
import alevel.util.ShowInfo;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public class Application {

    @SneakyThrows
    public static void main(String[] args) {

        CreatingAndFillDB.createDB();

        ShowInfo.getNextLesson(8L, Instant.now()); // for example
        ShowInfo.bestGroup(1L); // for example

    }
}



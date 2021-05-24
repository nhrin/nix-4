import dao.Dao;
import lombok.SneakyThrows;
import models.Location;

import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.addSolution();

    }
}

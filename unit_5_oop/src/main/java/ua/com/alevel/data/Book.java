package ua.com.alevel.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Book extends AbstractData {
    private String name;
    private List<Integer> authorsId;

    @Override
    public String toString() {
        return "ID - " + getId() + " - " + name;
    }
}

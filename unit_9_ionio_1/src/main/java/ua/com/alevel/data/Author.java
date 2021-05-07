package ua.com.alevel.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class Author extends AbstractData {
    private String name;
    private String familyName;

    @Override
    public String toString() {
        return  "ID " + getId() + " - " + name + " " + familyName;
    }

}

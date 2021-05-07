package ua.com.alevel.data;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends AbstractData {
    private String name;
    private List<Integer> authorsId;



    @Override
    public String toString() {
        return "ID - " + getId() + " - " + name;
    }
}

package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Route {
    Integer id;
    Integer idFrom;
    Integer idTo;
    Integer cost;
}

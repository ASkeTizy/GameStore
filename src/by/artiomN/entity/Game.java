package by.artiomN.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private Long id;
    private String name;
    private String genre;
    private String companyName;


    public Game(String name, String genre, String companyName) {
        this.name = name;
        this.genre = genre;
        this.companyName = companyName;
    }
}

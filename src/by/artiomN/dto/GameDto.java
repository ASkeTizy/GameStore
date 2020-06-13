package by.artiomN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GameDto {
    private Long id;
    private String name;
    private String genre;
    private String companyName;
}
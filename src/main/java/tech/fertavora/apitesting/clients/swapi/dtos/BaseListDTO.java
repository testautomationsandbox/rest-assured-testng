package tech.fertavora.apitesting.clients.swapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseListDTO {
    private int count;
    private String next;
    private String previous;
}

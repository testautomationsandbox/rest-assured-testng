package tech.fertavora.apitesting.clients.swapi.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class PeopleListDTO extends BaseListDTO {
    private List<PeopleDTO> results;
}

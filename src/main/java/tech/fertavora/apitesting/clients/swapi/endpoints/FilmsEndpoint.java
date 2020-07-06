package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class FilmsEndpoint extends SwapiService {

    protected static RequestSpecification filmsEndpoint = setEndpoint("/films", swapiServiceBaseSpec);

    /**
     * A Request to /films to find a film by Id as path param
     * @param filmId The id of the film to find
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getFilmById(Integer filmId) {
        Map<String, Integer> pathParamsMap = new HashMap<>();
        pathParamsMap.put("filmId", filmId);

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(filmsEndpoint);
        customRequest = new RequestSpecBuilder()
                .addRequestSpecification(filmsEndpoint)
                .addPathParams(pathParamsMap)
                .setBasePath(queryRequest.getBasePath() + "/{filmId}")
                .build();
        return getRequest(customRequest);
    }

    /**
     * A Request to /films that returns all the films
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getFilms() {
        customRequest = filmsEndpoint;
        return getRequest(filmsEndpoint);
    }
}

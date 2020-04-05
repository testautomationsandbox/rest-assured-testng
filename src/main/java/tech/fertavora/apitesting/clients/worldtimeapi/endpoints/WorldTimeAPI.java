package tech.fertavora.apitesting.clients.worldtimeapi.endpoints;

import tech.fertavora.apitesting.clients.BaseService;
import io.restassured.builder.RequestSpecBuilder;

/**
 * The default setting of the Worldtime API.
 * It is extended for each class that wraps a specific endpoint.
 */
public class WorldTimeAPI extends BaseService {

    /**
     * The base path of the service defined as a
     * request specification builder to be reused.
     */
    protected static RequestSpecBuilder worldTimeApiSpec = new RequestSpecBuilder().
            setBaseUri("https://worldtimeapi.org/api/");
}

package tech.fertavora.apitesting.clients.worldtimeapi;

import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.BaseService;

/**
 * The default setting of the Worldtime API.
 * It is extended for each class that wraps a specific endpoint.
 */
public class WorldTimeAPI extends BaseService {

    protected static RequestSpecification worldtimeServiceBaseSpec = setBaseUrlSpec(System.getenv("WORLDTIME_BASE_URL"));

}

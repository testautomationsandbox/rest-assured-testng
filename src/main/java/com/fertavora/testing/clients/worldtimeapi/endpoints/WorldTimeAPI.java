package com.fertavora.testing.clients.worldtimeapi.endpoints;

import com.fertavora.testing.clients.BaseService;
import io.restassured.builder.RequestSpecBuilder;

public class WorldTimeAPI extends BaseService {

    protected static RequestSpecBuilder worldTimeApiSpec = new RequestSpecBuilder().
            setBaseUri("https://worldtimeapi.org/api/");
}

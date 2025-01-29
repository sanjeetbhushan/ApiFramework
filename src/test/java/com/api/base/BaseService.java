package com.api.base;

import com.api.filters.LoggingFilter;
import com.api.models.request.CreateUserRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String base_url="https://petstore.swagger.io/v2";
    private RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }

    public BaseService() {
        requestSpecification= RestAssured.given().baseUri(base_url).log().all();
    }

    protected Response postRequest(Object payload, String endPoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
    }
}

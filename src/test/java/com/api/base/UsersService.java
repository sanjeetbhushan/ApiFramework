package com.api.base;

import com.api.models.request.CreateUserRequest;
import io.restassured.response.Response;

public class UsersService extends BaseService {
    private static final String basePath="/user/";

    public Response createUser(CreateUserRequest payload){
        return postRequest(payload,basePath);
    }
}

package com.api.test;

import com.api.base.BaseService;
import com.api.base.UsersService;
import com.api.models.request.CreateUserRequest;
import com.api.models.response.CreateUserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class createUserTest {
    UsersService usersService=new UsersService();
    CreateUserRequest userRequest=new CreateUserRequest("sanj","gola","singh","test@email.com","1234","123456");


    @Test
    public void createUsers(){
        Response response=usersService.createUser(userRequest);
        CreateUserResponse userResponse=response.as(CreateUserResponse.class);
        Assert.assertEquals(userResponse.getCode(),200);
        Assert.assertEquals(userResponse.getType(),"unknown");
        Assert.assertNotNull(userResponse.getMessage());
    }
}

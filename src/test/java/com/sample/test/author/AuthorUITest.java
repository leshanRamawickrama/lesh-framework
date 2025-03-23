package com.sample.test.author;

import com.sample.test.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorUITest extends BaseTest {

    @Test
    public void findAllBooks(){
        Response response = authorAPI.getAuthor();
        Assert.assertEquals(response.statusCode(),200);
    }

}

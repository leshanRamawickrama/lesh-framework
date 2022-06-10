package com.sample.test.book;

import com.sample.test.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookAPITest extends BaseTest {


    @Test
    public void createBooks(){
        Response response = booksAPI.createNewBook();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createBooksPage(){
        Response response = booksAPI.getBookPage();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void deleteBooks(){
        Response response = booksAPI.deleteBook("12");
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void getABooks(){
        Response response = booksAPI.getBookById("12");
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void findAllBooks(){
        Response response = booksAPI.getBook();
        Assert.assertEquals(response.statusCode(),200);
    }


}

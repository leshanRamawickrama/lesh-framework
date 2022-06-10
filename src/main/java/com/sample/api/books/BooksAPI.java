package com.sample.api.books;
import com.sample.api.APIBase;
import com.sample.api.RestClient;
import com.sample.utils.ProjectProperties;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class BooksAPI extends APIBase {

    private String url = ProjectProperties.getProperty("application.url");
    private String book = ProjectProperties.getProperty("book.path");
    CreateBookRequest createBookRequest = new CreateBookRequest();
    CreateBookResponse createBookResponse = new CreateBookResponse();

    String bookId;
    public Response createNewBook(){
        RestClient client = new RestClient(url,book);
        createBookRequest.setId("12");
        createBookRequest.setTitle("Sample");
        createBookRequest.setYear("2022");

        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","multipart/form-data");

        Response response = client.post(createBookRequest,headers,null);
        logger.logInfo(""+response.statusCode());
        logger.logInfo(""+response.getBody().asString());

        return response;

    }

    public Response getBookPage(){
        RestClient client = new RestClient(url,book);

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","text/html");

        Response response = client.get(null,headers,null);
        logger.logInfo(""+response.statusCode());
        logger.logInfo(""+response.getBody().asString());

        return response;

    }

    public Response deleteBook(String bookId){
        RestClient client = new RestClient(url,book+"/"+bookId+"/delete");

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","text/html");

        Response response = client.get(null,headers,null);
        logger.logInfo(""+response.statusCode());
        logger.logInfo(""+response.getBody().asString());

        return response;

    }

    public Response getBookById(String bookId){
        RestClient client = new RestClient(url,book+"/"+bookId+"/edit");

        Map<String,String> headers = new HashMap<>();
        headers.put("Accept","text/html");

        Response response = client.get(null,headers,null);
        logger.logInfo(""+response.statusCode());
        logger.logInfo(""+response.getBody().asString());

        return response;

    }

    public Response getBook() {
        RestClient client = new RestClient(url, book);

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html");

        Response response = client.get(null, headers, null);
        logger.logInfo("" + response.statusCode());
        logger.logInfo("" + response.getBody().asString());

        return response;
    }
}

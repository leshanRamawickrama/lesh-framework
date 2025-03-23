package com.sample.api.author;

import com.sample.api.APIBase;
import com.sample.api.RestClient;
import com.sample.utils.ProjectProperties;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthorAPI extends APIBase {
    private String url = ProjectProperties.getProperty("application.url");
    private String author = ProjectProperties.getProperty("author.path");

    public Response getAuthor() {
        RestClient client = new RestClient(url, author);

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "text/html");

        Response response = client.get(null, headers, null);
        logger.logInfo("" + response.statusCode());
        logger.logInfo("" + response.getBody().asString());

        return response;
    }
}

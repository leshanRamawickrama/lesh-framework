package com.sample.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestClient {


    String baseUrl ;
    String basePath ;


    public RestClient(String url, String path) {
        this.baseUrl=url;
        this.basePath=path;
    }

    public Response
    post(Object body, Map<String,String> headers,Map<String,String> queryParam){
        RequestSpecification requestSpecification = getRequestSpec(body,headers,queryParam);
        Response resp = RestAssured.given().spec(requestSpecification).when().post();

        return resp;
    }


    public Response put(Object body, Map<String,String> headers, Map<String,String> queryParam){
        RequestSpecification requestSpecification = getRequestSpec(body,headers,queryParam);
        Response resp = RestAssured.given().spec(requestSpecification).when().put();

        return resp;
    }

    public Response get(Object body, Map<String,String> headers,Map<String,String> queryParam){
        RequestSpecification requestSpecification = getRequestSpec(body,headers,queryParam);
        Response resp = RestAssured.given().spec(requestSpecification).when().get();

        return resp;
    }

    public Response delete(Object body, Map<String,String> headers,Map<String,String> queryParam){
        RequestSpecification requestSpecification = getRequestSpec(body,headers,queryParam);
        Response resp = RestAssured.given().spec(requestSpecification).when().delete();

        return resp;
    }

    public Response patch(Object body, Map<String,String> headers,Map<String,String> queryParam){
        RequestSpecification requestSpecification = getRequestSpec(body,headers,queryParam);
        Response resp = RestAssured.given().spec(requestSpecification).when().patch();

        return resp;
    }

    public static Response getData(RequestSpecification payload, String baseURI, String searchField) {
        return payload.get(baseURI + searchField);
    }

    public RequestSpecification getRequestSpec(Object body,Map<String,String> headers,Map<String,String> queryParam){
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath);

        if(body!=null){
            if(headers.get("Content-Type").equals("multipart/form-data")){
                ObjectMapper oMapper = new ObjectMapper();
                Map<String, String> formData = oMapper.convertValue(body, Map.class);
                formData.forEach((k,v) -> {
                    requestSpecBuilder.addMultiPart(k,v);
                });
            } else
                requestSpecBuilder.setBody(body);
        }

        if(headers!=null){
            for(String h:headers.keySet()){
                requestSpecBuilder.addHeader(h,headers.get(h));
            }
        }
        if(queryParam!=null){
            for(String q:queryParam.keySet()){
                requestSpecBuilder.addQueryParam(q,queryParam.get(q));
            }
        }

        return requestSpecBuilder.build();

    }






}

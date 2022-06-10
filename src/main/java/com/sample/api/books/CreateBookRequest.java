package com.sample.api.books;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {

    String id;
    String title;
    String year;
}

package com.sample.test;

import com.sample.api.author.AuthorAPI;
import com.sample.api.books.BooksAPI;
import com.sample.function.Books;
import com.sample.utils.LoggerUtil;
import com.sample.utils.TestDataGenerate;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected LoggerUtil logger = new LoggerUtil(this.getClass());
    protected TestDataGenerate testDataGenerate = new TestDataGenerate();
    public BooksAPI booksAPI = new BooksAPI();
    public AuthorAPI authorAPI = new AuthorAPI();
    public Books books = new Books();

}

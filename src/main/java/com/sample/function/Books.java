package com.sample.function;
import com.sample.page.BooksPage;

public class Books extends BaseFunction {
    //private BooksPage booksPage = new BooksPage(driver);
    //booksPage = new BooksPage(driver);

    public Books navigateToBooks (String page) {
        booksPage = new BooksPage(driver);
        booksPage.clickOnBooks(page);
        return this;
    }

    public Books createNewBook(String title, String year) {
        booksPage.createBooks(title,year);
        return this;
    }
}
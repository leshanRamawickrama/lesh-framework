package com.sample.test.book;

import com.sample.constant.TabName;
import com.sample.function.BaseFunction;
import com.sample.test.BaseTest;
import com.sample.utils.ProjectProperties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookUITest extends BaseTest {
    private String url = ProjectProperties.getProperty("application.url");
    private String bookName = testDataGenerate.readValuesFromXML("books","bookTitle");
    private String bookYear = testDataGenerate.readValuesFromXML("books","year");

    @BeforeTest
    public void launchApp (){
        new BaseFunction().openApp(url);
    }

    @Test
    public void createBooks(){
        books.navigateToBooks(TabName.BOOK.getTitle())
                .createNewBook(bookName, bookYear);
    }


    @AfterTest
    public void closeApp (){
        new BaseFunction().closeApp();
    }
}

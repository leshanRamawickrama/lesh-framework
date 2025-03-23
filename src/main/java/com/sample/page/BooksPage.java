package com.sample.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksPage extends BasePage{

    private static final String PAGELNK = "//div[@class='col-sm-3 col-md-2 sidebar']//a[text()='%s']";
    private final By createBookLnk = By.xpath("//a[text()='Create Book']");
    private final By titleText = By.xpath("//label[text()='Title']/following-sibling::input");
    private final By yearText = By.xpath("//label[text()='Year']/following-sibling::input");
    private final By saveBtn = By.xpath("//button[text()='Save']");

    public BooksPage (WebDriver driver){
        super(driver);
    }

    public BooksPage clickOnBooks (String page){
        driver.findElement(By.xpath(replaceValues(PAGELNK,page))).click();
        return this;
    }

    public BooksPage createBooks (String title, String year){
        driver.findElement(createBookLnk).click();
        driver.findElement(titleText).sendKeys(title);
        driver.findElement(yearText).sendKeys(year);
        driver.findElement(saveBtn).click();
        return this;
    }

}

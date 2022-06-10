package com.sample.page;
import com.sample.utils.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver= DriverHolder.getDriver();
    }

    public final void open (final String url) {
        if (!url.isEmpty()) {
            driver.get(url);
        }
    }

    public void init (WebDriver driver){
        this.driver = driver;
        initFindByAnnotations (this);
        init();
    }

    protected void init () {}

    protected void handleRedirect () {}

    private <E extends BasePage> void initFindByAnnotations (final E page){
        PageFactory.initElements(driver, page);
    }

    protected String replaceValues (String locator, String... values){
        return String.format(locator,values);
    }

/*    public WebElement element (final By locator){
        return new getDriver();
    }*/

    protected BasePage click (WebElement element){
        element.click();
        return null;
    }

}

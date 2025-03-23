package com.sample.function;

import com.sample.page.BasePage;
import com.sample.page.BooksPage;
import com.sample.utils.DriverHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class  BaseFunction {
    protected WebDriver driver;
    protected BooksPage booksPage;

    protected Object createChromeDriver() {
        //System.setProperty("webdriver.chrome.driver","../lesh-framework/src/main/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver;// = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications",2);
        options.setExperimentalOption("prefs",prefs);
        DriverHolder.setDriver(driver);
        return options;
    }

    public Books openApp (String url){
        createChromeDriver();
        driver.get(url);
        maximizeWindows();
        return new Books();
    }


    private void maximizeWindows(){
        DriverHolder.getDriver().manage().window().maximize();
    }

    public void closeApp (){
        DriverHolder.getDriver().quit();
    }
}

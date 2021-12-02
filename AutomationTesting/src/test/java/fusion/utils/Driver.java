package fusion.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

    //to make it singleton driver we need to have private Constructors
    //so none can create an object from class directly
    // since i made private you wont be able to create an object from here
    private Driver(){
    }

    //making private will help us to get in the getter method
    private static WebDriver driver;



    //you need a getter method to use your private singleton WebDriver
    public static WebDriver getDriver(){
        if (driver==null) {
            //since we have properties file we will get browser type from there
            String browser=ConfigurationReader.getProperties("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break; // break means if the case correct it wont check other cases
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
            }
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }
}

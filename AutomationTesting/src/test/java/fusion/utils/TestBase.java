package fusion.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {


    // no need to create a driver instance anymore
    //because we created in the driver as a singelton

    @BeforeMethod
    public void setup(){
        Driver.getDriver().manage().window().maximize();   //singelton driver in this test base
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get("https://goeasy--goeasyqasb.my.salesforce.com/");
    }

    @AfterMethod
    public void closing(){
        Driver.closeDriver();
    }



}

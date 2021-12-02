package fusion.tests;

import fusion.utils.Driver;
import org.testng.annotations.Test;

public class Login {


    @Test
    public void test(){

        Driver.getDriver().get("www.google.com");
    }
}

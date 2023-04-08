package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day20_Config_Test {

@Test
    public void firstTest(){
   // amazona git
    //Driver.getDriver().get("https://www.amazon.com");
Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));

    //title in amazon icerdiğini test edin
}


}

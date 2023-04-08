package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day24_DataProviderTest2 {

//DaATA PROVİDER METODU
    @DataProvider
    public Object[][] customerData(){
   Object[][] musteriBilgileri={
           {"sam.walker@bluerentalcars.com","c!fas_art"},
           {"kate.brown@bluerentalcars.com", "tad1$Fas"},
           {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
           {"pam.raymond@bluerentalcars.com", "Ng^g6!"}
   };
return musteriBilgileri;
}

  // TEST
    @Test(dataProvider = "customerData")
    public void dataProviderTest(String email, String password){

        System.out.println("EMAİL :" + email+ "| SIFRE : "+password);
    }

//    Bu 4 CUSTOMER DATALARI İLE LOGİN TESTİ YAPALIM
BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    @Test(dataProvider = "customerData")
    public void dataProviderLoginTest(String email, String sifre) throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage=new BlueRentalHomePage();
        blueRentalLoginPage=new BlueRentalLoginPage();
        blueRentalHomePage.loginLink.click();
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.passwordBox.sendKeys(sifre);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.loginButton.click();

        ReusableMethods.waitFor(1);
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("EkranGoruntusu");
        ReusableMethods.waitFor(1);
        blueRentalHomePage.userID.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.logOut.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.OK.click();
        Driver.closeDriver();


    }
}

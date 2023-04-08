package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_PositiveLoginTest {

/*

Name:US100201_Admin_Login
Description:
Admin bilgileriyle giriş
Acceptance Criteria:
Admin olarak uygulamaya giriş yapbilmeliyim
https://www.bluerentalcars.com/
Admin email: jack@gmail.com
Admin password:12345
 */
    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;
    @Test
    public void US100201_Admin_Login(){

        Reporter.log("SAYFAYA GİT");
    Driver.getDriver().get(ConfigReader.getProperty("app_url"));
     blueRentalLoginPage=new BlueRentalLoginPage();
     blueRentalHomePage=new BlueRentalHomePage();
Reporter.log("LOGİN BUTONUNA TIKLA");
     blueRentalHomePage.loginLink.click();
     Reporter.log("GİRİS BİLGİLERİNİ GİR");
     blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
     blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin_sifre"));
     blueRentalLoginPage.loginButton.click();
       Reporter.log("GİRİS YAPILDIGII DOĞRULA");
        Assert.assertTrue(blueRentalHomePage.userID.isDisplayed());
       Reporter.log("DRİVER KAPAT");
        Driver.closeDriver();
}
}

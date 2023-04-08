package techproed.tests.excelautomation;

import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day24_ExcelLogin2 {

    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;
    ExcelUtils excelUtils;
    List<Map<String,String>> excelDatalari;
    @Test
    public void customerLogin() throws IOException {
        String path="./src/test/java/resources/ulkeler.xlsx";
        //      ./ Önceki Tüm Dosyaları icer.Relative Path
        String sayfa="customer_info";
        //                Dataları Excel  UTİLİS METOTLARINI KULLANARAK BU SAYFA ALACAĞIZ
        excelUtils=new ExcelUtils(path,sayfa);
        //                excel datalarını getDataList metotu ile çekelim
        excelDatalari=excelUtils.getDataList();
        //               Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //home page logine tıkla
        for (Map<String,String> data : excelDatalari) {
 //                        Sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("app_url"));
            blueRentalHomePage = new BlueRentalHomePage();
            blueRentalLoginPage = new BlueRentalLoginPage();
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
//                GİRİS YAPILDI
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
        }
            Driver.closeDriver();
        }
}

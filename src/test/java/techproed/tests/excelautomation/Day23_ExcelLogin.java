package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
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

public class Day23_ExcelLogin {
   BlueRentalLoginPage blueRentalLoginPage;
   BlueRentalHomePage blueRentalHomePage;
  ExcelUtils excelUtils;
  List<Map<String,String>> excelDatalari;
    //Bu metot login sayfasına gitmek için kullanılacak

    public void login() {
        //      Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        //home page logine tıkla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        //----------------SADECE İLK GİRİS------------
        //loginlink butonu sadece ilk girişde sayfada görünür
        // ikinci ve ucuncu girişlerde sayfada görünmeyeceğinden NOSUCHELEMENTEXCEPTİON alınır
        // Biz bu exception u try catch kullanarak yakalarız ve test cases

        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
            //       LOGİN SAYFASINDAYİZ
        } catch (Exception e) {

        }

//-------------SONRAKİ GİRİSLER------
        try {
            //       Kullanici ID ye tıkla------> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            //       logout linkine tıkla------> try catch
            blueRentalHomePage.logOut.click();
            ReusableMethods.waitFor(1);
            //      OK e tıkla------> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            //      home page logine tıkla------> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        } catch (Exception e) {


        }
    }









     @Test
    public void customerLogin() throws IOException {
         String path="./src/test/java/resources/ulkeler.xlsx";
   //      ./ Önceki Tüm Dosyaları icer.Relative Path
         String sayfa="customer_info";
   //                Dataları Excel  UTİLİS METOTLARINI KULLANARAK BU SAYFA ALACAĞIZ
            excelUtils=new ExcelUtils(path,sayfa);
    //                excel datalarını getDataList metotu ile çekelim
            excelDatalari=excelUtils.getDataList();
    //               LOOP KULLANARAK DATALRI TEK TEK TEST CASEDE KULLAN
         for (Map<String,String> data : excelDatalari){
                login();//Her Loopda Login sayfasina götürecek
 //                     kullanici adını gir
            ReusableMethods.waitFor(1);
             blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
//                      kullanici sifresini gir
             ReusableMethods.waitFor(1);
             blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));

//                login buttonuna tıkla
             ReusableMethods.waitFor(1);
             blueRentalLoginPage.loginButton.click();
             ReusableMethods.waitFor(1);
  //            giris işleminin basarili olduğunu göstermek  icin assertion
             ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
             ReusableMethods.waitFor(1);
  //           Her bir girisden sonra ekran görüntüsü aldık

             ReusableMethods.getScreenshot("EkranGoruntusu");
         }
}
@AfterMethod
    public void tearDown(){
        Driver.closeDriver();
}
}
/*
------ILK GİRİS---------------
Home Pagedeyiz
home page logine tıkla ------> try catch
LOGİN PAGE DEYİZ
kullanici adını gir(excel al)
kullanici şifresini git(excelden al)
login page login buttonuna tıkla
------------2.GİRİS----------------------
HOME PAGE DEYİZ
Kullanici ID ye tıkla------> try catch
logout linkine tıkla------> try catch
OK e tıkla------> try catch
home page logine tıkla------> try catch
LOGİN PAGE DEYİZ
kullanici adını gir(excel al)
kullanici şifresini git(excelden al)
login page login buttonuna tıkla
--------------3 GIRİS--------------------
HOME PAGE DEYİZ
Kullanici ID ye tıkla
logout linkine tıkla
OK e tıkla
home page logine tıkla
LOGİN PAGE DEYİZ
kullanici adını gir(excel al)
kullanici şifresini git(excelden al)
login page login buttonuna tıkla
---------------------------------
 */
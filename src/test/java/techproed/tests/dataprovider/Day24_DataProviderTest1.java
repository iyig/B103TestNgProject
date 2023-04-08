package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day24_DataProviderTest1 {
/*
Data provider Nedir?
Veri deposudur.Bir çok veriyi Test caselere loop kullanmadan aktarmak için kullanılır
Data provider 2D(2 boyutlu) object return eder
Data provider TestNG den gelen bir özellikldir
Data provider DDT (Data driven Testing ) icin kullanilır.Birden fazla datayi test caselerde kullanmak için kullanilır
Data Provideri nasıl kullanırsin?
@DataProvider annotasyonu ile veri havuzu olusturulur.@Test metotlarına bu data havuzu dataProvider parametresi ile
bağlanır.
Data provider da 2 tane parametre vardır
name: metot ismini override etmek için yanı farklı bir isim ile data provider i cağırmak için kullanir
parallel: parallel test caseler olusturmak için kullanilir

 */
//   DATA PROVİDER
   @DataProvider
    public Object[][] urunler(){

        Object urunListesi[][]={
                {"tesla"},
                {"mercedes"},
                {"honda"},
                {"toyota"},
                {"volvo"}

        };
  return urunListesi;
    }
//   TEST METOTU
     @Test(dataProvider = "urunler")
    public void aramaTesti(String data){
    System.out.println(data);
}
//      Google Araması
    @Test(dataProvider = "urunler")
    public void googleAramasi(String araclar){
//           google git
        Driver.getDriver().get("https://www.google.com");

        //     aracları arama kutusuna gir ve Enter a bas
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar + Keys.ENTER);
//
//      sayfa title inin aradigim kelimeyi icerdigini assert et
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
        Driver.closeDriver();
    }
}

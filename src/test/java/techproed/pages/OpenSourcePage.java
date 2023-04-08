package techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

//        Page Objelerini bu sinifta buluruz

    //    1.constructor
    public OpenSourcePage(){
   //      PageFactory seleniumdan gelen ve bu sayfa elementlerini intantiate etmek için kullanilir
   //       Bu şekilde Sayfa objeleri cagrıldığında null pointer exception alınmaz
        PageFactory.initElements(Driver.getDriver(),this);
    }
//      Page OBJELERİNİ OLUSTUR
//      Geleneksel : public WebElement username=Driver.getDriver().findElement(By.name("username")) ;

    @FindBy(name="username")
    public WebElement username;

    @FindBy(xpath="//input[@name='password']")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement submitButton;
}

package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

@Test
    public void openSourceLogin() throws InterruptedException {
    //   1.Sayfaya git
  //Driver.getDriver().get(ConfigReader.getProperty("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    Driver.getDriver().get(ConfigReader.getProperty("open_soruce_url"));

    //     2.Page Objesi Olustur

    OpenSourcePage openSourcePage=new OpenSourcePage();

 //         3.Bu objeyi kullanarak o classdaki objelere ulaş

    openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
    openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
    openSourcePage.submitButton.click();

//      4.Asserttion
    OpenSourceDashboardPage openSourceDashboardPage=new OpenSourceDashboardPage();
     Thread.sleep(10);
    Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

    //5.Colse driver
    Driver.closeDriver();
}

}

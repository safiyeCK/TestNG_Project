package team02.tests.US_05;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.HomePage;
import team02.pages.RegisterPage;
import team02.pages.UserMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.Extent_Reports;
import team02.utilities.ReusableMethods;

public class TestCase_01 {

    //Kullanıcı hesap detaylarını (Account Details) görebilmeli
    @Test
    public void testCase01() {

        // Siteye git  https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Kayitli mail adresi ve sifre ile giris yap
        RegisterPage registerPage= new RegisterPage();
        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("email1SA"), Keys.TAB, ConfigReader.getProperty("password1SA"), Keys.ENTER);
        ReusableMethods.visibleWait(Driver.getDriver().findElement(By.xpath("//*[.='Sign Out']")),5 );

        //Sayfanin en altina in
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);

        //'My Account' yazisina tikla
        UserMyAccountPage myAccountPage= new UserMyAccountPage();
        myAccountPage.myAccountSA.click();

        //'My Account' sayfasinin acildigini dogrula
        Assert.assertEquals(myAccountPage.myAccountBaslikSA.getText(),"My Account");
        

    }


    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

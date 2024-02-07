package team02.tests.US_05;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.pages.UserMyAccountPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_02_13 {
    Faker faker=new Faker();
    UserMyAccountPage myAccountPage=new UserMyAccountPage();
    Actions actions=new Actions(Driver.getDriver());

    @BeforeMethod
    public void testCaseBaslangicBolumu() {
        // Siteye git  https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.bekle(2);

        //Kayitli mail adresi ve sifre ile giris yap
        RegisterPage registerPage= new RegisterPage();
        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("email1SA"), Keys.TAB, ConfigReader.getProperty("password1SA"), Keys.ENTER);
        ReusableMethods.visibleWait(Driver.getDriver().findElement(By.xpath("//*[.='Sign Out']")),5 );

        //Sayfanin en altina in
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);

        //'My Account' yazisina tikla
        myAccountPage.myAccountSA.click();

        //Acilan sayfada 'Account Details' yazisina tikla
        myAccountPage.accountDetailsSA.click();

        //'Account Details' sayfasinin acildigini dogrula
        Assert.assertTrue(myAccountPage.accountDetailsBaslikSA.isDisplayed());
    }

    @Test
    public void testCase02() {
        /*Kullanıcı 'First Name' bilgilerini değiştirebilmeli*/

        // 'First name' kutusuna yeni bir isim gir
        ReusableMethods.bekle(2);
        myAccountPage.firstNameSA.sendKeys(Keys.META,"a",Keys.DELETE);
        String firstName=faker.name().firstName();
        myAccountPage.firstNameSA.sendKeys(firstName);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        // 'Account details changed successfully.' yazisinin goruldugunu dogrula
        Assert.assertTrue(myAccountPage.changedSuccessfullMessage.isDisplayed());
        Assert.assertEquals(myAccountPage.firstNameSA.getAttribute("value"),firstName);
    }

    @Test
    public void testCase03() {
        /*Kullanıcı 'First name' text kutusunu bos birakamamali*/

        // 'First name' kutusunun icindeki yaziyi sil
        ReusableMethods.bekle(2);
        myAccountPage.firstNameSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //'FIRST NAME is a required field.' yazisinin goruldugunu dogrula
        Assert.assertEquals(myAccountPage.requiredField.getText(),"FIRST NAME is a required field.");
    }
    @Test
    public void testCase04() {
        /*Kullanıcı 'Last name' bilgilerini değiştirebilmeli*/

        // 'Last name' kutusuna yeni bir isim gir
        ReusableMethods.bekle(2);
        myAccountPage.lastNameSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        String lastName=faker.name().lastName();
        myAccountPage.lastNameSA.sendKeys(lastName);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        // 'Account details changed successfully.' yazisinin goruldugunu dogrula
        Assert.assertTrue(myAccountPage.changedSuccessfullMessage.isDisplayed());
        Assert.assertEquals(myAccountPage.lastNameSA.getAttribute("value"),lastName);
    }

    @Test
    public void testCase05() {
        /*Kullanıcı 'Last name' text kutusunu bos birakamamali*/

        // 'Last name' kutusunun icindeki yaziyi sil
        ReusableMethods.bekle(2);
        myAccountPage.lastNameSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //'LAST NAME is a required field.' yazisinin goruldugunu dogrula
        Assert.assertEquals(myAccountPage.requiredField.getText(),"LAST NAME is a required field.");
    }
    @Test
    public void testCase06() {
        /*Kullanıcı 'Display name' bilgilerini değiştirebilmeli*/

        // 'Display name' kutusuna yeni bir isim gir
        ReusableMethods.bekle(2);
        myAccountPage.displayNameSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        String username=faker.name().username();
        myAccountPage.displayNameSA.sendKeys(username);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        // 'Account details changed successfully.' yazisinin goruldugunu dogrula
        Assert.assertTrue(myAccountPage.changedSuccessfullMessage.isDisplayed());
        Assert.assertEquals(myAccountPage.displayNameSA.getAttribute("value"),username);
    }
    @Test
    public void testCase07() {
        /*Kullanıcı 'Display name' text kutusunu bos birakamamali*/

        // 'Display name' kutusunun icindeki yaziyi sil
        ReusableMethods.bekle(2);
        myAccountPage.displayNameSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //'FIRST NAME is a required field.' yazisinin goruldugunu dogrula
        Assert.assertEquals(myAccountPage.requiredField.getText(),"DISPLAY NAME is a required field.");
    }
    @Test
    public void testCase08() {
        /*Kullanıcı email bilgilerini değiştirebilmeli*/

        // 'Email address' kutusuna yeni bir email gir
        ReusableMethods.bekle(2);
        myAccountPage.emailSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        String email=faker.internet().emailAddress();
        myAccountPage.emailSA.sendKeys(email);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        // 'Account details changed successfully.' yazisinin goruldugunu dogrula
        Assert.assertTrue(myAccountPage.changedSuccessfullMessage.isDisplayed());
        Assert.assertEquals(myAccountPage.emailSA.getAttribute("value"),email);
        
        ///////
        ReusableMethods.scrollHome();
        myAccountPage.emailSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        myAccountPage.emailSA.sendKeys(ConfigReader.getProperty("email1SA"));
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();
    }
    @Test
    public void testCase09() {
        /*Kullanıcı email text kutusunu bos birakamamali*/

        // 'Email address' kutusunun icindeki yaziyi sil
        ReusableMethods.bekle(2);
        myAccountPage.emailSA.sendKeys(Keys.META,"a",Keys.BACK_SPACE);
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //'FIRST NAME is a required field.' yazisinin goruldugunu dogrula
        Assert.assertEquals(myAccountPage.requiredField.getText(),"EMAIL ADDRESS is a required field.");
    }
    @Test
    public void testCase10() {
        /*Kullanıcı 'Biography' bölümünü doldurabilmeli*/

        //'Biography' text kutusuna metin ekle
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        String text=faker.harryPotter().quote();
        Driver.getDriver().switchTo().frame(0);
        actions.click(myAccountPage.biographySA).perform();
        myAccountPage.biographySA.sendKeys(text);
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().defaultContent();

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        // 'Account details changed successfully.' yazisinin goruldugunu dogrula
        Assert.assertTrue(myAccountPage.changedSuccessfullMessage.isDisplayed());
        Driver.getDriver().switchTo().frame(0);
        Assert.assertTrue(myAccountPage.biographySA.getText().contains(text));
    }

    @Test
    public void test11() {
        /*Kullanıcı Password'u değiştirebilmeli*/


        // 'Current password leave blank to leave unchanged' kutusuna mecvut password'u gir
        ReusableMethods.bekle(2);
        myAccountPage.currentPasswordSA.sendKeys(ConfigReader.getProperty("password1SA"));

        // 'New password leave blank to leave unchanged' kutusuna yeni bir password gir
        //Confirm password' kutusunu doldur
        String newPass=faker.internet().password(12,15,true,true,true);
        myAccountPage.newPasswordSA.sendKeys(newPass, Keys.TAB,newPass);

        //Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //Account details changed successfully.' yazisinin goruldugunu dogrula
        Assert.assertTrue(myAccountPage.changedSuccessfullMessage.isDisplayed());

        ///////
        myAccountPage.currentPasswordSA.sendKeys(newPass,Keys.TAB,ConfigReader.getProperty("password1SA"),Keys.TAB,ConfigReader.getProperty("password1SA"),Keys.ENTER);

    }

    @Test
    public void testCase012() {
        /*Kullanıcı 'Current password leave blank to leave unchanged' kutusunu bos biraktiginda Password'u değişmemeli*/

        //  'Current password leave blank to leave unchanged' kutusu bos birak

        // 'New password leave blank to leave unchanged' kutusuna yeni bir password gir
        ReusableMethods.bekle(2);
        String newPass=faker.internet().password(12,15,true,true,true);
        myAccountPage.newPasswordSA.sendKeys(newPass);
        ReusableMethods.bekle(2);

        //Confirm password kutusuna password u gir
        myAccountPage.confirmPasswordSA.sendKeys(newPass);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //'Please enter your current password.' yazisinin goruldugunu dogrula
        Assert.assertEquals(myAccountPage.requiredField.getText(),"Please enter your current password.");
    }

    @Test
    public void testCase013() {
        /*Kullanıcı 'Current password leave blank to leave unchanged' kutusunu bos biraktiginda Password'u değişmemeli*/

        // 'Current password leave blank to leave unchanged' kutusuna password u gir
        ReusableMethods.bekle(2);
        myAccountPage.currentPasswordSA.sendKeys(ConfigReader.getProperty("password1SA"));
        // 'New password leave blank to leave unchanged' kutusuna yeni bir password gir
        myAccountPage.newPasswordSA.sendKeys(faker.internet().password(12,15,true,true,true));

        //Confirm password kutusuna farkli bir password gir
        myAccountPage.confirmPasswordSA.sendKeys(faker.internet().password(12,15,true,true,true));
        ReusableMethods.bekle(2);

        // 'Save Changes' butonuna tikla
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        myAccountPage.saveChangesButton.click();

        //'New passwords do not match.' yazisinin goruldugunu dogrula
        Assert.assertEquals(myAccountPage.requiredField.getText(),"New passwords do not match.");
    }



    @AfterMethod
    public void tearDown() {
        //Driver.closeDriver();
    }
}

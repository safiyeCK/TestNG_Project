package team02.tests.US_02;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCasesUS02 {
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    @Test
    public void TC01() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna,önceden kayıtlı Username gir
        //4	Your Email address kutusuna önceden kayıtlı email gir
        //5	Password kutusuna önceden kayıtlı password gir
        registerPage.userNameDB.sendKeys(ConfigReader.getProperty("userNameKayitliDB"), Keys.TAB,
                ConfigReader.getProperty("emailKayitliDB"),Keys.TAB,ConfigReader.getProperty("passwordKayitliDB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(2);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }

    @Test
    public void TC02() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna,önceden kayıtlı Username gir
        //4	Your Email address kutusuna yeni bir mail gir
        //5	Password kutusuna yeni bir password gir
        registerPage.userNameDB.sendKeys(ConfigReader.getProperty("userNameKayitliDB"), Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }
    @Test
    public void TC03() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna,yeni bir username gir
        //4	Your Email address kutusuna kayıtlı bir email gir
        //5	Password kutusuna yeni bir password gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB,
                ConfigReader.getProperty("emailKayitliDB"),Keys.TAB,faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }
    @Test
    public void TC04() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna,yeni bir username gir
        //4	Your Email address kutusuna yeni bir email gir
        //5	Password kutusuna kayıtlı bir password gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,ConfigReader.getProperty("passwordKayitliDB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşdiğini doğrula
        Assert.assertTrue(registerPage.signOutButton.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void TC05() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusunu boş bırak
        //4	Your Email address kutusuna yeni bir email gir
        //5	Password kutusuna geçerli bir password gir
        registerPage.userNameDB.sendKeys(Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }

    @Test
    public void TC06() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna yeni bir username gir
        //4	Your Email address kutusunu boş bırak
        //5	Password kutusuna geçerli bir password gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(),Keys.TAB,
                Keys.TAB,faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }
    @Test
    public void TC07() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna kayitli bir username gir
        //4	Your Email address kutusuna kayitli bit email gir
        //5	Password kutusunu bos birak
        registerPage.userNameDB.sendKeys(ConfigReader.getProperty("userNameKayitliDB"), Keys.TAB,
                ConfigReader.getProperty("emailKayitliDB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }

}



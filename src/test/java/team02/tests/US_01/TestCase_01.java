package team02.tests.US_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import team02.pages.RegisterPage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

public class TestCase_01 {
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    @Test
    public void TC01() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleştiğini doğrula
        Assert.assertTrue(registerPage.signOutButton.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void TC02() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusunu boş bırak
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna bir şifre gir
        registerPage.userNameDB.sendKeys( Keys.TAB, faker.internet().emailAddress(), Keys.TAB, faker.internet().password(true));
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
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusunu boş bırak
        //5	Password kutusuna bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB, Keys.TAB, faker.internet().password(true));
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
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB, faker.internet().emailAddress(), Keys.ENTER);
        //5	Password kutusunu boş bırak
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7 SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();

    }

    @Test
    public void TC05() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seçme
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }

    @Test//FAIL
    public void TC06() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna icinde sembol olan bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna bir şifre gir
        registerPage.userNameDB.sendKeys(ConfigReader.getProperty("userNameSembolDB"), Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleştiğini doğrula(kayit gerceklesmez )

        Driver.closeDriver();
    }
    @Test
    public void TC07() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna, @ sembolü olmadan email gir
        //5	Password kutusuna bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(), Keys.TAB,
                ConfigReader.getProperty("emailIsaretsizDB"), Keys.TAB, faker.internet().password(true));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(3);
        //8	Kayıt işleminin gerçekleşmediğini doğrula --Kayıt işlemi gerçekleşmez. "Please include an '@' in the email address. '' is missing an '@'. yazisi gozukur

        Driver.closeDriver();
    }
    @Test
    public void TC08() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna 12 karakterli bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(),Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, ConfigReader.getProperty("password08DB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(2);
        //8	Kayıt işleminin gerçekleştiğini doğrula
        Assert.assertTrue(registerPage.signOutButton.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void TC09() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna 13 karakterli bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(),Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, ConfigReader.getProperty("password09DB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(2);
        //8	Kayıt işleminin gerçekleştiğini doğrula
        Assert.assertTrue(registerPage.signOutButton.isEnabled());
        Driver.closeDriver();
    }

    @Test//Norlmade 11 ile kayit olmamali oldu FAIL
    public void TC10() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna 11 karakterli bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(),Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, ConfigReader.getProperty("password10DB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(2);
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }
    @Test
    public void TC11() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna 19 karakterli bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(),Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, ConfigReader.getProperty("password11DB"));
        //6	I agree to the privacy policy kontrol kutusunu seç
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        ReusableMethods.bekle(2);
        //8	Kayıt işleminin gerçekleştiğini doğrula
        Assert.assertTrue(registerPage.signOutButton.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void TC12() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusuna bir kullanıcı adı gir
        //4	Your Email address kutusuna bir email gir
        //5	Password kutusuna 5 karakterli bir şifre gir
        registerPage.userNameDB.sendKeys(faker.name().fullName(),Keys.TAB,
                faker.internet().emailAddress(), Keys.TAB, ConfigReader.getProperty("password12DB"));
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
    public void TC13() {
        //1	Siteye git
        //2	Register linkine tıkla
        ReusableMethods.signUpDB();
        //3	Username kutusunu boş bırak
        //4	Your Email address kutusunu boş bırak
        //5	Password kutusunu boş bırak
        //6	I agree to the privacy policy kontrol kutusunu seç
        ReusableMethods.bekle(2);
        registerPage.policyTik.click();
        ReusableMethods.bekle(2);
        //7	SIGN UP butonuna tıkla
        registerPage.loginButonuDB.click();
        //8	Kayıt işleminin gerçekleşmediğini doğrula

        Driver.closeDriver();
    }
}
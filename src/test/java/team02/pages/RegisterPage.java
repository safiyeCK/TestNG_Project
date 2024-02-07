package team02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

public class RegisterPage {
    public RegisterPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    //musteri  ve vendor icin SIGN IN locate'leri
    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement signInKutusu;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInLoginButton;
    @FindBy(xpath = "//*[@class='login logout inline-type']")
    public WebElement signOutButton;
    @FindBy(xpath = "//*[@id='reg_username']")
    public WebElement UserNameSo;
    @FindBy(xpath = "//*[@id='reg_email']")
    public WebElement SUpYourEMail;
    @FindBy(xpath = "(//*[@type='checkbox'])[2]")
    public WebElement policyTikSo;
    @FindBy(xpath = "//*[@id='reg_password']")
    public WebElement SUpYourPass;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement signUpLoginButtonSo;



    //musteri icin SIGN UP locate'leri (26-79) //Durdygul
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement register;
    @FindBy(xpath = "(//a[@class='nav-link active'])[1]")
    public WebElement signUpKutusu;
    @FindBy(css = "#reg_username")
    public WebElement userNameDB;
    @FindBy(css = "#register-policy")
    public WebElement policyTik;
    @FindBy(css = "button[name='register']")
    public WebElement loginButonuDB;
    @FindBy(xpath = "#reg_password")
    public WebElement passwordDB;
    @FindBy(xpath = "(//p[@class='submit-status'])[2]")
    public WebElement verifyAlreadyRegisteredDB;




























    //vendor SIGN UP locate'leri (80-150) //Yunus
    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement emailBoxYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[1]")
    public WebElement verificationCodeTextYK;
    @FindBy(xpath = "(//*[@type='text'])[2]")
    public WebElement verificationCodeBoxYK;
    @FindBy(xpath = "(//*[@type='password'])[1]")
    public WebElement passwordBoxYK;

    @FindBy(xpath = "//*[@value='Register']")
    public WebElement registerButtonYK;

    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement welcomeTextYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement emailAgainTextYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement emailEmptyTextYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[1]")
    public WebElement emailFalseTextYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement verificationFalseTextYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement passwordEmptyTextYK;
    @FindBy(xpath = "//*[@id='password_strength']")
    public WebElement passwordGoodMessageYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement passwordStrenghtTextYK;
    @FindBy(xpath = "(//*[@tabindex='-1'])[2]")
    public WebElement passwordsNotSameYK;




























































    //vendor SIGN UP locate'leri (150-200) // Ibrahim
    @FindBy(xpath = "(//*[.='Register'])[2]")
    public WebElement registerLinki_IO;

    @FindBy(xpath = "(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVendorLinki_IO;

    @FindBy(css = "#passoword")
    public WebElement passwordKutusu_IO;

    @FindBy(xpath = "//*[.='Too short']")
    public WebElement tooShortYazisi_IO;

    @FindBy(xpath = "//*[.='Weak']")
    public WebElement weakYazisi_IO;

    @FindBy(xpath = "//*[.='Good']")
    public WebElement goodYazisi_IO;

    @FindBy(xpath = "//*[.='Strong']")
    public WebElement strongYazisi_IO;






}//finish 150

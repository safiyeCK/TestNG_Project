package team02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

public class UserMyAccountPage {
    public UserMyAccountPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }










    //sena (20-40)
    @FindBy (xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement myAccountSA;
    @FindBy (xpath = "(//h2)[1]")
    public WebElement myAccountBaslikSA;
    @FindBy (xpath = "(//li//a)[7]")
    public WebElement accountDetailsSA;
    @FindBy (xpath = "(//h4)[2]")
    public WebElement accountDetailsBaslikSA;
    @FindBy (xpath = "(//p//input)[1]")
    public WebElement firstNameSA;
    @FindBy (xpath = "//*[@value='Save changes']")
    public WebElement saveChangesButton;
    @FindBy (xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement changedSuccessfullMessage;
    @FindBy (xpath = "//*[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement requiredField;


    // saadet (41-105)
    //////BillingAddress Locateleri //////
    @FindBy(id = "menu-item-1079")
    public WebElement MyAccountButonu;
    @FindBy(xpath = "//*[@class='icon-box-icon icon-addresses']")
    public WebElement AddressesButonu;
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address is-active']")
    public WebElement billingIcindekiAddressesButonu;
    @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement billingAddButonu;
    @FindBy(xpath = "//*[@value='prayag.ahnaf@feerock.com']")
    public WebElement billingMailAddressKutusu;
    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement billingFirstNameKutusu;
    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement billingLastNameKutusu;
    @FindBy(xpath = "//*[@id='billing_company']")
    public WebElement billingCompanyKutusu;
    @FindBy(xpath = "//*[@id='billing_country']")
    public WebElement billingCountryRegiondDmKutusu;
    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement billingStreetAddressKutusu1;
    @FindBy(xpath = "//*[@id='billing_address_2']")
    public WebElement billingStreetAddressKutusu2;
    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement billingTownCityKutusu;
    @FindBy(xpath = "//*[@id='billing_postcode']")
    public WebElement billingZipCodeKutusu;
    @FindBy(xpath = "//*[@id='billing_phone']")
    public WebElement billingPhoneKutusu;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement billingsaveAddressKutusu;
    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement billingProvinceKutusu;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement billingEDITYOURBILLINGADDRESSButonu;
    @FindBy(xpath = "//*[text()='Address changed successfully.']")
    public WebElement billingAddressChangedSuccessfullyMesaji;
    @FindBy(xpath = "//*[@data-id='billing_first_name']")
    public WebElement billingFirstNameNegatifMesaji;
    @FindBy(xpath = "//*[@data-id='billing_last_name']")
    public WebElement billingLastnameNegatifMesaji;
    @FindBy(xpath = "//*[@data-id='billing_country']")
    public WebElement billingCountryDdmNegatifMesaji;
    @FindBy(xpath = "//*[@data-id='billing_state']")
    public WebElement billingstateDdmNegatifMesaji;
    @FindBy(xpath = "//*[@data-id='billing_address_1']")
    public WebElement billingStreetADNegatifMesaji;
    @FindBy(xpath = "//*[@data-id='billing_postcode']")
    public WebElement billingPostCodeZIPMesaji;
    @FindBy(xpath = "//*[@data-id='billing_city']")
    public WebElement billingTownCityMesaji;
    @FindBy(xpath = "//*[@data-id='billing_phone']")
    public WebElement billingPhoneNegatifMesaji;

    ///////ShippingAddress Locateleri///////
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement shippingAddButonu;
    @FindBy(xpath = "(//*[@type='text'])[1]")
    public WebElement shippingFirstNameKutusu;
    @FindBy(xpath = "(//*[@type='text'])[2]")
    public WebElement shippingLastNameKutusu;
    @FindBy(xpath = "(//*[@type='text'])[3]")
    public WebElement shippingCompanyKutusu;
    @FindBy(xpath = "(//select)[1]")
    public WebElement shippingCountryDdmKutusu;
    @FindBy(xpath = "(//select)[2]")
    public WebElement shippingStatedDmKutusu;
    @FindBy(xpath = "(//*[@type='text'])[4]")
    public WebElement shippingStreetAddressKutusu1;
    @FindBy(xpath = "(//*[@type='text'])[5]")
    public WebElement shippingStreetAddressKutusu2;
    @FindBy(xpath = "//*[@name='shipping_city']")
    public WebElement shippingTownCityKutusu;
    @FindBy(xpath = "(//select)[2]")
    public WebElement shippingProvinceDdmKutusu;
    @FindBy(xpath = "(//*[@class='input-text '])[6]")
    public WebElement shippingZipCodeKutusu;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement shippingSaveAddressKutusu;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement shippingEditYourKutusu;
 @FindBy(xpath = "//*[@data-id='shipping_first_name']")
    public WebElement shippingFirstNameNegatifMesaji;
 @FindBy(xpath = "//*[@data-id='shipping_last_name']")
    public WebElement shippingLastNameNegatifMesaji;

 @FindBy(xpath = "//*[@data-id='shipping_address_1']")
    public WebElement shippingStreetNegatifMesajKutusu;
@FindBy(xpath = "//*[text()='Postcode / ZIP is a required field.']")
    public WebElement shippingPostCodeZIPNegatifMesajKutusu;
@FindBy(xpath = "//*[text()='Town / City is a required field.']")
    public WebElement shippingTownCityNegatifMesajKutusu;
@FindBy(xpath = "//*[@data-id='shipping_country']")
    public WebElement shippingCountryDdmNegatifMesajKutusu;
@FindBy(xpath = "//*[@data-id='shipping_state']")
    public WebElement shippingStateDdmNegatifMesajKutusu;
@FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement shippingAddressSuccessfullMesaji;


















//Sena
    @FindBy (xpath = "(//p//input)[2]")
    public WebElement lastNameSA;
    @FindBy (xpath = "(//p//input)[3]")
    public WebElement displayNameSA;
    @FindBy (xpath = "(//p//input)[4]")
    public WebElement emailSA;
    @FindBy (css = "#tinymce")
    public WebElement biographySA;
   @FindBy (xpath = "(//p//input)[5]")
    public WebElement currentPasswordSA;
    @FindBy (xpath = "(//p//input)[6]")
    public WebElement newPasswordSA;
    @FindBy (xpath = "(//p//input)[7]")
    public WebElement confirmPasswordSA;
    @FindBy (xpath = "(//p//input)[11]")
    public WebElement scrollSifreIcin;



}//finish 170
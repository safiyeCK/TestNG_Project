package team02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

public class CartPage {
    public CartPage (){
    PageFactory.initElements(Driver.getDriver(), this);
}









//rukiye (21-60)
    @FindBy (xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']")
    public WebElement urunDogrulamaRA;
    @FindBy (xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement urunArttirmaRA;
    @FindBy (xpath = "(//button[@type='submit'])[3]")
    public WebElement upDateCartRA;
    @FindBy (xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedtoCheckoutButtonRA;
    @FindBy (xpath = "//div[@class='mobile-menu-wrapper']")
    public WebElement screenshotRA;
    @FindBy (xpath = "//ul[@class='wc_payment_methods payment_methods methods']")
    public WebElement odemeSecenegiSecmeRA; //
    @FindBy (xpath = "//button[@class='button alt']")
    public WebElement placeeOrderRA;
    @FindBy (xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement siparisTamanlandiRA;
    @FindBy (xpath = "//input[@class='input-text form-control mb-4']")
    public WebElement kuponCodRA;
  






















    // yunus(61-80)
@FindBy(xpath = "(//*[@type='text'])[3]")
public WebElement firstNameBoxYK;
    @FindBy(xpath = "//*[@type='tel']")
    public WebElement telBoxYK;
    @FindBy(xpath = "(//*[@type='submit'])[4]")
    public WebElement placeOrderButonuYK;
    @FindBy(xpath = "(//*[@aria-haspopup='true'])[2]")
    public WebElement provinceBoxYK;
    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement orderTextYK;





  
  

 
    //ramazan(81-)
    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement addToCartRA;

    @FindBy(xpath = "(//*[@class='w-icon-cart'])[1]")
    public  WebElement cartClickRA;

    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkOutRA;

    @FindBy(xpath = "//*[@class='product_title entry-title']")
    public WebElement randomUrunRA;
    @FindBy(xpath = "//td[@class='product-name']")
    public WebElement yourOrderdakiIlkUrunRA;

    @FindBy(xpath =  "//*[@class='remove remove_from_cart_button']")
    public WebElement urunCarpiRA;

    @FindBy(xpath = "//*[@class='cart-item-meta mini-item-meta']")
    public WebElement shoppingCartRA;

    @FindBy(xpath = "(//*[@class='input-text '])[1]")
    public WebElement zorunlularRA;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement streetAdress;

    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement orderCompletedRA;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderRA;
    @FindBy(xpath = "//*[@value='SUBSCRIBE']")
    public WebElement subscribeRA;

    @FindBy(xpath = "//*[@class='order-total']")
    public WebElement totalRA;

    @FindBy(xpath = "(//*[@class='input-radio'])[1]")
    public WebElement payWireTransferRA;

    @FindBy(xpath = "(//*[@class='input-radio'])[2]")
    public WebElement payAtTheDoorRA;

    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thankYouRA;

    @FindBy(xpath = "//*[@id='menu-item-1066']")
    public WebElement myOrdersRA;

    @FindBy(xpath = "(//*[@class='woocommerce-button btn btn-default btn-rounded btn-outline btn-sm btn-block view'])[1]")
    public WebElement ilkOrderViewRA;

    @FindBy(xpath = "//*[@class='woocommerce-order-details__title']")
    public WebElement orderDetailsRA;

    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement viewCartRA;

    @FindBy(xpath = "//*[@class='input-text form-control mb-4']")
    public WebElement enterCouponCodeRA;

    @FindBy(xpath = "//*[@class='btn btn-rounded btn-border-thin btn-outline btn-dark button']")
    public WebElement applyCouponCodeRA;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/checkout-2/'])[3]")
    public WebElement proceedToCheckoutRA;
    @FindBy(xpath = "(//*[@class='form-control'])[1]")
    public WebElement searchButtonRA;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement successCouponRA;

  
  

}//finish 157
package team02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

public class HomePage {
    public HomePage (){
        PageFactory.initElements(Driver.getDriver(), this);}









    //sena (20-40)
    @FindBy (xpath = "(//h2)[14]" )
    public WebElement baslikPopularDepartmentsSA;
    @FindBy (xpath = "(//a[@href='https://allovercommerce.com/urun/chess/'])[5]" )
    public WebElement urunSatrancTahtasiSA;
     @FindBy (xpath = "(//a[@href='https://allovercommerce.com/urun/automatic-crusher/'])[3]" )
    public WebElement urunKiymaMakinasiSA;
    @FindBy (xpath = "//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")
    public WebElement tumUrunlerSA;












        //ramazan(41-61)




















        //rukiye(62-81).
    @FindBy (xpath = "(//*[@type='search'])[1]")
    public WebElement searchboxRA;
    @FindBy (xpath = "//li[text()='Search results for “iphone”']")
    public WebElement aramaSonucuRA;
    @FindBy (xpath = "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[1]")
    public WebElement ilkUrunRA;
    @FindBy (xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement addToCartButtonRA;
    @FindBy (xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement CartButtonRA;

    @FindBy (xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement urunAzaltmaRA;

  
  
  
  
  
  
   //yunus(83-101)
   @FindBy(xpath = "(//*[.='urun 1'])[1]")
   public WebElement urun1YK;
    @FindBy(xpath = "(//*[@data-title='Add to wishlist'])[1]")
    public WebElement kalpButonu1YK;
    @FindBy(xpath = "(//*[.='Automatic Crusher'])[4]")
    public WebElement urun2YK;

    @FindBy(xpath = "//*[@class='w-icon-heart']")
    public WebElement wishlistButonuYK;
    @FindBy(xpath = "(//*[@type='search'])[1]")
    public WebElement aramaButonuYK;
    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement registerButtonYK;
    @FindBy(xpath = "(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVendorButtonYK;
    @FindBy(xpath = "(//*[.='Vendor Registration'])[1]")
    public WebElement vendorRegisterTextYK;

    //yusuf(102-121)
@FindBy (css = "a[class='login inline-type']")
public WebElement signInYH;
@FindBy (css = "#username")
public WebElement userNameOrEmailYH;
@FindBy (css = "#password")
public WebElement passwordYH;
@FindBy (css = "button[name='login']")
public WebElement loginButonuYH;
@FindBy (xpath = "//li/a[.='My Account']")
public WebElement myAccountYH;

  
  
  
  
  
  
  
}//finish 121

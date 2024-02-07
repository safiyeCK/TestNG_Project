package team02.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

public class WishlistPage {
    public WishlistPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }









    //yunus(21-40)
    @FindBy(xpath = "(//table//tbody//td[5]//div//button)[1]")
    public WebElement quickViewButonu1YK;
    @FindBy(xpath = "(//*[.='Add to cart'])[1]") ////  (//table//tbody//td//div//button)[2]
    public WebElement addToCartButonu1YK;
    @FindBy(xpath = "(//*[.='Automatic Crusher'])[2]")
    public WebElement quickViewUrun1YK;
    @FindBy(xpath = "//*[@tabindex='1']")
    public WebElement viewCartButonu1YK;
    @FindBy(xpath = "(//div[@class='elementor-widget-container'])[10]")
    public WebElement cartButonu1YK;
    @FindBy(xpath = "//*[.='Checkout']")
    public WebElement checkoutButonu1YK;



















} //finish (41)
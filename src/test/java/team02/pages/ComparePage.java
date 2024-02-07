package team02.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team02.utilities.Driver;

public class ComparePage {
    public ComparePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }











    //sena(21-40)
    @FindBy (xpath = ("//*[.='Start Compare !']"))
    public WebElement startCompare;
    @FindBy (xpath = "//a[@class='btn-remove remove_from_compare fas fa-times']")
    public WebElement removeFromCompare;
    @FindBy (xpath = "(//a[@class='btn-remove remove_from_compare fas fa-times'])[2]")
    public WebElement removeFromCompare2;
    @FindBy (xpath = "//a[@class='compare-clean']")
    public WebElement cleanAll;
    @FindBy (xpath = "(//h2)[1]")
    public WebElement comparePageBaslik;
    @FindBy (xpath = "(//a[@class='compare-action remove_from_compare'])[1]")
    public WebElement removeFromComparePage;






}//finish 41
package team02.tests.US_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.ComparePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import java.util.List;

public class TestCase_05 {

    //Kullanıcı karşılaştırma listesindeki ürünlerin hepsini silip yeni ürünleri ekleyebilmeli
    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //"Compare Products" penceresinin acildigini dogrula
        ComparePage comparePage= new ComparePage();
        Assert.assertTrue(comparePage.startCompare.isDisplayed());

        //Açılan  "Compare Products" penceresinde "Clean All" yazisina  tıkla
        comparePage.cleanAll.click();

        //"Compare Products" listesinden butun urunlerin silindigini dogrula
        List<WebElement> compareProducts= Driver.getDriver().findElements(By.xpath("//a//figure"));
        Assert.assertEquals(compareProducts.size(), 0);

        //Anasayfaya geri dön
        Driver.getDriver().navigate().back();

        //Herhangi bir urune tikla
        ReusableMethods.urunSec();

        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare();

        //"Compare Products" listesine yeni urunun eklendigini dogrula
        List<WebElement> compareProducts3= Driver.getDriver().findElements(By.xpath("//a//figure"));
        Assert.assertEquals(compareProducts3.size(), 1);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

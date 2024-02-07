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

public class TestCase_07 {

    //Kullanıcı karşılatırma ekranından ürün silebilmeli
    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Herhangi bir urune tikla
        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        //"Compare Products" penceresinin acildigini dogrula
        //Anasayfaya geri dön
        //Herhangi bir urune tikla
        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare(26,2);

        //Açılan  "Compare Products" penceresinde "Start Compare" yazisina  tıkla
        ComparePage comparePage= new ComparePage();
        comparePage.startCompare.click();

        //Silmek istedigin urunun uzerindeki carpi isaretine tikla
        comparePage.removeFromComparePage.click();

        //"Compare" ekranindan istedigin urunun silindigini dogrula
        ReusableMethods.bekle(2);
        List<WebElement> compareProducts= Driver.getDriver().findElements(By.xpath("//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']"));
        Assert.assertEquals(compareProducts.size(),1);
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}

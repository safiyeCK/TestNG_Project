package team02.tests.US_07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import team02.pages.ComparePage;
import team02.pages.HomePage;
import team02.utilities.ConfigReader;
import team02.utilities.Driver;
import team02.utilities.ReusableMethods;

import java.util.List;

public class TestCase_02 {


    //Kullanıcı 4 üründen fazlasını karsılastırmak için seçememeli
    @Test
    public void test01() {
        //Siteye git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Herhangi bir urune tikla
        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        //"Compare Products" listesinde 4 ürün olana kadar ayni islemleri tekrarla

        Actions actions= new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN,Keys.PAGE_DOWN);
        HomePage homePage= new HomePage();
        ReusableMethods.compare(26,4);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);

        //Anayasfaya git
        //Herhangi bir urune tikla
        //Açılan ürün sekmesinde "terazi" simgesine tıkla
        ReusableMethods.compare(homePage.urunKiymaMakinasiSA);
        ComparePage comparePage=new ComparePage();
        ReusableMethods.click(comparePage.startCompare);

        // "Compare Products" listesinde hala 4 ürün oldugunu dogrula
        List<WebElement> compareProducts= Driver.getDriver().findElements(By.xpath("//*[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']"));
        Assert.assertEquals(compareProducts.size(), 4);

    }


    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}

package team02.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import team02.pages.CartPage;
import team02.pages.RegisterPage;
import team02.pages.UserMyAccountPage;
import team02.pages.VendorMyAccountPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;

public class ReusableMethods {

    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //Iframe Index
    public static void frameIndex(int index) {
        Driver.getDriver().switchTo().frame(index);
    }

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //Tüm Sayfa ScreenShot
    public static String tumSayfaResmi(String name) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String dosyaYolu = System.getProperty("user.dir") + "/target/Screenshots/" + name + tarih + ".png";
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dosyaYolu;
    }

    //WebElement ScreenShot
    public static void webElementResmi(WebElement element, String isim) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/team02/utilities/screenshot/" + isim + "_" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SetAttributeValue
    public static void setAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }

    //File Upload Robot Class
    public static void uploadFile(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(3000);
        } catch (Exception ignored) {

        }
    }
//(214-259) US_01 and US_02 / Durdygul
    public static void signUpDB(){
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        RegisterPage registerPage = new RegisterPage();
        registerPage.register.click();
        ReusableMethods.bekle(2);
    }













































    //(260-309) US_03 and US_04 / Saadet
    public static void signInMethods() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        RegisterPage registerPage = new RegisterPage();

        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("eMailSo"), Keys.TAB, ConfigReader.getProperty("pswSo"));
        registerPage.signInLoginButton.click();
        ReusableMethods.bekle(3);
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
    }

    public static void billingAddressDoldurmaMethodu() {
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        myAccountPage.billingFirstNameKutusu.sendKeys("Melike", Keys.TAB,
                "Mercan", Keys.TAB, "Team02 Company");
        Select select = new Select(myAccountPage.billingCountryRegiondDmKutusu);
        select.selectByVisibleText("Turkey");
        myAccountPage.billingStreetAddressKutusu1.sendKeys("Gülyaka");
        myAccountPage.billingStreetAddressKutusu2.sendKeys("Bahar , 22");
        myAccountPage.billingZipCodeKutusu.sendKeys("1100");
        myAccountPage.billingTownCityKutusu.sendKeys("Izmir");
        Select select1 = new Select(myAccountPage.billingProvinceKutusu); //?
        select1.selectByIndex(34); //?
        ReusableMethods.bekle(3);
        myAccountPage.billingPhoneKutusu.sendKeys("05378765432");
        ReusableMethods.scroll(myAccountPage.billingsaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.billingsaveAddressKutusu.click();
    }



















    //(310-359) US_05 and US_07 / Sena
    static Random random = new Random();
    static Actions actions = new Actions(Driver.getDriver());
    public static void urunSec() {
        int randomNum = random.nextInt(32); // 0 dahil, 32 hariç
        List<Integer> numOfNonproduct = Arrays.asList(4, 5, 6, 7, 8, 9, 14, 15);
        if (!numOfNonproduct.contains(randomNum)) {
            List<WebElement> allProducts = Driver.getDriver().findElements(By.xpath("//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']"));
            WebElement randomProduct = allProducts.get(randomNum);
            scroll(randomProduct);
            actions.sendKeys(Keys.PAGE_DOWN);
            click(randomProduct);
        } else {
            urunSec();}}
    public static void compare(WebElement element) {
        click(element);
        bekle(3);
        WebElement description = Driver.getDriver().findElement(By.xpath("(//li)[13]"));
        scroll(description);
        bekle(2);
        WebElement copmareButton = Driver.getDriver().findElement(By.xpath("(//*[@title='Compare'])[1]"));
        click(copmareButton);
        bekle(2);
        click(Driver.getDriver().findElement(By.xpath("//*[@class='compare-clean']")));}

    public static void compare(int urunidx, int sınır) {
        for (int i = 0; i < sınır - 1; i++) {
            click(Driver.getDriver().findElement(By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[" + (urunidx + i) + "]")));
            bekle(3);
            WebElement description = Driver.getDriver().findElement(By.xpath("(//li)[13]"));
            scroll(description);
            bekle(2);
            WebElement copmareButton = Driver.getDriver().findElement(By.xpath("(//*[@title='Compare'])[1]"));
            click(copmareButton);
            bekle(2);
            Driver.getDriver().navigate().back();}urunSec();
        compare();}

    public static void compare() {
        bekle(3);
        WebElement description = Driver.getDriver().findElement(By.xpath("(//li)[13]"));
        scroll(description);
        bekle(2);
        WebElement copmareButton = Driver.getDriver().findElement(By.xpath("(//*[@title='Compare'])[1]"));
        click(copmareButton);
        bekle(2);  }
  
  
  
  
//(360-409) US_06 and US_19 / Rukiye

















































//(410-459) US_08 and US_09 / Yunus

















































//(460-509) US_10 and US_11 / Ibrahim




  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    //(510-559) US_12 and US_13 / Emre
    public static void signInVendorEp() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("eMail1Ep"), Keys.TAB,
                ConfigReader.getProperty("passwordEp"), Keys.ENTER);
        ReusableMethods.bekle(3);
    }
    public static void vendorRegisterMethodu() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        VendorMyAccountPage myAccountPage = new VendorMyAccountPage();
        myAccountPage.register.click();
        myAccountPage.becomeVendor.click();

        Assert.assertTrue(myAccountPage.vendorRegistrationYazisi.isDisplayed());

        String fakeWindowHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("fakemailUrl"));
        myAccountPage = new VendorMyAccountPage();
        String fakeEmail = myAccountPage.fakeMail.getText();
        ReusableMethods.switchToWindow(0);
        myAccountPage.vendorRegisterEmail.sendKeys(fakeEmail);
        ReusableMethods.switchToWindow(1);
        ReusableMethods.bekle(4);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.bekle(4);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.visibleWait(myAccountPage.fakeMailDogrulamaMaili, 25);
        myAccountPage.fakeMailDogrulamaMaili.click();
        Driver.getDriver().switchTo().frame(myAccountPage.iframe);
        String verificationMaili = myAccountPage.fakeMailVerification.getText().replaceAll("[^0-9]", "");
        System.out.println(verificationMaili);
        ReusableMethods.switchToWindow(0);
        myAccountPage.verificationCode.sendKeys(verificationMaili);
        myAccountPage.password.sendKeys(ConfigReader.getProperty("verificationPassword"), Keys.TAB,
                ConfigReader.getProperty("verificationPassword"));
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0, 800);
        ReusableMethods.bekle(2);
        ReusableMethods.click(myAccountPage.vendorRegisterButonu);
        ReusableMethods.visibleWait(myAccountPage.notRightNow, 20);
        ReusableMethods.click(myAccountPage.notRightNow);
        Assert.assertTrue(myAccountPage.storeManagerYazisi.isDisplayed());
    }



    //(560-609) US_14 and US_15 / Safiye
//----Vendor Kayitli email alanina giris yapar---------
    public static void vendorKayitliKullaniciHesabinaGiris() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        RegisterPage vendorPage = new RegisterPage();
        vendorPage.signInKutusu.click();
        vendorPage.userName.sendKeys(ConfigReader.getProperty("email_SK"), Keys.TAB,
                ConfigReader.getProperty("password_SK"), Keys.ENTER);
    }


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

  

//(610-659) US_16 and US_18 / Yusuf








































    








        //(660-709) US_17 and US_20 / Ramazan
    public static void singInVendorRA() {
        RegisterPage registerPage=new RegisterPage();
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("email1RA"),
                Keys.TAB, ConfigReader.getProperty("password1RA"), Keys.ENTER);
        ReusableMethods.bekle(3);
    }

    public static void addToCartRA() {
        CartPage cartPage = new CartPage();
        if (!cartPage.addToCartRA.isEnabled() || !cartPage.addToCartRA.isDisplayed()) {
            Driver.getDriver().get("alloverUrl");
            ReusableMethods.urunSec();
            cartPage.addToCartRA.click();
        } else {
            cartPage.addToCartRA.click();
        }
    }

    public static void sepetiBosaltRA() {
        CartPage cartPage = new CartPage();
        cartPage.cartClickRA.click();
        cartPage.urunCarpiRA.click();
    }
























//sena (710-730)
    public static void signInSA(String email, String sifre){
        RegisterPage registerPage=new RegisterPage();
        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty(email), Keys.TAB, ConfigReader.getProperty(sifre), Keys.ENTER);
        ReusableMethods.visibleWait(Driver.getDriver().findElement(By.xpath("//*[.='Sign Out']")),5 );
    }














//saadet (731-800)

    public static void userBillingClearMethod() {
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        if (myAccountPage.billingFirstNameKutusu.isDisplayed()) {
            Actions actions = new Actions(Driver.getDriver());
            ReusableMethods.bekle(2);
            actions.scrollByAmount(0, 500).perform();
            // myAccountPage.billingEDITYOURBILLINGADDRESSButonu.click();
            ReusableMethods.bekle(1);
            myAccountPage.billingFirstNameKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingLastNameKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingCompanyKutusu.clear();
            ReusableMethods.bekle(1);
            actions.scrollByAmount(0, 500).perform();

            ReusableMethods.bekle(1);
            myAccountPage.billingStreetAddressKutusu1.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingStreetAddressKutusu2.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingZipCodeKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingTownCityKutusu.clear();
            ReusableMethods.bekle(1);
            myAccountPage.billingPhoneKutusu.clear();
        } else {
            myAccountPage.billingAddButonu.click();
        }


    }

    public static void shippingAddressDoldurmaMethodu() {
        UserMyAccountPage myAccountPage = new UserMyAccountPage();
        myAccountPage.shippingFirstNameKutusu.sendKeys("Melike", Keys.TAB,
                "Mercan", Keys.TAB, "Team02 Company",Keys.TAB);
        Select select = new Select(myAccountPage.shippingCountryDdmKutusu);
        select.selectByVisibleText("Turkey");
        myAccountPage.shippingStreetAddressKutusu1.sendKeys("Gülyaka");
        myAccountPage.shippingStreetAddressKutusu2.sendKeys("Bahar , 22");
        myAccountPage.shippingZipCodeKutusu.sendKeys("1100");
        myAccountPage.shippingTownCityKutusu.sendKeys("Izmir");
        Select select1 = new Select(myAccountPage.shippingProvinceDdmKutusu); //?
        select1.selectByIndex(34); //?
        ReusableMethods.bekle(3);
        ReusableMethods.scroll(myAccountPage.shippingSaveAddressKutusu);
        ReusableMethods.bekle(3);
        myAccountPage.shippingSaveAddressKutusu.click();

    }
      
      
      
      
      
      
      
      
      
      






    //emre (800-900)
    public static void signInVendor1Ep() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        RegisterPage registerPage = new RegisterPage();
        registerPage.signInKutusu.click();
        registerPage.userName.sendKeys(ConfigReader.getProperty("eMail2Ep"), Keys.TAB,
                ConfigReader.getProperty("passwordEp"), Keys.ENTER);
        ReusableMethods.bekle(3);
    }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    //son
      
      
      
      

}